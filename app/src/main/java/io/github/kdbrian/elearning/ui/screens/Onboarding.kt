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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
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
import io.github.kdbrian.elearning.ui.theme.ElearningTheme
import io.github.kdbrian.elearning.ui.theme.darkBlue
import io.github.kdbrian.elearning.ui.theme.primaryWhite

import io.github.kdbrian.elearning.nav.APPSCREENS
import androidx.compose.foundation.clickable

@OptIn(ExperimentalMaterial3Api::class)
@androidx.compose.runtime.Composable
fun OnboardingScreen(navController: NavController) {


    Box(modifier = Modifier.fillMaxSize()) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(color = darkBlue)
                .align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Image(
                painter = painterResource(id = R.drawable.full_length_portrait_of_confident_student_boy_going_to_school_holding_two_books_and_carrying_his_backpack_cheerful_teenager_walking_with_positive_fac_2a7tjwt_removebg_preview),
                contentDescription = null,
                modifier = Modifier
                    .fillMaxSize(),
                contentScale = ContentScale.Crop
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.TopCenter)
                .padding(20.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {

            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Rounded.ArrowBack,
                    contentDescription = "",
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(50.dp)
                        .background(color = darkBlue)
                        .alpha(0.3f)
                        .background(color = primaryWhite)
                )
            }

            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Skip")
            }
        }


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .height(360.dp)
                .clip(
                    CircleShape.copy(
                        bottomEnd = CornerSize(0.dp),
                        bottomStart = CornerSize(0.dp),
                        topStart = CornerSize(60.dp),
                        topEnd = CornerSize(60.dp)
                    )
                )
                .background(color = primaryWhite),
        ) {

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {

                Text(text = "Welcome", fontSize = 30.sp, fontWeight = FontWeight.Bold)

                Spacer(modifier = Modifier.height(10.dp))

                Text(text = "Our Courses", fontSize = 30.sp, fontWeight = FontWeight.Bold)
                Text(
                    text = "Here you can learn new and most\ninsteresting things for you",
                    fontSize = 20.sp,
                    textAlign = TextAlign.Center
                )

            }


            Card(
                onClick = { navController.navigate(APPSCREENS.HOME.name) },
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(20.dp)
                    .fillMaxWidth()
		    ,
                colors = CardDefaults.cardColors(
                    containerColor = darkBlue,
                    contentColor = Color.White
                ),
                elevation = CardDefaults.cardElevation(defaultElevation = 20.dp)
            ) {
                Text(
                    text = "Get Started",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(20.dp),
                    textAlign = TextAlign.Center,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp
                )
            }
        }
    }
}

@Preview
@Composable
fun DefPreview() {
    ElearningTheme {
        OnboardingScreen(navController = rememberNavController())
    }
}
