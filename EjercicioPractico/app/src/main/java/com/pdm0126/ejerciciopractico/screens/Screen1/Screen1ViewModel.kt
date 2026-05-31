package com.pdm0126.ejerciciopractico.screens.Screen1

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pdm0126.ejerciciopractico.data.api.Posts.PostDTO
import com.pdm0126.ejerciciopractico.data.repositories.PostsRepositories.JsonPlaceApiReposiroty
import com.pdm0126.ejerciciopractico.data.repositories.PostsRepositories.JsonPlaceholderRepositorie
import io.ktor.util.Platform
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class Screen1ViewModel : ViewModel() {
    private val JsonPlaceholderRepositorie: JsonPlaceholderRepositorie = JsonPlaceApiReposiroty()
    private val _title = MutableStateFlow("")
    val title = _title.asStateFlow()
    private val _body = MutableStateFlow("")
    val body = _body.asStateFlow()
    private val _saving = MutableStateFlow(false)
    val saving = _saving.asStateFlow()
    private val _saveMessage = MutableStateFlow<String?>(null)
    val saveMessage = _saveMessage.asStateFlow()

    fun onTitleChange(value: String) {
        _title.value = value
    }

    fun onBodyChange(value: String) {
        _body.value = value
    }

    fun CreatePost() {
        viewModelScope.launch {
            _saving.value = true

            JsonPlaceholderRepositorie.createPosts(
                title = _title.value, body = _body.value
            ).onSuccess { post ->
                _saveMessage.value = "Post creado con Id ${post.id}"
            }.onFailure { e -> _saveMessage.value = "Error: ${e.message}" }
            _saving.value = false
        }
    }
}