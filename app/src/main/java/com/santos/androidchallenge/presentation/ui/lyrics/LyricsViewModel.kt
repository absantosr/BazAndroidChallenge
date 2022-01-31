package com.santos.androidchallenge.presentation.ui.lyrics

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.santos.androidchallenge.core.Failure
import com.santos.androidchallenge.core.ResultType
import com.santos.androidchallenge.domain.model.Lyrics
import com.santos.androidchallenge.domain.usecases.GetLyricsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LyricsViewModel @Inject constructor(private val getLyricsUseCase: GetLyricsUseCase) :
    ViewModel() {

    private val _getLyricsLiveData = MutableLiveData<ResultType<Lyrics, Failure>>()
    val lyricsLiveData: LiveData<ResultType<Lyrics, Failure>> get() = _getLyricsLiveData

    fun getLyrics(artist: String, song: String) {
        viewModelScope.launch {
            when (val result = getLyricsUseCase(artist = artist, song = song)) {
                is ResultType.Error -> {
                    _getLyricsLiveData.value = ResultType.Error(result.error)
                }
                is ResultType.Success -> {
                    _getLyricsLiveData.value = ResultType.Success(result.data)
                }
            }
        }
    }
}