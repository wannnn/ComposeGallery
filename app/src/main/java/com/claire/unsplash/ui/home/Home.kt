package com.claire.unsplash.ui.home

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.claire.unsplash.ui.theme.UnsplashTheme

enum class HomeSections(val icon: ImageVector, val route: String) {
    Photo(Icons.TwoTone.ColorLens, "home/photo"),
    Search(Icons.TwoTone.Search, "home/search"),
    Add(Icons.TwoTone.AddCircle, "home/add"),
    Profile(Icons.TwoTone.EmojiPeople, "home/profile")
}

@Composable
fun HomeGraph(
    navController: NavHostController
) {
    NavHost(navController, startDestination = HomeSections.Photo.route) {
        composable(HomeSections.Photo.route) {
            Photo()
        }
        composable(HomeSections.Search.route) {
            Search()
        }
        composable(HomeSections.Add.route) {
            Add()
        }
        composable(HomeSections.Profile.route) {
            Profile()
        }
    }
}

@Composable
fun UnsplashBottomBar(
    navController: NavHostController,
    tabs: Array<HomeSections>
) {
    BottomNavigation {

//        val currentRoute = currentRoute(navController)

        tabs.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = null
                    )
                },
                selected = true,
//                selected = currentRoute == screen.route,
                onClick = {
                    // This if check gives us a "singleTop" behavior where we do not create a
                    // second instance of the composable if we are already on that destination
//                    if (currentRoute != screen.route) {
//                        navController.navigate(screen.route)
//                    }
                }
            )
        }
    }
}

//@Composable
//private fun currentRoute(navController: NavHostController): String? {
//    val navBackStackEntry by navController.currentBackStackEntryAsState()
//    return navBackStackEntry?.arguments?.getString(KEY_ROUTE)
//}

@Preview
@Composable
fun UnsplashBottomBarPreView() {
    UnsplashTheme {
        UnsplashBottomBar(
            rememberNavController(),
            HomeSections.values()
        )
    }
}