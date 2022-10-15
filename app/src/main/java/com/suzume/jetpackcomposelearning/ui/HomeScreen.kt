package com.suzume.jetpackcomposelearning.ui

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.DismissDirection
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.SwipeToDismiss
import androidx.compose.material.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.suzume.jetpackcomposelearning.MainViewModel
import com.suzume.jetpackcomposelearning.domain.model.StatisticItemType

@OptIn(ExperimentalMaterialApi::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(
    viewModel: MainViewModel,
    paddingValues: PaddingValues,
) {

    val posts = viewModel.post.observeAsState(listOf())

    LazyColumn(
        modifier = Modifier.padding(paddingValues),
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