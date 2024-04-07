package io.github.kdbrian.elearning.nav

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import io.github.kdbrian.elearning.model.Course
import io.github.kdbrian.elearning.ui.screens.Chats
import io.github.kdbrian.elearning.ui.screens.CourseDetail
import io.github.kdbrian.elearning.ui.screens.HomeScreen
import io.github.kdbrian.elearning.ui.screens.OnboardingScreen
import io.github.kdbrian.elearning.ui.screens.OurCourses
import io.github.kdbrian.elearning.ui.screens.Profile
import io.github.kdbrian.elearning.ui.screens.VideoChat


private const val TAG = "AppNavigation"

@Composable
fun App() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = APPSCREENS.ONBOARDING.name){

        bottomNavigation(navController)

        composable(route = APPSCREENS.ONBOARDING.name){
            OnboardingScreen(navController)
        }

        composable(APPSCREENS.HOME.name){
            HomeScreen(navController = navController)
        }

        composable(APPSCREENS.OUR_COURSES.name){
            OurCourses(navController = navController)
        }

        composable(route = "${APPSCREENS.COURSE_DETAIL.name}/{courseId}", arguments = listOf(
            navArgument(name = "courseId"){type = NavType.IntType}
        )){

            //fetch course
            val id  = it?.arguments?.getInt("courseId")

            Log.d(TAG, "App: course id -> $id")

            CourseDetail(course = Course.getCourseById(id!!), navController = navController)

        }

    }
}
fun NavGraphBuilder.bottomNavigation(navController: NavController){
    
    composable(APPSCREENS.HOME.name){
        HomeScreen(navController = navController)
    }

    composable(APPSCREENS.CHATS.name){
        Chats(navController = navController)
    }

    composable(APPSCREENS.PROFILE.name){
        Profile(navController = navController)
    }

    composable(APPSCREENS.VIDEO_CHAT.name){
        VideoChat(navController = navController)
    }
}