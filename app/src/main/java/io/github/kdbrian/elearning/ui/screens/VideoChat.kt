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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardDoubleArrowDown
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.MicNone
import androidx.compose.material.icons.rounded.Videocam
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import io.github.kdbrian.elearning.R
import io.github.kdbrian.elearning.ui.components.CustomComposables
import io.github.kdbrian.elearning.ui.theme.ElearningTheme

@Composable
fun VideoChat(navController: NavController) {
    Scaffold(
        topBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                CustomComposables.CircleClipedIcon(
                    icon = Icons.Rounded.ArrowBack,
                    iconTint = Color.Black
                )
            }
        }
    ) {
        Box(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {

            Image(
                painter = painterResource(id = R.drawable.full_length_portrait_of_confident_student_boy_going_to_school_holding_two_books_and_carrying_his_backpack_cheerful_teenager_walking_with_positive_fac_2a7tjwt_removebg_preview),
                contentDescription = null,
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .align(Alignment.TopEnd)
            ) {
                Card(
                    modifier = Modifier
                        .size(130.dp)
                        .align(Alignment.TopEnd)
                        .padding(end = 10.dp)
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.full_length_portrait_of_confident_student_boy_going_to_school_holding_two_books_and_carrying_his_backpack_cheerful_teenager_walking_with_positive_fac_2a7tjwt_removebg_preview),
                            contentDescription = null,
                            modifier = Modifier.fillMaxWidth(),
                        )
                    }
                }

               /*
                IconButton(
                    onClick = {  },
                    modifier = Modifier.align(Alignment.TopEnd)
                ) {
                    Icon(imageVector = Icons.Rounded.ArrowCircleUp, contentDescription = null)
                }*/

            }

            Row(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {

                    Card {
                        Text(text = "08:34", modifier = Modifier.padding(5.dp))
                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier,
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        IconButton(
                            onClick = { /*TODO*/ },
                            colors = IconButtonColors(containerColor = Color.Gray, contentColor = Color.White, disabledContainerColor = Color.Red, disabledContentColor = Color.Red)
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.Videocam,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(50.dp)
                                    .padding(10.dp)
                                    .clip(CircleShape)
                                    .background(color = Color.Gray)
                            )
                        }


                        Spacer(modifier = Modifier.width(20.dp))

                        IconButton(
                            onClick = { /*TODO*/ },
                            colors = IconButtonColors(containerColor = Color.Red, contentColor = Color.White, disabledContainerColor = Color.Red, disabledContentColor = Color.Red)
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.Call,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(50.dp)
                                    .padding(10.dp)
                                    .clip(CircleShape)
                                    .background(color = Color.Red)
                            )
                        }

                        Spacer(modifier = Modifier.width(20.dp))


                        IconButton(
                            onClick = { /*TODO*/ },
                            colors = IconButtonColors(containerColor = Color.Gray, contentColor = Color.White, disabledContainerColor = Color.Red, disabledContentColor = Color.Red)
                        ) {
                            Icon(
                                imageVector = Icons.Rounded.MicNone,
                                contentDescription = null,
                                modifier = Modifier
                                    .size(50.dp)
                                    .padding(10.dp)
                                    .clip(CircleShape)
                                    .background(color = Color.Gray)
                            )
                        }


                    }

                    Spacer(modifier = Modifier.height(20.dp))

                    Text(text = "Swipe down to hide chat")

                    Spacer(modifier = Modifier.height(10.dp))

                    Icon(
                        imageVector = Icons.Outlined.KeyboardDoubleArrowDown,
                        contentDescription = null
                    )

                }
            }
        }
    }
}

@Preview
@Composable
fun VideoChatPrev() {
    ElearningTheme {
        VideoChat()
    }
}
