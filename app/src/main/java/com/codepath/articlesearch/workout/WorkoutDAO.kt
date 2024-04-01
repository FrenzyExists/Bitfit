package com.codepath.articlesearch.workout

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface WorkoutDAO {

    @Insert
    suspend fun insert(workout: Workout)

    @Delete
    suspend fun delete(workout: Workout)

    @Query("SELECT * FROM workout_table ORDER BY id ASC")
    fun getAllWorkoutSessions(): LiveData<List<Workout>>

    @Update
    suspend fun update(workout: Workout)
}
