package com.claire.unsplash

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
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

}