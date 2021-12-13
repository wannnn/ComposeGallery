package com.claire.unsplash

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.claire.unsplash.ui.home.HomeSections
import com.claire.unsplash.ui.home.UnsplashBottomBar
import com.claire.unsplash.ui.home.homeNavGraph
import com.claire.unsplash.ui.theme.UnsplashTheme
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.navigationBarsHeight
import com.google.accompanist.insets.navigationBarsPadding
import com.google.accompanist.insets.systemBarsPadding
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun UnsplashApp() {
    ProvideWindowInsets {
        UnsplashTheme {

            val navController = rememberNavController()
//            val appState = rememberUnsplashAppState()

            Scaffold(
                modifier = Modifier.navigationBarsPadding(),
                bottomBar = {
                    UnsplashBottomBar(
                        navController = navController,
                        tabs = HomeSections.values(),
//                        currentRoute = appState.currentRoute!!,
//                        navigateToRoute = appState::navigateToBottomBarRoute
                    )
                }
            ) { innerPadding ->

                NavHost(
                    navController = navController,
                    startDestination = HomeSections.Explore.route,
                    modifier = Modifier.padding(innerPadding)
                ) {
                    homeNavGraph()
                }
            }
        }
    }
}