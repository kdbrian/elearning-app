package io.github.kdbrian.elearning.ui.components

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState

@Composable
fun HomeBottomBar(navController: NavController) {

    val items = HomeBottomBarItem.getHomeBottomBarItems()

    NavigationBar {

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route


        items.forEach {
            BottomNavigationItem(
                selected = currentRoute == it.route,
                onClick = {

                          navController.navigate(it.route){
                              navController.graph.startDestinationRoute?.let {
                                  popUpTo(it){
                                      saveState = true
                                  }
                              }
                              launchSingleTop = true
                              restoreState=true
                          }


                          },
                icon = { Icon(imageVector = it.icon, contentDescription = it.title) }
            )
        }
    }

}