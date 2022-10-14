package com.suzume.jetpackcomposelearning.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.suzume.jetpackcomposelearning.MainViewModel
import com.suzume.jetpackcomposelearning.domain.model.StatisticItemType

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun MainScreen(viewModel: MainViewModel) {

    val posts = viewModel.post.observeAsState(listOf())

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
        LazyColumn(
            modifier = Modifier.padding(it),
            contentPadding = (PaddingValues(
                top = 16.dp,
                start = 8.dp,
                end = 8.dp,
                bottom = 16.dp
            )),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(posts.value, key = { it.id }) { item ->

                val dismissState = rememberDismissState()

                if (dismissState.isDismissed(DismissDirection.EndToStart)) {
                    viewModel.delete(item)
                }

                SwipeToDismiss(
                    modifier = Modifier.animateItemPlacement(),
                    state = dismissState,
                    directions = setOf(DismissDirection.EndToStart),
                    background = {}
                ) {
                    PostCard(
                        post = item,
                        onStatisticClickListener = { statisticItem ->
                            when (statisticItem.type) {
                                StatisticItemType.VIEWS -> viewModel.onViewsClick()
                                StatisticItemType.REPOSTS -> viewModel.onRepostsClick()
                                StatisticItemType.COMMENTS -> viewModel.onCommentsClick()
                                StatisticItemType.LIKES -> viewModel.onLikesClick(item)
                            }
                        }
                    )
                }
            }
        }
    }
}
