package io.github.kdbrian.elearning.ui.screens

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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material.icons.rounded.ArrowForwardIos
import androidx.compose.material.icons.rounded.Edit
import androidx.compose.material.icons.rounded.Logout
import androidx.compose.material.icons.rounded.Newspaper
import androidx.compose.material.icons.rounded.Payment
import androidx.compose.material.icons.rounded.Payments
import androidx.compose.material.icons.rounded.Person3
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import io.github.kdbrian.elearning.R
import io.github.kdbrian.elearning.ui.components.CustomComposables
import io.github.kdbrian.elearning.ui.theme.ElearningTheme
import io.github.kdbrian.elearning.ui.theme.darkBlue

@Composable
fun Profile(navController: NavController) {

    Scaffold(topBar = {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
        ) {

            CustomComposables.CircleClipedIcon(
                icon = Icons.Rounded.ArrowBack,
                iconTint = Color.White
            )

            Text(text = "Profile", modifier = Modifier.align(Alignment.Center))

        }
    }, containerColor = Color.White) {
        Column(
            modifier = Modifier
                .padding(it)
                .padding(10.dp)
        ) {

            Spacer(modifier = Modifier.height(20.dp))

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {

                Box {
                    Image(
                        painter = painterResource(id = R.drawable.full_length_portrait_of_confident_student_boy_going_to_school_holding_two_books_and_carrying_his_backpack_cheerful_teenager_walking_with_positive_fac_2a7tjwt_removebg_preview),
                        contentDescription = null,
                        modifier = Modifier
                            .size(150.dp)
                            .background(shape = CircleShape, color = darkBlue)
                    )

                    CustomComposables.CircleClipedIcon(
                        icon = Icons.Rounded.Edit,
                        iconTint = Color.Black,
                        modifier = Modifier
                            .size(35.dp)
                            .align(Alignment.TopEnd)
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))

                Text(text = "Brian Kidiga", fontSize = 20.sp, fontWeight = FontWeight.Bold)

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "brianskidga09@gmail.com",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Light
                )
            }

            Spacer(modifier = Modifier.height(20.dp))

            SettingItem(icon = Icons.Rounded.Person3, tint = Color.Red, title = "User Details", trailingIcon = Icons.Rounded.ArrowForwardIos)
            Spacer(modifier = Modifier.height(10.dp))

            SettingItem(icon = Icons.Rounded.Person3, tint = Color.Black, title = "Certificate", trailingIcon = Icons.Rounded.ArrowForwardIos)
            Spacer(modifier = Modifier.height(10.dp))

            SettingItem(icon = Icons.Rounded.Payments, tint = Color.Yellow, title = "Payment", trailingIcon = Icons.Rounded.ArrowForwardIos)
            Spacer(modifier = Modifier.height(10.dp))

            SettingItem(icon = Icons.Rounded.Newspaper, tint = Color.Magenta, title = "Document", trailingIcon = Icons.Rounded.ArrowForwardIos)
            Spacer(modifier = Modifier.height(10.dp))

            SettingItem(icon = Icons.Rounded.Logout, tint = darkBlue, title = "Logout")
            Spacer(modifier = Modifier.height(10.dp))

        }
    }

}

@Composable
fun SettingItem(
    icon: ImageVector,
    tint: Color,
    title: String,
    trailingIcon: ImageVector? = null,
    onClick: (() -> Unit)? = null
) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
                onClick?.let {
                    onClick()
                }
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {

            CustomComposables.CircleClipedIcon(
                icon = icon,
                iconTint = tint
            )

            Spacer(modifier = Modifier.width(10.dp))

            Text(text = title)

        }

        trailingIcon?.let {
            Icon(imageVector = trailingIcon, contentDescription = null)
        }
    }
}

@Preview
@Composable
fun ProfilePrev() {
    ElearningTheme {
        Profile(navController = rememberNavController())
    }
}
