package com.claire.unsplash

import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.claire.unsplash.ui.home.HomeSections
import com.claire.unsplash.ui.home.UnsplashBottomBar
import com.claire.unsplash.ui.home.homeNavGraph
import com.claire.unsplash.ui.theme.UnsplashTheme
import com.google.accompanist.pager.ExperimentalPagerApi

@ExperimentalPagerApi
@Composable
fun UnsplashApp() {
    UnsplashTheme {

        val appState = rememberUnsplashAppState()

        Scaffold(
            modifier = Modifier.navigationBarsPadding(),
            bottomBar = {
                if (appState.shouldShowBottomBar) {
                    UnsplashBottomBar(
                        tabs = HomeSections.values(),
                        currentRoute = appState.currentRoute!!,
                        navigateToRoute = appState::navigateToBottomBarRoute
                    )
                }
            }
        ) { innerPadding ->

            NavHost(
                navController = appState.navController,
                startDestination = HomeSections.Explore.route,
                modifier = Modifier.padding(innerPadding)
            ) {
                homeNavGraph(appState.navController)
            }
        }
    }
}