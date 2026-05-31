package com.pdm0126.ejerciciopractico.screens.Home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pdm0126.ejerciciopractico.data.repositories.PostsRepositories.JsonPlaceApiReposiroty
import com.pdm0126.ejerciciopractico.data.repositories.PostsRepositories.JsonPlaceholderRepositorie
import com.pdm0126.ejerciciopractico.model.Post
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val JsonPlaceholderRepositorie: JsonPlaceholderRepositorie = JsonPlaceApiReposiroty()
    private val _posts = MutableStateFlow<List<Post>>(emptyList())
    val posts = _posts.asStateFlow()
    private val _refresh = MutableStateFlow(false)
    val refreshing = _refresh.asStateFlow()

    init {
        loadPosts()
    }

    fun loadPosts() {
        viewModelScope.launch {
            JsonPlaceholderRepositorie.getPosts().onSuccess { posts -> _posts.value = posts }
        }
    }

    fun onRefresh() {
        viewModelScope.launch {
            _refresh.value = true
            JsonPlaceholderRepositorie.getPosts().onSuccess { posts -> _posts.value = posts }
            _refresh.value = false
        }
    }
}