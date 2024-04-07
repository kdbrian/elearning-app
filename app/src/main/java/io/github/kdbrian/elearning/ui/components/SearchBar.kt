package io.github.kdbrian.elearning.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.MicNone
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.github.kdbrian.elearning.ui.theme.darkBlue
import io.github.kdbrian.elearning.ui.theme.primaryWhite

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    trailingIcon : ImageVector ? = null,
    leadingIcon : ImageVector ? = null,
    placeHolder : String ? = null,
    containerColor : Color = darkBlue,
    contentColor: Color = Color.Black
) {

    val searchText = remember {
        mutableStateOf("")
    }

    val KB = LocalSoftwareKeyboardController.current

    TextField(
        value = searchText.value,
        onValueChange = { searchText.value = it },
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .clip(RoundedCornerShape(20.dp)),
        leadingIcon = { leadingIcon?.let { Icon(imageVector = leadingIcon, contentDescription = null) } },
        placeholder = { placeHolder?.let { Text(text =  it, color = contentColor) }},
        trailingIcon = { trailingIcon?.let {  Icon(imageVector = trailingIcon, contentDescription = null) } },
        colors = TextFieldDefaults.textFieldColors(
            containerColor = containerColor,
            focusedTextColor = Color.White,
            focusedPlaceholderColor = Color.White,
            unfocusedPlaceholderColor = Color.White,
            unfocusedLeadingIconColor = Color.Gray,
            focusedLeadingIconColor = Color.Gray,
            focusedIndicatorColor = darkBlue,
            unfocusedIndicatorColor = primaryWhite,
            focusedTrailingIconColor = Color.Gray,
            unfocusedTrailingIconColor = Color.Gray
        ),
        keyboardActions = KeyboardActions(onSearch = {
            if (searchText.value.isNotEmpty()) {
                //perform search
                KB?.hide()
            }
        }),
        keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search)
    )
}

@Preview
@Composable
fun SearchBarPrev() {
    SearchBar()
}
