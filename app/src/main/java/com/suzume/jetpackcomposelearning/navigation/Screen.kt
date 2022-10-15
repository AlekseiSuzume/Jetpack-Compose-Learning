package com.suzume.jetpackcomposelearning.navigation

sealed class Screen(
    val route: String,
) {
    object HomeScreen : Screen(ROUTE_HOME_SCREEN)
    object FavouriteScreen : Screen(ROUTE_FAVOURITE_SCREEN)
    object ProfileScreen : Screen(ROUTE_PROFILE_SCREEN)

    private companion object {

        const val ROUTE_HOME_SCREEN = "home_screen"
        const val ROUTE_FAVOURITE_SCREEN = "favourite_screen"
        const val ROUTE_PROFILE_SCREEN = "profile_screen"

    }
}