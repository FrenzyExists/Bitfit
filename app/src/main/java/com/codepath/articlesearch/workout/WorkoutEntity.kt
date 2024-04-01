package com.codepath.articlesearch.workout

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName="workout_table")
data class Workout(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "exercise") val exercise: String,
    @ColumnInfo(name = "weight_lifted") val weightLifted: Int?,
    @ColumnInfo(name = "reps") val repsDone: Int?,
    @ColumnInfo(name = "creation_date") val creationDate: String
)