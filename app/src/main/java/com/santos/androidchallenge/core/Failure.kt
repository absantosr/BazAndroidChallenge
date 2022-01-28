package com.santos.androidchallenge.core

sealed class Failure {
    object UnexpectedFailure : Failure()
    object ServerFailure : Failure()
}