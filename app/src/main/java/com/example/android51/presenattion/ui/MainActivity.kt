package com.example.android51.presenattion.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.android51.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var ui: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ui = ActivityMainBinding.inflate(layoutInflater)

        initialise()
        setContentView(ui.root)
    }

    private fun initialise() {

        ui.rvMain.adapter = EmojiAdapter()
    }
}