package com.example.onboarding_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.onboarding_demo.databinding.ActivityMemeCreatorBinding

class MemeCreatorActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMemeCreatorBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMemeCreatorBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}