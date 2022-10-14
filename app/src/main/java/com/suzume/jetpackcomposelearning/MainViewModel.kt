package com.suzume.jetpackcomposelearning

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.suzume.jetpackcomposelearning.domain.model.GroupPostModel
import com.suzume.jetpackcomposelearning.domain.model.StatisticItemType

class MainViewModel : ViewModel() {

    private val listPosts = mutableListOf<GroupPostModel>().apply {
        repeat(10) {
            this.add(GroupPostModel(
                id = it,
                groupName = "GroupName $it",
            ))
        }
    }

    private val _post = MutableLiveData<List<GroupPostModel>>(listPosts)
    val post: LiveData<List<GroupPostModel>> = _post

    fun delete(item: GroupPostModel) {
        val updatedList = _post.value?.toMutableList()
        updatedList?.remove(item)
        _post.value = updatedList
    }

    fun onViewsClick() {
        Log.d("MyTag:MainViewModel", "onViewsClick")
    }

    fun onRepostsClick() {
        Log.d("MyTag:MainViewModel", "onRepostsClick")
    }

    fun onCommentsClick() {
        Log.d("MyTag:MainViewModel", "onCommentsClick")
    }

    fun onLikesClick(oldItem: GroupPostModel) {
        Log.d("MyTag:MainViewModel", "onLikesClick")
        val oldStatistics = oldItem.statistics
        val newStatistics = oldStatistics.toMutableList()
        newStatistics.replaceAll {
            if (it.type == StatisticItemType.LIKES) {
                it.copy(count = it.count + 1)
            } else {
                it
            }
        }
        val newItem = oldItem.copy(statistics = newStatistics)

        val oldList = _post.value?.toMutableList() ?: mutableListOf()
        _post.value = oldList.map {
            if (it.id == oldItem.id) {
                newItem
            } else {
                it
            }
        }
    }

}