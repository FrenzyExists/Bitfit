package com.codepath.articlesearch.workout

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.codepath.articlesearch.workout.Exercise

interface ExerciseDAO {
    @Query("SELECT * FROM exercises_table")
    fun getAllExercises(): LiveData<List<Exercise>>

    @Query("SELECT * FROM exercises_table WHERE category_id = :categoryId")
    fun getExercisesForCategory(categoryId: Long): LiveData<List<Exercise>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExercise(exercise: Exercise)

    @Update
    suspend fun updateExercise(exercise: Exercise)

    @Query("SELECT AVG(reps) FROM workout_table WHERE creation_date BETWEEN :startDate AND :endDate")
    suspend fun getAverageWater(startDate: Long, endDate: Long): Double

}