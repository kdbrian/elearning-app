package io.github.kdbrian.elearning.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import io.github.kdbrian.elearning.R
import io.github.kdbrian.elearning.model.Chat
import io.github.kdbrian.elearning.ui.components.CustomComposables
import io.github.kdbrian.elearning.ui.components.HomeBottomBar
import io.github.kdbrian.elearning.ui.components.SearchBar
import io.github.kdbrian.elearning.ui.theme.ElearningTheme
import io.github.kdbrian.elearning.ui.theme.darkBlue
import io.github.kdbrian.elearning.ui.theme.primaryWhite


@Composable
fun Chats(navController: NavController) {
    Scaffold(topBar = {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
        ) {

            Image(
                painter = painterResource(id = R.drawable.full_length_portrait_of_confident_student_boy_going_to_school_holding_two_books_and_carrying_his_backpack_cheerful_teenager_walking_with_positive_fac_2a7tjwt_removebg_preview),
                contentDescription = null,
                modifier = Modifier
                    .align(Alignment.CenterStart)
                    .size(50.dp)
                    .clip(CircleShape)
                    .background(color = darkBlue)
            )


//            Spacer(modifier = Modifier.width(20.dp))

            Text(text = "Chats", modifier = Modifier.align(Alignment.Center))

        }
    }, bottomBar = { HomeBottomBar(navController = navController)}) {
        Column(modifier = Modifier.padding(it)) {
            SearchBar(leadingIcon = Icons.Rounded.Search, containerColor = primaryWhite, placeHolder = "Search")


            LazyColumn {
                items(items = Chat.getChats()){
                    CustomComposables.ChatItem(chat = it)
                }
            }
        }
    }
}


@Preview
@Composable
fun ChatPreview() {
    ElearningTheme {
        Chats(navController = rememberNavController())
    }
}
