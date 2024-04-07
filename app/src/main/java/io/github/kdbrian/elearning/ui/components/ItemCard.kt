package io.github.kdbrian.elearning.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.EditCalendar
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.kdbrian.elearning.ui.theme.ElearningTheme
import io.github.kdbrian.elearning.ui.theme.primaryWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemCard(icon: ImageVector, text: String) {

    Card(
        onClick = { /*TODO*/ },
        colors = CardDefaults.cardColors(containerColor = primaryWhite),
        modifier = Modifier
            .padding(7.dp)
    ) {
        Column(
            modifier = Modifier
                .padding(vertical = 30.dp, horizontal = 25.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {

            Icon(
                imageVector = icon,
                modifier = Modifier
                    .clip(CircleShape)
                    .background(color = Color.White)
                    .padding(15.dp),
                contentDescription = null
            )
            Text(text = text, textAlign = TextAlign.Center)
        }
    }
}

@Preview
@Composable
fun ItemPrev() {
    ElearningTheme {
        ItemCard(icon = Icons.Rounded.EditCalendar, text = "Editing")
    }
}