package com.hectorpolendo.examen.data.database.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.hectorpolendo.examen.domain.models.Favorite

@Entity(tableName = "Favorites")
data class FavoriteEntity(
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val image: String,
    val ref: String
)

fun Favorite.toDatabaseFav() = FavoriteEntity(
    id,
    image,
    ref
)