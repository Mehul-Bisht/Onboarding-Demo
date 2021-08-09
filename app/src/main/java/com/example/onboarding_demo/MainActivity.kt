package com.example.onboarding_demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.example.onboarding_demo.databinding.ActivityMainBinding
import com.example.onboarding_demo.datastore.DataStorePreferenceStorage
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.concurrent.Executors
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var dataStorePreferenceStorage: DataStorePreferenceStorage

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        lifecycleScope.launchWhenStarted {

            launch {

                dataStorePreferenceStorage.isOnboarded.collectLatest {

                    when (it) {

                        "Keyboard" -> {

                            val intent = Intent(this@MainActivity,KeyBoardActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK.or(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                            startActivity(intent)
                        }

                        "Feed" -> {

                            val intent = Intent(this@MainActivity,FeedViewActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK.or(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                            startActivity(intent)
                        }

                        "Creator" -> {

                            val intent = Intent(this@MainActivity,MemeCreatorActivity::class.java)
                            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK.or(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                            startActivity(intent)
                        }
                    }
                }
            }

           launch {

               delay(300)

               val list = arrayListOf<Item>(
                   Item(
                       "Keyboard",
                       R.drawable.keyboard
                   ),
                   Item(
                       "Feed",
                       R.drawable.feed
                   ),
                   Item(
                       "Creator",
                       R.drawable.creator
                   )
               )

               val adapter = RecyclerviewAdapter(this@MainActivity,list) {

                   when (it) {

                       "Keyboard" -> {

                           lifecycleScope.launchWhenStarted {

                               dataStorePreferenceStorage.save("Keyboard")
                               val intent = Intent(this@MainActivity,KeyBoardActivity::class.java)
                               intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK.or(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                               startActivity(intent)
                           }
                       }

                       "Feed" -> {

                           lifecycleScope.launchWhenStarted {

                               dataStorePreferenceStorage.save("Feed")
                               val intent = Intent(this@MainActivity,FeedViewActivity::class.java)
                               intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK.or(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                               startActivity(intent)
                           }
                       }

                       "Creator" -> {

                           lifecycleScope.launchWhenStarted {

                               dataStorePreferenceStorage.save("Creator")
                               val intent = Intent(this@MainActivity,MemeCreatorActivity::class.java)
                               intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK.or(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                               startActivity(intent)
                           }
                       }
                   }
               }

               binding.recyclerview.scheduleLayoutAnimation()

               binding.recyclerview.adapter = adapter
           }
        }
    }
}