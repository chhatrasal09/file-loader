package com.file.Loader.utils

import android.content.Context
import android.graphics.drawable.Drawable
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat

object Utility {

    fun getColouredDrawable(context: Context, drawableId: Int, newColor: Int): Drawable? {
        return ContextCompat.getDrawable(context, drawableId)?.let {
            DrawableCompat.setTint(DrawableCompat.wrap(it), newColor)
            it
        }
    }
}