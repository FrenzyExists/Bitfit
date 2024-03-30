package com.pikachu.bitfit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.pikachu.bitfit.journal.JournalAdapter
import com.pikachu.bitfit.journal.JournalDatabase
import com.pikachu.bitfit.journal.JournalViewModel

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private lateinit var database: JournalDatabase
    private lateinit var viewModel: JournalViewModel
    private lateinit var adapter: JournalAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}