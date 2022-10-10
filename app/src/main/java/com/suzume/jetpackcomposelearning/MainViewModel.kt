package com.suzume.jetpackcomposelearning

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.suzume.jetpackcomposelearning.domain.model.GroupPostModel
import com.suzume.jetpackcomposelearning.domain.model.StatisticItemType

class MainViewModel : ViewModel() {

    private val _post = MutableLiveData(GroupPostModel())
    val post: LiveData<GroupPostModel> = _post

    fun onViewsClick() {
        Log.d("MyTag:MainViewModel", "onViewsClick")
    }

    fun onRepostsClick() {
        Log.d("MyTag:MainViewModel", "onRepostsClick")
    }

    fun onCommentsClick() {
        Log.d("MyTag:MainViewModel", "onCommentsClick")
    }

    fun onLikesClick() {
        Log.d("MyTag:MainViewModel", "onLikesClick")
        val oldStatistics = post.value?.statistics ?: throw RuntimeException()
        val newStatistics = oldStatistics.toMutableList()
        newStatistics.replaceAll {
            if (it.type == StatisticItemType.LIKES) {
                it.copy(count = it.count + 1)
            } else {
                it
            }
        }
        _post.value = post.value?.copy(statistics = newStatistics)
    }

}