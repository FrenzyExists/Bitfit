package com.codepath.articlesearch.main_fragment_manager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.codepath.articlesearch.R
import com.codepath.articlesearch.databinding.ActivityMainBinding
import com.codepath.articlesearch.databinding.ActivityMainFragmentManagerBinding
import com.codepath.articlesearch.workout.WorkoutAdapter
import com.codepath.articlesearch.workout.WorkoutDatabase
import com.codepath.articlesearch.workout.WorkoutFragment
import com.codepath.articlesearch.workout.WorkoutViewModel
import com.codepath.articlesearch.R.id
import com.codepath.articlesearch.journal.JournalFragment

class MainFragmentManagerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainFragmentManagerBinding

    private lateinit var database: WorkoutDatabase
    private lateinit var viewModelWorkout: WorkoutViewModel
    private lateinit var adapterWorkout: WorkoutAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_fragment_manager)

        binding = ActivityMainFragmentManagerBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(WorkoutFragment())

        binding.navView.setOnItemSelectedListener {
            when (it.itemId) {
                id.workoutOption -> replaceFragment(WorkoutFragment())
                id.journalOption -> replaceFragment(JournalFragment())
            }
            true
        }

        viewModelWorkout = ViewModelProvider (
            this,
            ViewModelProvider.AndroidViewModelFactory.getInstance(application)
        )[WorkoutViewModel::class.java]
    }

    private fun replaceFragment(fragment: Fragment) {
        val tag = fragment.javaClass.simpleName
        val supportFragmentManager = supportFragmentManager
        val existingFragment = supportFragmentManager.findFragmentByTag(tag)

        if (existingFragment == null) {
            supportFragmentManager.beginTransaction()
                .replace(id.nav_host_fragment_activity_main, fragment, tag)
                .commit()
        } else {
            supportFragmentManager.beginTransaction()
                .show(existingFragment)
                .commit()
        }
    }
}