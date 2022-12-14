package com.suzume.jetpackcomposelearning.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun AppNavGraph(
    navHostController: NavHostController,
    homeScreenContent: @Composable () -> Unit,
    favouriteScreenContent: @Composable () -> Unit,
    profileScreenContent: @Composable () -> Unit,
) {
    NavHost(
        navController = navHostController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(Screen.HomeScreen.route) {
            homeScreenContent()
        }
        composable(Screen.FavouriteScreen.route) {
            favouriteScreenContent()
        }
        composable(Screen.ProfileScreen.route) {
            profileScreenContent()
        }
    }
}