package com.suzume.jetpackcomposelearning

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.suzume.jetpackcomposelearning.domain.model.GroupPostModel

class MainViewModel : ViewModel() {

    private val _post = MutableLiveData(GroupPostModel())
    val post: LiveData<GroupPostModel> = _post

}