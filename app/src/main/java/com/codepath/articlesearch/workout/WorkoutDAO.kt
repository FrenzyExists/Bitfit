package com.codepath.articlesearch.workout

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface WorkoutDAO {
    @Query("SELECT * FROM workout_table")
    suspend fun getAllWorkoutSessions(): LiveData<List<Workout>>

    @Query("SELECT * FROM exercises_table WHERE category_id = :categoryId")
    suspend fun getExercisesForCategory(categoryId: Long): LiveData<List<Exercise>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertExercise(exercise: Exercise)

    // Total Reps Done for Exercises in a Category
    @Query("SELECT SUM(work.reps) " +
            "FROM workout_table work " +
            "INNER JOIN exercises_table ex ON work.exercise = ex.exerciseId " +
            "WHERE ex.category_id = :categoryId")
    fun getTotalRepsForCategory(categoryId: Long): LiveData<Int?>

    // Most Commonly Performed Exercises
    @Query("SELECT exercise, COUNT(*) AS count FROM workout_table GROUP BY exercise ORDER BY count DESC")
    fun getMostCommonExercises(): LiveData<List<ExerciseCount>>

    // Get the current streak of workout sessions
//    @Query("SELECT MAX(streak) FROM (" +
//            "  SELECT " +
//            "    SUM(CASE WHEN date(creation_date, '-1 days') = lag_date THEN 0 ELSE 1 END) OVER (ORDER BY creation_date) as streak " +
//            "  FROM (" +
//            "    SELECT " +
//            "      creation_date, " +
//            "      LAG(date(creation_date)) OVER (ORDER BY creation_date) as lag_date " +
//            "    FROM workout_table" +
//            "  )" +
//            ")")
//      SUM(CASE WHEN date(creation_date, '-1 days') THEN 0 ELSE 1 END)
//    @Query("WITH ranked_workouts AS (\n" +
//            "    SELECT *,\n" +
//            "           ROW_NUMBER() OVER (PARTITION BY exerciseId ORDER BY creation_date DESC) AS rn\n" +
//            "    FROM workout_table\n" +
//            "),\n" +
//            "streaks AS (\n" +
//            "    SELECT exerciseId,\n" +
//            "           creation_date,\n" +
//            "           DENSE_RANK() OVER (PARTITION BY exerciseId ORDER BY rn - ROW_NUMBER() OVER (PARTITION BY exerciseId ORDER BY creation_date) DESC) AS streak\n" +
//            "    FROM ranked_workouts\n" +
//            ")\n" +
//            "SELECT exerciseId, MAX(streak) AS latest_streak\n" +
//            "FROM streaks\n" +
//            "GROUP BY exerciseId;")
//    fun getCurrentStreak(): LiveData<Int?>
}