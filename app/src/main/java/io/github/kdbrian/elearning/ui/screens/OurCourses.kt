package io.github.kdbrian.elearning.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import io.github.kdbrian.elearning.model.Course
import io.github.kdbrian.elearning.ui.components.CustomComposables
import io.github.kdbrian.elearning.ui.components.TopAppBar
import io.github.kdbrian.elearning.ui.theme.ElearningTheme
import io.github.kdbrian.elearning.ui.theme.primaryWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OurCourses(navController: NavController) {

    Scaffold(topBar = {
        TopAppBar(
            navController = navController,
            title = "Our Courses",
            endIcon = Icons.Outlined.Search
        )
    }, backgroundColor = primaryWhite) {
        Column(modifier = Modifier.padding(it)) {

            //TODO:insert segmented buttons
            SingleChoiceSegmentedButtonRow(modifier = Modifier.fillMaxWidth()) {

                SegmentedButton(
                    selected = true,
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(5.dp)
                ) {
                    Text(text = "Ongoing")
                }

                SegmentedButton(
                    selected = false,
                    onClick = { /*TODO*/ },
                    shape = RoundedCornerShape(5.dp)
                ) {
                    Text(text = "Completed")
                }
            }

            LazyColumn {
                items(items = Course.getTopCourses()) {
                    CustomComposables.CoursePreview(course = it)
                }
            }
        }
    }
}

@Preview
@Composable
fun OurCoursesPrev() {
    ElearningTheme {
        OurCourses(navController = rememberNavController())
    }
}