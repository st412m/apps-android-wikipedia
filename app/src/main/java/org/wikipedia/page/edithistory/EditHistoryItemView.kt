package org.wikipedia.page.edithistory

import android.content.Context
import android.content.res.ColorStateList
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.core.content.ContextCompat
import androidx.core.graphics.ColorUtils
import androidx.core.view.isVisible
import androidx.core.widget.ImageViewCompat
import org.wikipedia.R
import org.wikipedia.databinding.ItemEditHistoryBinding
import org.wikipedia.dataclient.mwapi.MwQueryPage
import org.wikipedia.util.DateUtil
import org.wikipedia.util.ResourceUtil
import org.wikipedia.util.StringUtil

class EditHistoryItemView(context: Context) : FrameLayout(context) {
    interface Listener {
        fun onClick()
        fun onLongClick()
        fun onUserNameClick(v: View)
        fun onToggleSelect()
    }

    var listener: Listener? = null
    private val binding = ItemEditHistoryBinding.inflate(LayoutInflater.from(context), this, true)

    init {
        layoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        binding.clickTargetView.setOnClickListener {
            listener?.onClick()
        }
        binding.clickTargetView.setOnLongClickListener {
            listener?.onLongClick()
            true
        }
        binding.selectButton.setOnClickListener {
            listener?.onToggleSelect()
        }
        binding.userNameText.setOnClickListener {
            listener?.onUserNameClick(it)
        }
    }

    fun setContents(itemRevision: MwQueryPage.Revision, currentQuery: String?) {
        val diffSize = itemRevision.diffSize
        StringUtil.setHighlightedAndBoldenedText(binding.diffText,
            StringUtil.getDiffBytesText(context, diffSize), currentQuery)
        if (diffSize >= 0) {
            val diffColor = if (diffSize > 0) R.attr.success_color else R.attr.secondary_color
            binding.diffText.setTextColor(ResourceUtil.getThemedColor(context, diffColor))
        } else {
            binding.diffText.setTextColor(ResourceUtil.getThemedColor(context, R.attr.destructive_color))
        }
        val userIcon = if (itemRevision.isAnon) R.drawable.ic_anonymous_ooui else if (itemRevision.isTemp) R.drawable.ic_temp_account else R.drawable.ic_user_avatar
        binding.userNameText.setIconResource(userIcon)

        if (itemRevision.comment.isEmpty()) {
            binding.editHistoryTitle.setTypeface(Typeface.SANS_SERIF, Typeface.ITALIC)
            binding.editHistoryTitle.setTextColor(ResourceUtil.getThemedColor(context, R.attr.secondary_color))
            binding.editHistoryTitle.text = context.getString(R.string.page_edit_history_comment_placeholder)
        } else {
            binding.editHistoryTitle.setTypeface(Typeface.SANS_SERIF, Typeface.NORMAL)
            binding.editHistoryTitle.setTextColor(ResourceUtil.getThemedColor(context, R.attr.primary_color))
            val historyTitle = if (itemRevision.minor) StringUtil.fromHtml(context.getString(R.string.page_edit_history_minor_edit, itemRevision.comment)) else itemRevision.comment
            StringUtil.setHighlightedAndBoldenedText(binding.editHistoryTitle, historyTitle, currentQuery)
        }
        StringUtil.setHighlightedAndBoldenedText(binding.userNameText, itemRevision.user, currentQuery)
        binding.editHistoryTimeText.text = DateUtil.getTimeString(context, DateUtil.iso8601DateParse(itemRevision.timeStamp))
    }

    fun setSelectedState(selectedState: Int) {
        val colorDefault = ResourceUtil.getThemedColor(context, R.attr.paper_color)
        val colorSecondary = ResourceUtil.getThemedColorStateList(context, R.attr.secondary_color)
        val colorUsername = ResourceUtil.getThemedColorStateList(context, R.attr.primary_color)
        val colorFrom = ResourceUtil.getThemedColor(context, R.attr.progressive_color)
        val colorTo = ResourceUtil.getThemedColor(context, R.attr.warning_color)
        binding.selectButton.isVisible = selectedState != EditHistoryListViewModel.SELECT_INACTIVE

        if (selectedState == EditHistoryListViewModel.SELECT_INACTIVE ||
                selectedState == EditHistoryListViewModel.SELECT_NONE) {
            binding.selectButton.setImageResource(R.drawable.ic_check_empty_24)
            ImageViewCompat.setImageTintList(binding.selectButton, colorSecondary)
            binding.cardView.setDefaultBorder()
            binding.cardView.setCardBackgroundColor(colorDefault)
            binding.userNameText.backgroundTintList = ResourceUtil.getThemedColorStateList(context, R.attr.background_color)
            binding.userNameText.setTextColor(colorUsername)
            binding.userNameText.iconTint = colorUsername
            binding.editHistoryTimeText.setTextColor(colorSecondary)
        } else if (selectedState == EditHistoryListViewModel.SELECT_FROM) {
            binding.selectButton.setImageResource(R.drawable.ic_check_circle_black_24dp)
            ImageViewCompat.setImageTintList(binding.selectButton, ColorStateList.valueOf(colorFrom))
            binding.cardView.strokeColor = colorFrom
            val cardBackground = ColorUtils.blendARGB(colorDefault, colorFrom, 0.05f)
            binding.cardView.setCardBackgroundColor(cardBackground)
            val buttonBackground = ColorUtils.blendARGB(cardBackground, colorFrom, 0.05f)
            binding.userNameText.backgroundTintList = ColorStateList.valueOf(buttonBackground)
            binding.userNameText.setTextColor(colorFrom)
            binding.userNameText.iconTint = ColorStateList.valueOf(colorFrom)
            binding.editHistoryTimeText.setTextColor(colorFrom)
        } else if (selectedState == EditHistoryListViewModel.SELECT_TO) {
            binding.selectButton.setImageResource(R.drawable.ic_check_circle_black_24dp)
            ImageViewCompat.setImageTintList(binding.selectButton, ColorStateList.valueOf(colorTo))
            binding.cardView.strokeColor = ContextCompat.getColor(context, R.color.orange500)
            val cardBackground = ColorUtils.blendARGB(colorDefault, colorTo, 0.05f)
            binding.cardView.setCardBackgroundColor(cardBackground)
            val buttonBackground = ColorUtils.blendARGB(cardBackground, colorTo, 0.05f)
            binding.userNameText.backgroundTintList = ColorStateList.valueOf(buttonBackground)
            binding.userNameText.setTextColor(colorTo)
            binding.userNameText.iconTint = ColorStateList.valueOf(colorTo)
            binding.editHistoryTimeText.setTextColor(colorTo)
        }
    }
}
