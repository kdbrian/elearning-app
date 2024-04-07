package io.github.kdbrian.elearning.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.kdbrian.elearning.R
import io.github.kdbrian.elearning.model.Course
import io.github.kdbrian.elearning.ui.theme.ElearningTheme
import io.github.kdbrian.elearning.ui.theme.primaryWhite

@Composable
fun CourseCard(
    course: Course
) {

    val isFav = remember {
        mutableStateOf(false)
    }

    val icon = when {
        isFav.value -> Icons.Filled.Favorite
        else -> Icons.Outlined.FavoriteBorder
    }

    val contentDescription = when {
        isFav.value -> "Remove from Favourites"
        else -> "Add to Favourites"
    }

    Box(
        modifier = Modifier
            .padding(5.dp)
            .wrapContentHeight()

//            .height(300.dp)
            .clip(RoundedCornerShape(20.dp))
    ) {

        Image(
            painter = painterResource(id = course.imagePreview),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxWidth()
        )

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .background(color = Color.White)
                .padding(horizontal = 10.dp, vertical = 20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Column {
                Text(text = course.courseTitle, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                Text(text = "${course.numLectures} lectures", color = Color.Gray)

            }

            IconButton(onClick = { /*TODO*/ }) {
                Column(
                    modifier = Modifier
                        .padding(vertical = 6.dp, horizontal = 5.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceAround
                ) {
                    Icon(
                        imageVector = icon,
                        contentDescription = null,
                        modifier = Modifier
                            .size(48.dp)
                            .clip(CircleShape)
                            .background(primaryWhite)
                            .padding(5.dp)
                    )
                }
            }
        }
    }

}

@Preview
@Composable
fun CourseCardPrev() {
    ElearningTheme {
        CourseCard(
            course = Course(
                imagePreview = R.drawable.side_back_rear_view_young_260nw_2155934773_removebg_preview,
                courseTitle = "UI/UX Design Course",
                numLectures = 20,
                progress = 30f
            )
        )
    }
}