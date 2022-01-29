package com.santos.androidchallenge.presentation.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.santos.androidchallenge.core.ResultType
import com.santos.androidchallenge.domain.usecases.GetSongUseCase
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SearchViewModel(private val fetchSongUseCase: GetSongUseCase):ViewModel() {

    var job: Job? = null

    fun onTextChange(text:String){
        job?.cancel()
        job = viewModelScope.launch {
            delay(500)
            when(val result =fetchSongUseCase(term = text)) {
                is ResultType.Error -> TODO()
                is ResultType.Success -> TODO()
            }
        }
    }


}