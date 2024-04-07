package io.github.kdbrian.elearning.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.PlayCircle
import androidx.compose.material.icons.rounded.ChatBubbleOutline
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import io.github.kdbrian.elearning.nav.APPSCREENS

sealed class HomeBottomBarItem(
    val icon : ImageVector,
    val route : String,
    val title : String ? = null
){
    private data object Home : HomeBottomBarItem(icon = Icons.Outlined.Home, route = APPSCREENS.HOME.name)
    private data object Chats : HomeBottomBarItem(icon = Icons.Rounded.ChatBubbleOutline, route = APPSCREENS.CHATS.name)
    private data object Profile : HomeBottomBarItem(icon = Icons.Rounded.Settings, route = APPSCREENS.PROFILE.name)
    private data object VideoChat : HomeBottomBarItem(icon = Icons.Outlined.PlayCircle, route = APPSCREENS.PROFILE.name)

    companion object{
        fun getHomeBottomBarItems() = listOf(
            Home,
            Chats,
            Profile,
            VideoChat
        )
    }
}