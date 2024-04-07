package io.github.kdbrian.elearning.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.LinearProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Person2
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Start
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.kdbrian.elearning.R
import io.github.kdbrian.elearning.model.Chat
import io.github.kdbrian.elearning.model.Course
import io.github.kdbrian.elearning.model.CourseItem
import io.github.kdbrian.elearning.ui.theme.ElearningTheme
import io.github.kdbrian.elearning.ui.theme.darkBlue
import io.github.kdbrian.elearning.ui.theme.lightBlue
import io.github.kdbrian.elearning.ui.theme.primaryWhite

object CustomComposables {

    @Composable
    fun CircleClipedIcon(
        modifier: Modifier = Modifier,
        icon: ImageVector,
        contentDescription: String? = null,
        iconTint: Color,
        onClick: (() -> Unit)? = null
    ) {

        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            modifier = modifier
                .clip(CircleShape)
                .background(color = primaryWhite)
                .padding(10.dp)
                .clickable {
                    onClick?.let {
                        onClick()
                    }
                },
            tint = iconTint
        )

    }

    @Composable
    fun CircleClipedArrowButtonColored(
        modifier: Modifier = Modifier,
        icon: ImageVector,
        contentDescription: String? = null,
        iconTint: Color,
        onClick: (() -> Unit)? = null
    ) {

        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            modifier = modifier
                .clip(CircleShape)
                .background(color = iconTint)
                .padding(10.dp)
                .clickable {
                    onClick?.let {
                        onClick()
                    }
                },
            tint = iconTint
        )

    }


    @Composable
    fun CourseItem(courseItem: CourseItem) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(color = primaryWhite, shape = RoundedCornerShape(10.dp))
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Row {

                    Image(
                        painter = painterResource(id = courseItem.previewLink),
                        contentDescription = null,
                        modifier = Modifier
                            .width(70.dp)
                            .height(70.dp)
                            .clip(RoundedCornerShape(5.dp)),
                        contentScale = ContentScale.Crop
                    )

                    Spacer(modifier = Modifier.width(20.dp))

                    Column {
                        Text(
                            text = courseItem.title,
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(5.dp))

                        Text(
                            text = courseItem.duration,
                            fontWeight = FontWeight.Light,
                            color = Color.Gray
                        )
                    }
                }

                Icon(
                    imageVector = Icons.Rounded.PlayArrow,
                    contentDescription = null,
                    Modifier.padding(20.dp)
                )

            }
        }
    }

    @Composable
    fun CoursePreview(course: Course) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .background(shape = RoundedCornerShape(10.dp), color = Color.White)
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Image(
                    painter = painterResource(id = course.imagePreview),
                    contentDescription = null,
                    modifier = Modifier.clip(RoundedCornerShape(5.dp))
                )

                Spacer(modifier = Modifier.width(20.dp))

                Column(horizontalAlignment = Start) {
                    Text(text = course.courseTitle, fontSize = 16.sp, fontWeight = FontWeight.Bold)

                    Row(verticalAlignment = Alignment.CenterVertically) {

                        Icon(imageVector = Icons.Outlined.Person2, contentDescription = null)

                        Spacer(modifier = Modifier.width(5.dp))

                        Text(
                            text = course.author,
                            fontSize = 15.sp,
                            fontWeight = FontWeight.Light,
                            color = Color.Gray
                        )
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(5.dp),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(text = "20/20 videos", fontWeight = FontWeight.Light)
                        Text(text = "${course.progress} %", fontWeight = FontWeight.Light)
                    }

                    Spacer(modifier = Modifier.height(5.dp))

                    LinearProgressIndicator(
                        progress = course.progress,
                        color = darkBlue,
                        backgroundColor = Color.Gray,
                        strokeCap = StrokeCap.Round,
                        modifier = Modifier
                            .padding(5.dp)
                    )


                }
            }

        }
    }

    @Composable
    fun ChatItem(chat: Chat) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            Box(modifier = Modifier){

                Image(
                    painter = painterResource(id = R.drawable.full_length_portrait_of_confident_student_boy_going_to_school_holding_two_books_and_carrying_his_backpack_cheerful_teenager_walking_with_positive_fac_2a7tjwt_removebg_preview),
                    contentDescription = null,
                    modifier = Modifier
                        .size(50.dp)
                        .clip(CircleShape)
                        .background(color = primaryWhite)
                )

                Text(
                    text = " ",
                    modifier = Modifier
                        .size(10.dp)
                        .background(shape = CircleShape, color = lightBlue)
                        .align(Alignment.BottomEnd)
                )
            }

            Spacer(modifier = Modifier.width(5.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Text(text = chat.userName, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                    Text(
                        text = chat.latestMessageTime,
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Light,
                        color = Color.Gray
                    )

                }

                Spacer(modifier = Modifier.height(10.dp))

                Text(text = chat.messages[0].content.substring(0, 35), fontSize = 15.sp, fontWeight = FontWeight.Light, color = Color.Gray)
            }

        }
    }
}


@Preview(showBackground = true)
@Composable
fun ChatItemPrev() {
    ElearningTheme {
        CustomComposables.ChatItem(chat = Chat.getChats()[0])
    }
}

@Preview
@Composable
fun CoursePreviewPrev() {
    ElearningTheme {
        CustomComposables.CoursePreview(
            course = Course(
                imagePreview = R.drawable.side_back_rear_view_young_260nw_2155934773_removebg_preview,
                courseTitle = "UI/UX Design Course",
                numLectures = 20,
                progress = 30f
            )
        )
    }
}

@Preview
@Composable
fun Demo() {

    ElearningTheme {
        CourseCard(
            course = Course(
                imagePreview = R.drawable.side_back_rear_view_young_260nw_2155934773_removebg_preview,
                courseTitle = "UI/UX Design Course",
                numLectures = 20,
                progress = 60f
            )
        )
    }
}

@Preview
@Composable
fun CircleClippedArrowPrev() {
    ElearningTheme {
        CustomComposables.CircleClipedIcon(
            icon = Icons.Rounded.Favorite,
            iconTint = Color.Black,
            modifier = Modifier
        )
    }
}

@Preview
@Composable
fun CourseItemPrev() {
    ElearningTheme {
        CustomComposables.CourseItem(courseItem = CourseItem.getCourseItems()[0])
    }
}