package org.wikipedia.random

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.wikipedia.Constants
import org.wikipedia.database.AppDatabase
import org.wikipedia.dataclient.WikiSite
import org.wikipedia.page.PageTitle
import org.wikipedia.util.Resource

class RandomViewModel(savedStateHandle: SavedStateHandle) : ViewModel() {
    private val handler = CoroutineExceptionHandler { _, throwable ->
        _uiState.value = Resource.Error(throwable)
    }
    val wikiSite = savedStateHandle.get<WikiSite>(Constants.ARG_WIKISITE)!!
    var saveButtonState = false

    private val _uiState = MutableStateFlow(Resource<Boolean>())
    val uiState = _uiState.asStateFlow()

    fun findPageInAnyList(title: PageTitle) {
        viewModelScope.launch(handler) {
            val inAnyList = AppDatabase.instance.readingListPageDao().findPageInAnyList(title) != null
            saveButtonState = inAnyList
            _uiState.value = Resource.Success(inAnyList)
        }
    }
}
