package com.bangla.nobijider.kahini.todo_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bangla.nobijider.kahini.todo_kotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //setSupportActionBar(binding.toolbar)
    }
}