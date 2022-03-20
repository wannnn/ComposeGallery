package com.claire.unsplash

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.*
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.claire.unsplash.ui.home.HomeSections
import kotlinx.coroutines.CoroutineScope

/**
 * Remembers and creates an instance of [UnsplashAppState]
 */
@Composable
fun rememberUnsplashAppState(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope()
) =
    remember(scaffoldState, navController, coroutineScope) {
        UnsplashAppState(scaffoldState, navController, coroutineScope)
    }

/**
 * Responsible for holding state related to [UnsplashApp] and containing UI-related logic.
 */
@Stable
class UnsplashAppState(
    val scaffoldState: ScaffoldState,
    val navController: NavHostController,
    coroutineScope: CoroutineScope
) {

    /***
     * BottomBar state source of truth
     */
    private val bottomBarTabs = HomeSections.values()
    private val bottomBarRoutes = bottomBarTabs.map { it.route }

    val shouldShowBottomBar: Boolean
        @Composable get() = navController
            .currentBackStackEntryAsState().value?.destination?.route in bottomBarRoutes

    /***
     * Navigation state source of truth
     */
    val currentRoute: String?
        get() = navController.currentDestination?.route

    fun upPress() {
        navController.navigateUp()
    }

    fun navigateToBottomBarRoute(route: String) {
        if (currentRoute != route) {
            navController.navigate(route) {
                launchSingleTop = true
                restoreState = true

                // This if check gives us a "singleTop" behavior where we do not create a
                // second instance of the composable if we are already on that destination

                // Pop up backstack to the first destination and save state. This makes going back
                // to the start destination when pressing back in any other bottom tab.
                popUpTo(navController.graph.startDestinationId) {
                    saveState = true
                }
            }
        }
    }
}