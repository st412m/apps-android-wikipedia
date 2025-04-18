package org.wikipedia.feed.suggestededits

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.wikipedia.Constants
import org.wikipedia.WikipediaApp
import org.wikipedia.dataclient.ServiceFactory
import org.wikipedia.dataclient.WikiSite
import org.wikipedia.dataclient.mwapi.MwQueryPage
import org.wikipedia.descriptions.DescriptionEditActivity
import org.wikipedia.page.Namespace
import org.wikipedia.page.PageTitle
import org.wikipedia.suggestededits.PageSummaryForEdit
import org.wikipedia.suggestededits.provider.EditingSuggestionsProvider
import org.wikipedia.util.Resource
import org.wikipedia.util.StringUtil

class SuggestedEditsCardItemViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {
    val age = savedStateHandle[SuggestedEditsCardItemFragment.EXTRA_AGE] ?: 0
    var cardActionType = savedStateHandle.get<DescriptionEditActivity.Action>(SuggestedEditsCardItemFragment.EXTRA_ACTION_TYPE)!!
    var sourceSummaryForEdit: PageSummaryForEdit? = null
    var targetSummaryForEdit: PageSummaryForEdit? = null
    var imageTagPage: MwQueryPage? = null

    private val _uiState = MutableStateFlow(Resource<Boolean>())
    val uiState = _uiState.asStateFlow()

    init {
        fetchCardData()
    }
    fun fetchCardData() {
        _uiState.value = Resource.Loading()
        viewModelScope.launch(CoroutineExceptionHandler { _, throwable ->
            // Give retry option to user in case of network error
            _uiState.value = Resource.Error(throwable)
        }) {
            val appLanguages = WikipediaApp.instance.languageState.appLanguageCodes
            val langFromCode = appLanguages.first()
            val targetLanguage = appLanguages.getOrElse(age % appLanguages.size) { langFromCode }
            if (appLanguages.size > 1) {
                if (cardActionType == DescriptionEditActivity.Action.ADD_DESCRIPTION && targetLanguage != langFromCode)
                    cardActionType = DescriptionEditActivity.Action.TRANSLATE_DESCRIPTION
                if (cardActionType == DescriptionEditActivity.Action.ADD_CAPTION && targetLanguage != langFromCode)
                    cardActionType = DescriptionEditActivity.Action.TRANSLATE_CAPTION
            }
            when (cardActionType) {
                DescriptionEditActivity.Action.ADD_DESCRIPTION -> {
                    sourceSummaryForEdit = addDescription(langFromCode)
                }
                DescriptionEditActivity.Action.TRANSLATE_DESCRIPTION -> {
                    translateDescription(langFromCode, targetLanguage).let {
                        sourceSummaryForEdit = it.first
                        targetSummaryForEdit = it.second
                    }
                }
                DescriptionEditActivity.Action.ADD_CAPTION -> {
                    sourceSummaryForEdit = addCaption(langFromCode)
                }
                DescriptionEditActivity.Action.TRANSLATE_CAPTION -> {
                    translateCaption(langFromCode, targetLanguage)?.let {
                        sourceSummaryForEdit = it.first
                        targetSummaryForEdit = it.second
                    }
                }
                DescriptionEditActivity.Action.ADD_IMAGE_TAGS -> {
                    imageTagPage = addImageTags()
                }
                DescriptionEditActivity.Action.IMAGE_RECOMMENDATIONS -> {
                    // ignore
                }
                else -> {
                    // ignore
                }
            }
            _uiState.value = Resource.Success(true)
        }
    }

    private suspend fun addDescription(langFromCode: String): PageSummaryForEdit {
        val pageSummary = EditingSuggestionsProvider.getNextArticleWithMissingDescription(
            WikiSite.forLanguageCode(langFromCode))

        return PageSummaryForEdit(
            pageSummary.apiTitle,
            langFromCode,
            pageSummary.getPageTitle(WikiSite.forLanguageCode(langFromCode)),
            pageSummary.displayTitle,
            pageSummary.description,
            pageSummary.thumbnailUrl,
            pageSummary.extract,
            pageSummary.extractHtml
        )
    }

    private suspend fun translateDescription(langFromCode: String, targetLanguage: String): Pair<PageSummaryForEdit, PageSummaryForEdit> {
        val pair = EditingSuggestionsProvider.getNextArticleWithMissingDescription(
            WikiSite.forLanguageCode(langFromCode), targetLanguage)
        val source = pair.first
        val target = pair.second

        return PageSummaryForEdit(
            source.apiTitle,
            langFromCode,
            source.getPageTitle(WikiSite.forLanguageCode(langFromCode)),
            source.displayTitle,
            source.description,
            source.thumbnailUrl,
            source.extract,
            source.extractHtml
        ) to PageSummaryForEdit(
            target.apiTitle,
            targetLanguage,
            target.getPageTitle(WikiSite.forLanguageCode(targetLanguage)),
            target.displayTitle,
            target.description,
            target.thumbnailUrl,
            target.extract,
            target.extractHtml
        )
    }

    private suspend fun addCaption(langFromCode: String): PageSummaryForEdit? {
        val title = EditingSuggestionsProvider.getNextImageWithMissingCaption(langFromCode,
            SuggestedEditsCardItemFragment.MAX_RETRY_LIMIT)
        val imageInfoResponse = ServiceFactory.get(Constants.commonsWikiSite).getImageInfo(title, langFromCode)
        val page = imageInfoResponse.query?.firstPage()
        return page?.imageInfo()?.let {
            return@let PageSummaryForEdit(
                page.title, langFromCode,
                PageTitle(
                    Namespace.FILE.name,
                    StringUtil.removeNamespace(page.title),
                    null,
                    it.thumbUrl,
                    WikiSite.forLanguageCode(langFromCode)),
                StringUtil.removeHTMLTags(page.title),
                it.metadata!!.imageDescription(),
                it.thumbUrl,
                null,
                null,
                it.timestamp,
                it.user,
                it.metadata
            )
        }
    }

    private suspend fun translateCaption(langFromCode: String, targetLanguage: String): Pair<PageSummaryForEdit, PageSummaryForEdit>? {
        val pair = EditingSuggestionsProvider.getNextImageWithMissingCaption(langFromCode, targetLanguage,
            SuggestedEditsCardItemFragment.MAX_RETRY_LIMIT
        )
        val fileCaption = pair.first
        val imageInfoResponse = ServiceFactory.get(Constants.commonsWikiSite).getImageInfo(pair.second, langFromCode)
        val page = imageInfoResponse.query?.firstPage()
        return page?.imageInfo()?.let {
            val sourceSummaryForEdit = PageSummaryForEdit(
                page.title,
                langFromCode,
                PageTitle(
                    Namespace.FILE.name,
                    StringUtil.removeNamespace(page.title),
                    null,
                    it.thumbUrl,
                    WikiSite.forLanguageCode(langFromCode)
                ),
                StringUtil.removeHTMLTags(page.title),
                fileCaption,
                it.thumbUrl,
                null,
                null,
                it.timestamp,
                it.user,
                it.metadata
            )
            val targetSummaryForEdit = sourceSummaryForEdit.copy(
                description = null,
                lang = targetLanguage,
                pageTitle = PageTitle(
                    Namespace.FILE.name,
                    StringUtil.removeNamespace(page.title),
                    null,
                    it.thumbUrl,
                    WikiSite.forLanguageCode(targetLanguage)
                )
            )
            return@let sourceSummaryForEdit to targetSummaryForEdit
        }
    }

    private suspend fun addImageTags(): MwQueryPage {
        return EditingSuggestionsProvider
            .getNextImageWithMissingTags(SuggestedEditsCardItemFragment.MAX_RETRY_LIMIT)
    }
}
