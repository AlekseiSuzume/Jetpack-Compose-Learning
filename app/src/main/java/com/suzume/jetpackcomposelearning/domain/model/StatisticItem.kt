package com.suzume.jetpackcomposelearning.domain.model

class StatisticItem(
    val type: StatisticItemType,
    val count: Int = 0
) {

}

enum class StatisticItemType {
    VIEWS, REPOSTS, COMMENTS, LIKES
}