package com.santos.androidchallenge.data.mapper

import com.santos.androidchallenge.data.entity.ArtistEntity
import com.santos.androidchallenge.domain.model.Artist

fun ArtistEntity.toDomain() = Artist(
    id = id,
    name = name,
    link = link,
    picture = picture,
    picture_small = picture_small,
    picture_medium = picture_medium,
    picture_big = picture_big,
    picture_xl = picture_xl,
    tracklist = tracklist,
    type = type
)