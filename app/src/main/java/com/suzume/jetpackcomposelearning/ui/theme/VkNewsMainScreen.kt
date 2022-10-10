package com.suzume.jetpackcomposelearning.ui.theme

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.stringResource
import kotlinx.coroutines.launch

@Composable
fun MainScreen() {

    Scaffold(
        bottomBar = {
            BottomNavigation {
                val state = remember {
                    mutableStateOf(0)
                }
                val items = listOf(
                    Home,
                    Favorite,
                    Profile
                )
                items.forEachIndexed { index, item ->
                    BottomNavigationItem(
                        selected = state.value == index,
                        onClick = { state.value = index },
                        icon = { Icon(item.icon, contentDescription = null) },
                        label = { Text(text = stringResource(id = item.labelResId)) }
                    )
                }
            }
        }
    ) {
        PostCard()
    }
}