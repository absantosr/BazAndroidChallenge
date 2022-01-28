package com.santos.androidchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.santos.androidchallenge.domain.repository.SongRepository
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var name:String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        println(name)
    }
}