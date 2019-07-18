package com.dj.sample.kickstarter.projects.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide


object GlideUtils {
    /**
     * Load the image into specified image view.
     */
    fun loadFeedThumbnail(defaultImage: Int, loadInto: ImageView, context: Context, path: String) {
        Glide.with(context)
            .load(path)
            .centerCrop()
            .placeholder(defaultImage)
            .into(loadInto);

    }
}