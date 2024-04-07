package io.github.kdbrian.elearning.model

import androidx.annotation.DrawableRes
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import io.github.kdbrian.elearning.R

data class Course(
    val id: Int? = null,
    @DrawableRes val imagePreview: Int,
    val favourite: MutableState<Boolean> = mutableStateOf(false),
    val courseTitle: String,
    val progress: Float,
    val author: String = "Brain Kidiga",
    val numLectures: Int = 0,
    val courseDescription: String = "In this 8-hour project-based course, you will learn how to draft well. You'll be taught from the course beginning how to start, starting",
    val courseItems: List<CourseItem> = CourseItem.getCourseItems()
) {

    companion object {
        fun getTopCourses() = listOf(
            Course(
                1,
                R.drawable.side_back_rear_view_young_260nw_2155934773_removebg_preview,
                mutableStateOf(true), "Web Design", 30f, "Brain Kidiga", 15
            ),
            Course(
                2,
                R.drawable.side_back_rear_view_young_260nw_2155934773_removebg_preview,
                mutableStateOf(false),
                "Python Programming",
                45f,
                "Brain Kidiga",
                25
            ),
            Course(
                3,
                R.drawable.side_back_rear_view_young_260nw_2155934773_removebg_preview,
                mutableStateOf(true),
                "Android Programming",
                20f,
                "Brain Kidiga",
                225
            )
        )

        fun getCourseById(id: Int) = getTopCourses().first { it?.id == id }
    }
}
