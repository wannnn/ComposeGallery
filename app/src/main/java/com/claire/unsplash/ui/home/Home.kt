package com.claire.unsplash.ui.home

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState

enum class HomeSections(val icon: ImageVector, val route: String) {
    Photo(Icons.Filled.Home, "home/photo"),
    Search(Icons.Filled.Search, "home/search"),
    Add(Icons.Filled.Add, "home/add"),
    Profile(Icons.Filled.AccountBox, "home/profile")
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