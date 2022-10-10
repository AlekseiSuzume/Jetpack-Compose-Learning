package com.suzume.jetpackcomposelearning.domain.model

import com.suzume.jetpackcomposelearning.R

data class GroupPostModel(
    val id: Int = 0,
    val iconId: Int = R.drawable.ic_icon_github,
    val groupName: String = "/github.com/null",
    val date: String = "15:00",
    val text: String = "Jetpack Compose is Android's modern toolkit for building native UI. It simplifies and accelerates UI development on Android.",
    val attachmentId: Int = R.drawable.template_post_image_dark,
    val statistics: List<StatisticItem> = listOf(
        StatisticItem(StatisticItemType.VIEWS, 125),
        StatisticItem(StatisticItemType.REPOSTS, 24),
        StatisticItem(StatisticItemType.COMMENTS, 35),
        StatisticItem(StatisticItemType.LIKES, 777)
    ),
)