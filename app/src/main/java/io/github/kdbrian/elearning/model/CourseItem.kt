package io.github.kdbrian.elearning.model

import androidx.annotation.DrawableRes
import io.github.kdbrian.elearning.R

data class CourseItem(
    val title : String,
    val duration : String,
    @DrawableRes val previewLink : Int = R.drawable.side_back_rear_view_young_260nw_2155934773_removebg_preview,
    val resourceLink : String ? = null
) {

    companion object{

        fun getCourseItems() = listOf(
            CourseItem(title = "Intro to Design", duration = "30 Min"),
            CourseItem(title = "Definition of Design", duration = "2:39 Min"),
        )
    }
}