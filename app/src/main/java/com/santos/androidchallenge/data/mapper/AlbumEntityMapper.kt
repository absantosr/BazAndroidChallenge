package com.santos.androidchallenge.data.mapper

import com.santos.androidchallenge.data.entity.AlbumEntity
import com.santos.androidchallenge.domain.model.Album

fun AlbumEntity.toDomain() = Album(
    id = id,
    title = title,
    cover = cover,
    cover_small = cover_small,
    cover_medium = cover_medium,
    cover_big = cover_big,
    cover_xl = cover_xl,
    md5_image = md5_image,
    tracklist = tracklist,
    type = type
)