package com.suzume.jetpackcomposelearning.domain.model

data class StatisticItem(
    val type: StatisticItemType,
    val count: Int = 0
) {

}

enum class StatisticItemType {
    VIEWS, REPOSTS, COMMENTS, LIKES
}