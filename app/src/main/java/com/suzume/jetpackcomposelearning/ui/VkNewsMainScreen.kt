package com.suzume.jetpackcomposelearning.ui

import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import com.suzume.jetpackcomposelearning.MainViewModel
import com.suzume.jetpackcomposelearning.domain.model.GroupPostModel
import com.suzume.jetpackcomposelearning.domain.model.StatisticItemType

@Composable
fun MainScreen(viewModel: MainViewModel) {

    val post = viewModel.post.observeAsState(GroupPostModel())

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
        PostCard(
            post = post.value,
            onStatisticClickListener = {
                when (it.type) {
                    StatisticItemType.VIEWS -> viewModel.onViewsClick()
                    StatisticItemType.REPOSTS -> viewModel.onRepostsClick()
                    StatisticItemType.COMMENTS -> viewModel.onCommentsClick()
                    StatisticItemType.LIKES -> viewModel.onLikesClick()
                }
            }
        )
    }
}