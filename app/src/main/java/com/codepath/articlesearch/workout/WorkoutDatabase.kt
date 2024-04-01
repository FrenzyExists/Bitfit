package com.codepath.articlesearch.workout

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

//@Database(entities = [Workout::class, Exercise::class, Category::class], version = 1)
@Database(entities = [Workout::class], version = 1)
abstract class WorkoutDatabase : RoomDatabase() {
    abstract fun getWorkoutDao(): WorkoutDAO

    companion object {
        @Volatile
        private var INSTANCE: WorkoutDatabase? = null

        fun getDatabase(context: Context): WorkoutDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    WorkoutDatabase::class.java,
                    "workout_database"
                ).build()

                INSTANCE = instance
                instance
            }
        }
    }

}