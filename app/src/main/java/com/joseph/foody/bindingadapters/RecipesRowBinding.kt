package com.joseph.foody.bindingadapters

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import coil.load
import com.joseph.foody.R

@BindingAdapter("loadImageFromUrl")
fun loadImageFromUrl(imageView: ImageView, imageUrl: String) {
    imageView.load(imageUrl) {
        crossfade(600)
        error(R.drawable.ic_error_placeholder)
    }
}


@BindingAdapter("setNumberOfLikes")
fun setNumberOfLikes(textView: TextView, likes: Int) {
    textView.text = likes.toString()
}

@BindingAdapter("setNumberOfMinutes")
fun setNumberOfMinutes(textView: TextView, minutes: Int) {
    textView.text = minutes.toString()
}

@BindingAdapter("applyVeganColor")
fun applyVeganColor(view: View, vegan: Boolean) {
    if(vegan) {
        when(view) {
            is TextView -> {
                view.setTextColor(ContextCompat.getColor(view.context, R.color.green))
            }
            is ImageView -> {
                view.setColorFilter(ContextCompat.getColor(view.context, R.color.green))
            }
        }
    }
}