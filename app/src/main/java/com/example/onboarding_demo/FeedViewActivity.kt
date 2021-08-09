package com.example.onboarding_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.onboarding_demo.databinding.ActivityFeedViewBinding

class FeedViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFeedViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeedViewBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}