package com.claire.unsplash

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.claire.unsplash.ui.home.HomeGraph
import com.claire.unsplash.ui.home.HomeSections
import com.claire.unsplash.ui.home.UnsplashBottomBar
import com.claire.unsplash.ui.theme.UnsplashTheme
import com.google.accompanist.insets.ProvideWindowInsets

@Composable
fun UnsplashApp() {
    ProvideWindowInsets {
        UnsplashTheme {
            val navController = rememberNavController()
            val appState = rememberUnsplashAppState()
            Scaffold(
                bottomBar = {
                    UnsplashBottomBar(
                        navController,
                        HomeSections.values()
                    )
                },
                content = {
                    Text(text = "Test!!!!!")
                }
            )
        }
    }
}