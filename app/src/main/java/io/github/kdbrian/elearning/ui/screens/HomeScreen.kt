package io.github.kdbrian.elearning.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Brush
import androidx.compose.material.icons.rounded.EditCalendar
import androidx.compose.material.icons.rounded.Notifications
import androidx.compose.material.icons.rounded.Rocket
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import io.github.kdbrian.elearning.model.Course
import io.github.kdbrian.elearning.ui.components.CourseCard
import io.github.kdbrian.elearning.ui.components.HomeBottomBar
import io.github.kdbrian.elearning.ui.components.ItemCard
import io.github.kdbrian.elearning.ui.components.SearchBar
import io.github.kdbrian.elearning.ui.components.TopAppBar
import io.github.kdbrian.elearning.ui.theme.ElearningTheme
import io.github.kdbrian.elearning.ui.theme.darkBlue

@Composable
fun HomeScreen(navController: NavController) {

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = { HomeBottomBar(navController = navController) },
        topBar = { TopAppBar(navController, title = "Hi, Brian!", endIcon = Icons.Rounded.Notifications) }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .padding(12.dp)
        ) {

            Spacer(modifier = Modifier.height(30.dp))

            Text(
                text = "Find your favourite\nCourse here!",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(start = 10.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))

            SearchBar()

            Spacer(modifier = Modifier.height(20.dp))

            LazyRow(
                horizontalArrangement = Arrangement.SpaceAround,
                modifier = Modifier
                    .fillMaxWidth()
            ) {

                item {
                    ItemCard(icon = Icons.Rounded.Brush, text = "Design")
                }

                item {
                    ItemCard(icon = Icons.Rounded.Rocket, text = "Marketting")
                }

                item {
                    ItemCard(icon = Icons.Rounded.EditCalendar, text = "Editing")
                }
            }

            Spacer(modifier = Modifier.height(30.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 10.dp, end = 10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Text(text = "Trending Courses", fontSize = 25.sp, fontWeight = FontWeight.Bold)

                Text(text = "See All", color = darkBlue, fontSize = 15.sp)
            }

            Spacer(modifier = Modifier.height(30.dp))

            LazyRow {

                items(items = Course.getTopCourses()){

                    CourseCard(course = it)

                }

            }

        }

    }
}


@Preview
@Composable
fun HomePreview() {
    ElearningTheme {
        HomeScreen(navController = rememberNavController())
    }
}