package com.codepath.articlesearch.start

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentManager
import com.codepath.articlesearch.MainActivity
import com.codepath.articlesearch.R
import com.codepath.articlesearch.main_fragment_manager.MainFragmentManagerActivity

class LoadingActivity : AppCompatActivity() {
    private lateinit var btnStartApp: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_loading)

        btnStartApp = findViewById(R.id.load_btn_next)
        btnStartApp.setOnClickListener {
            val i = Intent(this, MainFragmentManagerActivity::class.java)
            startActivity(i)
        }
    }
}