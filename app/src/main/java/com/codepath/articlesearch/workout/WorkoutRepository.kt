package com.codepath.articlesearch.workout

import androidx.lifecycle.LiveData

class WorkoutRepository(private val workoutDao: WorkoutDAO) {

    val allWorkoutSessions: LiveData<List<Workout>> = workoutDao.getAllWorkoutSessions()

    suspend fun insert(workout: Workout){
        workoutDao.insert(workout)
    }
    suspend fun update(workout: Workout){
        workoutDao.update(workout)
    }

    suspend fun delete(workout: Workout) {
        workoutDao.delete(workout)
    }
}