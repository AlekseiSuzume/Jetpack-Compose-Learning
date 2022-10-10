package com.suzume.jetpackcomposelearning.ui.theme

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.ui.graphics.vector.ImageVector
import com.suzume.jetpackcomposelearning.R

sealed class NavigationItem(
    val labelResId: Int,
    val icon: ImageVector,
)

object Home : NavigationItem(R.string.label_home, Icons.Outlined.Home)
object Favorite : NavigationItem(R.string.label_favorite, Icons.Outlined.Favorite)
object Profile : NavigationItem(R.string.label_profile, Icons.Outlined.Person)