package com.claire.unsplash.ui.home

import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.twotone.AddCircle
import androidx.compose.material.icons.twotone.ColorLens
import androidx.compose.material.icons.twotone.EmojiPeople
import androidx.compose.material.icons.twotone.Search
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.claire.unsplash.ui.detail.PhotoDetail
import com.claire.unsplash.ui.theme.UnsplashTheme
import com.google.accompanist.pager.ExperimentalPagerApi

enum class HomeSections(val icon: ImageVector, val route: String) {
    Explore(Icons.TwoTone.ColorLens, "home/explore"),
    Search(Icons.TwoTone.Search, "home/search"),
    Add(Icons.TwoTone.AddCircle, "home/add"),
    Profile(Icons.TwoTone.EmojiPeople, "home/profile")
}

enum class Destinations(val route: String) {
    PhotoDetail("photo_detail")
}

@ExperimentalPagerApi
fun NavGraphBuilder.homeNavGraph(
    navController: NavHostController
) {
    composable(HomeSections.Explore.route) {
        Explore { destination ->
            navController.navigate(destination.route)
        }
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
    composable(
        route = Destinations.PhotoDetail.route
    ) {
        PhotoDetail()
    }
}

@Composable
fun UnsplashBottomBar(
    tabs: Array<HomeSections>,
    currentRoute: String,
    navigateToRoute: (String) -> Unit
) {
    BottomNavigation {

        tabs.forEach { screen ->
            BottomNavigationItem(
                icon = {
                    Icon(
                        imageVector = screen.icon,
                        contentDescription = null
                    )
                },
                selected = currentRoute == screen.route,
                onClick = {
                    navigateToRoute(screen.route)
                }
            )
        }
    }
}

@Preview
@Composable
fun UnsplashBottomBarPreView() {
    UnsplashTheme {
        UnsplashBottomBar(
            tabs = HomeSections.values(),
            currentRoute = HomeSections.Explore.route,
            navigateToRoute = {}
        )
    }
}