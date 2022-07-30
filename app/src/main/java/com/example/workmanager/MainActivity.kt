package com.example.workmanager

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.format.Time
import androidx.constraintlayout.widget.ConstraintSet
import androidx.work.*
import kotlinx.android.synthetic.main.activity_main.*
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            setUpWorker()
        }
    }

    private fun setUpWorker() {
        val constraint = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.UNMETERED)
            .build()

       /* val workerRequest = OneTimeWorkRequestBuilder<GithubWorker>()
            .setConstraints(constraint)
            .setInitialDelay(30 , TimeUnit.SECONDS)
            .build()

        */


        val workerRequest = PeriodicWorkRequestBuilder<GithubWorker>(15 , TimeUnit.MINUTES)
            .setConstraints(constraint)
            .setInitialDelay(30 , TimeUnit.SECONDS)
            .build()

        WorkManager.getInstance(this).enqueue(workerRequest)
    }
}