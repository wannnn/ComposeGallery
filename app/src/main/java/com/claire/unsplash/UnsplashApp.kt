package com.claire.unsplash

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.claire.unsplash.ui.theme.UnsplashTheme
import com.google.accompanist.insets.ProvideWindowInsets

@Composable
fun UnsplashApp() {
    ProvideWindowInsets {
        UnsplashTheme {
            Scaffold(
                content = {
                    Text(text = "Test!!!!!")
                }
            )
        }
    }
}