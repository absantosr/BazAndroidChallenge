package com.santos.androidchallenge.core

sealed class ResultType<out T, out V> {
    data class Success<out T, out V>(val data: T) : ResultType<T, V>()
    data class Error<out T, out V>(val error: V) : ResultType<T, V>()
}


fun <T, V, R> ResultType<T, V>.mapSuccess(transform: (T) -> R): ResultType<R, V> {
    return when (this) {
        is ResultType.Error -> ResultType.Error(this.error)
        is ResultType.Success -> ResultType.Success(transform(this.data))
    }
}