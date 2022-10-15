package com.suzume.jetpackcomposelearning.ui

import androidx.compose.foundation.clickable
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.currentBackStackEntryAsState
import com.suzume.jetpackcomposelearning.MainViewModel
import com.suzume.jetpackcomposelearning.navigation.AppNavGraph
import com.suzume.jetpackcomposelearning.navigation.NavigationItem
import com.suzume.jetpackcomposelearning.navigation.rememberNavigationState

@Composable
fun MainScreen(viewModel: MainViewModel) {

    val navigationState = rememberNavigationState()

    Scaffold(
        bottomBar = {
            BottomNavigation {

                val navBackStackEntry by navigationState.navHostController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route

                val items = listOf(
                    NavigationItem.Home,
                    NavigationItem.Favorite,
                    NavigationItem.Profile
                )
                items.forEach { item ->
                    BottomNavigationItem(
                        selected = currentRoute == item.screen.route,
                        onClick = {
                            navigationState.navigateTo(item.screen.route)
                        },
                        icon = { Icon(item.icon, contentDescription = null) },
                        label = { Text(text = stringResource(id = item.labelResId)) }
                    )
                }
            }
        }
    ) { paddingValues ->

        AppNavGraph(
            navHostController = navigationState.navHostController,
            homeScreenContent = { HomeScreen(viewModel, paddingValues) },
            favouriteScreenContent = {
                CreateTextWithCounter(text = "Favourite Screen")
            },
            profileScreenContent = {
                CreateTextWithCounter(text = "Profile screen")
            }
        )
    }
}

@Composable
fun CreateTextWithCounter(text: String) {

    var count by rememberSaveable {
        mutableStateOf(0)
    }

    Text(
        modifier = Modifier.clickable { count++ },
        text = "$text: $count",
    )
}
