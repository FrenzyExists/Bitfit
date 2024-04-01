package com.codepath.articlesearch.workout

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

data class ExerciseCount(
    val exerciseId: Long,
    val count: Int
)
@Entity(tableName = "categories_table")
data class Category(
    @PrimaryKey(autoGenerate = true) val categoryId: Long = 0,
    @ColumnInfo(name = "category_name") val categoryName: String
)

@Entity(tableName = "exercises_table")
data class Exercise(
    @PrimaryKey(autoGenerate = true) val exerciseId: Long = 0,
    @ColumnInfo(name = "exercise_name") val exerciseName: String,
    @ColumnInfo(name = "category_id") val categoryId: Long?
)

@Entity(tableName="workout_table")
data class Workout(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    @ColumnInfo(name = "exercise") val exerciseId: Long,
    @ColumnInfo(name = "weight_lifted") val weightLifted: Int?,
    @ColumnInfo(name = "reps") val repsDone: Int?,
    @ColumnInfo(name = "duration_minutes") val durationMinutes: Int?,
    @ColumnInfo(name = "notes") val notes: String?,
    @ColumnInfo(name = "creation_date") val mediaImageUrl: Date?
)
