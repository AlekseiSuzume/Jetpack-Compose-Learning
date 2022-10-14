package com.suzume.jetpackcomposelearning.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.suzume.jetpackcomposelearning.R
import com.suzume.jetpackcomposelearning.domain.model.GroupPostModel
import com.suzume.jetpackcomposelearning.domain.model.StatisticItem
import com.suzume.jetpackcomposelearning.domain.model.StatisticItemType

@Composable
fun PostCard(
    post: GroupPostModel,
    onStatisticClickListener: (StatisticItem) -> Unit,
) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
    ) {
        Column {
            PostHeader(post)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = post.text)
            Image(modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
                painter = painterResource(id = post.attachmentId),
                contentDescription = null,
                contentScale = ContentScale.FillWidth
            )
            PostStatistics(
                statistics = post.statistics,
                onStatisticClickListener = onStatisticClickListener
            )
        }
    }
}

@Composable
private fun PostHeader(
    post: GroupPostModel,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .size(48.dp),
            painter = painterResource(id = post.iconId),
            contentDescription = null
        )
        Spacer(modifier = Modifier.width(8.dp))
        Column(modifier = Modifier.weight(1f)) {
            Text(
                text = post.groupName,
                color = MaterialTheme.colors.onPrimary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = post.date,
                color = MaterialTheme.colors.onSecondary
            )
        }
        Icon(
            imageVector = Icons.Rounded.MoreVert,
            contentDescription = null,
            tint = MaterialTheme.colors.onSecondary
        )
    }
}

@Composable
private fun PostStatistics(
    statistics: List<StatisticItem>,
    onStatisticClickListener: (StatisticItem) -> Unit,
) {

    Row(
    ) {
        Row(
            modifier = Modifier
                .weight(1f)
                .clickable { }
        ) {
            val itemViews = statistics.find(StatisticItemType.VIEWS)
            IconWithText(
                iconResId = R.drawable.ic_visibility,
                text = itemViews.count.toString(),
                onItemClickListener = { onStatisticClickListener(itemViews) }
            )
        }
        Row(
            modifier = Modifier.weight(1f),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            val itemReposts = statistics.find(StatisticItemType.REPOSTS)
            IconWithText(
                iconResId = R.drawable.ic_repost,
                text = itemReposts.count.toString(),
                onItemClickListener = { onStatisticClickListener(itemReposts) }
            )
            val itemComments = statistics.find(StatisticItemType.COMMENTS)
            IconWithText(
                iconResId = R.drawable.ic_comment,
                text = itemComments.count.toString(),
                onItemClickListener = { onStatisticClickListener(itemComments) }
            )
            val itemLikes = statistics.find(StatisticItemType.LIKES)
            IconWithText(
                iconResId = R.drawable.ic_like,
                text = itemLikes.count.toString(),
                onItemClickListener = { onStatisticClickListener(itemLikes) }
            )
        }
    }
}

private fun List<StatisticItem>.find(type: StatisticItemType): StatisticItem {
    return this.find { it.type == type } ?: throw RuntimeException("Unknown type: $type")
}

@Composable
private fun IconWithText(
    iconResId: Int,
    text: String,
    onItemClickListener: () -> Unit,
) {
    Row(
        modifier = Modifier.clickable { onItemClickListener() },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = iconResId),
            contentDescription = null,
            tint = MaterialTheme.colors.onSecondary
        )
        Spacer(modifier = Modifier.width(4.dp))
        Text(
            text = text,
            color = MaterialTheme.colors.onSecondary
        )
    }
}