package com.codepath.articlesearch.workout

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class WorkoutViewModel(application: Application): AndroidViewModel(application) {

    private val repository: WorkoutRepository
    private val allWorkout : LiveData<List<Workout>>

    init {
        val dao = WorkoutDatabase.getDatabase(application).getWorkoutDao()
        repository = WorkoutRepository(dao)
        allWorkout = repository.allWorkoutSessions
    }

    fun insertJournal(workout: Workout) = viewModelScope.launch(Dispatchers.IO){
        repository.insert(workout)
    }

    fun updateWorkout(workout: Workout) = viewModelScope.launch(Dispatchers.IO){
        repository.update(workout)
    }

    fun deleteWorkout(journal: Workout) = viewModelScope.launch(Dispatchers.IO){
        repository.delete(journal)
    }

}