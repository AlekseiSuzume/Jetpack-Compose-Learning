package com.suzume.jetpackcomposelearning.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.suzume.jetpackcomposelearning.R

sealed class NavigationItem(
    val screen: Screen,
    val labelResId: Int,
    val icon: ImageVector,
) {
    object Home : NavigationItem(
        Screen.HomeScreen,
        R.string.label_home,
        Icons.Outlined.Home
    )

    object Favorite :
        NavigationItem(
            Screen.FavouriteScreen,
            R.string.label_favorite,
            Icons.Outlined.Favorite
        )

    object Profile :
        NavigationItem(
            Screen.ProfileScreen,
            R.string.label_profile,
            Icons.Outlined.Person
        )
}