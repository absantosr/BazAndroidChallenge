package com.santos.androidchallenge.presentation.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.santos.androidchallenge.core.Failure
import com.santos.androidchallenge.core.ResultType
import com.santos.androidchallenge.domain.model.Summary
import com.santos.androidchallenge.domain.usecases.FetchSongUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val fetchSongUseCase: FetchSongUseCase) :
    ViewModel() {

    private val _fetchLiveData = MutableLiveData<ResultType<Summary, Failure>>()
    val songLiveData: LiveData<ResultType<Summary, Failure>> get() = _fetchLiveData

    var job: Job? = null

    fun onTextChange(text: String) {
        job?.cancel()
        job = viewModelScope.launch {
            delay(500)
            when (val result = fetchSongUseCase(term = text)) {
                is ResultType.Error -> {
                    _fetchLiveData.value = ResultType.Error(result.error)
                }
                is ResultType.Success ->
                    _fetchLiveData.value = ResultType.Success(result.data)
            }
        }
    }
}