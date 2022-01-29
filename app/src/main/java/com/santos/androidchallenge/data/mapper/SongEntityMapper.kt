package com.santos.androidchallenge.data.mapper

import com.santos.androidchallenge.data.entity.SongEntity
import com.santos.androidchallenge.domain.model.Song

fun SongEntity.toDomain() = Song(
    id = id,
    readable = readable,
    title = title,
    title_short = title_short,
    title_version = title_version,
    link = link,
    duration = duration,
    rank = rank,
    explicit_lyrics = explicit_lyrics,
    explicit_content_lyrics = explicit_content_lyrics,
    explicit_content_cover = explicit_content_cover,
    preview = preview,
    md5_image = md5_image,
    artist = artist.toDomain(),
    album = album.toDomain(),
    type = type
)