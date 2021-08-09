package com.example.onboarding_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.transition.Explode
import android.transition.Slide
import android.view.Window
import com.example.onboarding_demo.databinding.ActivityKeyBoardBinding

class KeyBoardActivity : AppCompatActivity() {

    private lateinit var binding: ActivityKeyBoardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityKeyBoardBinding.inflate(layoutInflater)

        setContentView(binding.root)
    }
}