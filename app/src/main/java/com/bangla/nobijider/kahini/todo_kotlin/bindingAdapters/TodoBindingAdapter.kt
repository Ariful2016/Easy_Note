package com.bangla.nobijider.kahini.todo_kotlin.bindingAdapters

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bangla.nobijider.kahini.todo_kotlin.*

@BindingAdapter("app:setPriorityIcon")
fun setPriorityIcon(iv: ImageView, priority: String){
    val icon = when(priority){
        priority_low -> R.drawable.low_star_24
        priority_normal -> R.drawable.normal_star_24
        else -> R.drawable.high_star_24
    }

    iv.setImageResource(icon)
}

@BindingAdapter("app:setFormattedDate")
fun setFormattedDate(tv: TextView, date: Long){
    tv.text = getFormattedDateTime(date,"dd/MM/yyyy")
}

@BindingAdapter("app:setFormattedTime")
fun setFormattedTime(tv: TextView, time: Long){
    tv.text = getFormattedDateTime(time,"hh:mm a")
}

