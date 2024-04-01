package com.codepath.articlesearch.main_fragment_manager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.codepath.articlesearch.R
import com.codepath.articlesearch.databinding.ActivityMainBinding
import com.codepath.articlesearch.workout.WorkoutAdapter
import com.codepath.articlesearch.workout.WorkoutDatabase
import com.codepath.articlesearch.workout.WorkoutViewModel

class MainFragmentManagerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var database: WorkoutDatabase
    lateinit var viewModel: WorkoutViewModel
    lateinit var adapter: WorkoutAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragment_manager)
    }
}