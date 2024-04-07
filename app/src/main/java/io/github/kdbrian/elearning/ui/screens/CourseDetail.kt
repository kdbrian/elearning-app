package io.github.kdbrian.elearning.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccessTime
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowForward
import androidx.compose.material.icons.rounded.FavoriteBorder
import androidx.compose.material.icons.rounded.PeopleOutline
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import io.github.kdbrian.elearning.R
import io.github.kdbrian.elearning.model.Course
import io.github.kdbrian.elearning.ui.components.CustomComposables
import io.github.kdbrian.elearning.ui.theme.ElearningTheme
import io.github.kdbrian.elearning.ui.theme.darkBlue2

@Composable
fun CourseDetail(course: Course, navController: NavController) {

    val scrollState = rememberScrollState()

    Scaffold(
        topBar = {
            CourseDetailTopBar(course, navController)
        },
        bottomBar = { CourseDetailBottomBar(course = course) },
        containerColor = Color.White
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .verticalScroll(state = scrollState)
                .padding(15.dp)
        ) {

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .clip(RoundedCornerShape(10.dp)),
            ) {

                Image(
                    painter = painterResource(id = course.imagePreview),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )

            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(text = course.courseTitle, fontSize = 25.sp, fontWeight = FontWeight.Bold)

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                CustomComposables.CircleClipedIcon(
                    icon = Icons.Rounded.AccessTime,
                    iconTint = Color.Black
                )

                Spacer(modifier = Modifier.width(5.dp))

                Column {
                    Text(text = "Total Duration")
                    Text(text = "9:30AM-11:30AM")
                }

                CustomComposables.CircleClipedIcon(
                    icon = Icons.Rounded.PeopleOutline,
                    iconTint = Color.Black
                )

                Spacer(modifier = Modifier.width(5.dp))

                Column {
                    Text(text = "Total Student")
                    Text(text = "250 Students")
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = course.courseDescription,
                modifier = Modifier.fillMaxWidth(),
                fontSize = 18.sp,
                fontWeight = FontWeight.Light,
                color = Color.Gray
            )
            Text(text = "See more", modifier = Modifier.fillMaxWidth(), fontSize = 18.sp)

            Spacer(modifier = Modifier.height(20.dp))

            LazyColumn {
                items(items = course.courseItems) {
                    CustomComposables.CourseItem(courseItem = it)
                }
            }
        }
    }
}

@Composable
fun CourseDetailBottomBar(course: Course) {

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {

        Surface(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .background(Color.White)
                .alpha(0.7f)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {

                Card(
                    colors = CardDefaults.cardColors(containerColor = darkBlue2)
                ) {
                    Text(
                        text = "$25",
                        modifier = Modifier
                            .padding(horizontal = 10.dp, vertical = 20.dp),
                        fontSize = 20.sp,
                        color = Color.White,
                        fontWeight = FontWeight.Bold
                    )
                }

                Spacer(modifier = Modifier.width(20.dp))

                Card(
                    modifier = Modifier
                        .weight(2.0f),
                    colors = CardDefaults.cardColors(containerColor = darkBlue2)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(horizontal = 10.dp, vertical = 20.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Spacer(modifier = Modifier.width(10.dp))
                        Text(
                            text = "Buy Now",
                            color = Color.White,
                            fontWeight = FontWeight.Bold,
                            textAlign = TextAlign.Center
                        )
                        Spacer(modifier = Modifier.width(5.dp))
                        Icon(
                            imageVector = Icons.Rounded.ArrowForward,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }
                }
            }

        }
    }

}

@Composable
fun CourseDetailTopBar(course: Course, navController: NavController) {
    Row(
        horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
    ) {
        CustomComposables.CircleClipedIcon(
            icon = Icons.Rounded.ArrowBack,
            iconTint = Color.Black
        ) {
            navController.popBackStack()
        }

        CustomComposables.CircleClipedIcon(
            icon = Icons.Rounded.FavoriteBorder,
            iconTint = Color.Black
        ) {
            course.favourite.value = !course.favourite.value
        }
    }
}

@Preview
@Composable
fun CourseDetailPrev() {
    ElearningTheme {
        CourseDetail(
            course = Course(
                imagePreview = R.drawable.side_back_rear_view_young_260nw_2155934773_removebg_preview,
                courseTitle = "UI/UX Design Course",
                numLectures = 20,
                progress = 34f
            ), navController = rememberNavController()
        )
    }
}