package com.crakac.simplesample

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor() : ViewModel() {
    @Inject
    lateinit var api: Mastodon
    private var _info by mutableStateOf(Instance())
    val info: Instance get() =  _info

    fun update() {
        viewModelScope.launch {
            val response = api.getInformation()
            if (response.isSuccessful){
                _info = response.body()!!
            }
        }
    }
}