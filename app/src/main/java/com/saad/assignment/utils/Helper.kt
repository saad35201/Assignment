package com.saad.assignment.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.saad.assignment.R

object Helper {

    fun loadImage(ctx: Context,image: String,view: ImageView){
        Glide.with(ctx)
            .load(Constants.IMAGE_BASE_URL+image)
            .transition(DrawableTransitionOptions.withCrossFade())
            .placeholder(R.drawable.img_placeholder)
            .error(R.drawable.img_placeholder)
            .into(view)
    }

}