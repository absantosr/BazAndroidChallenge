package com.santos.androidchallenge.domain.model

import com.santos.androidchallenge.data.entity.Album
import com.santos.androidchallenge.data.entity.Artist

data class Song(
    val id: Long,
    val readable: Boolean,
    val title: String,
    val title_short: String,
    val title_version: String,
    val link: String,
    val duration: Int,
    val rank: Int,
    val explicit_lyrics: Boolean,
    val explicit_content_lyrics: Int,
    val explicit_content_cover: Int,
    val preview: String,
    val md5_image: String,
    val artist: Artist,
    val album: Album,
    val type: String
)