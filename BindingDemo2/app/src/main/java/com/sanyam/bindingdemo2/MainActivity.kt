package com.sanyam.bindingdemo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import androidx.databinding.DataBindingUtil
import com.sanyam.bindingdemo2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.controlButton.setOnClickListener {
            startOrStopProgressBar()
        }
    }

    private fun startOrStopProgressBar() {
        binding.apply {
            if (progressBar.visibility == View.GONE) {
                progressBar.visibility = View.VISIBLE
                controlButton.text = "Stop This"
            } else {
                progressBar.visibility = View.GONE
                controlButton.text = "Start This"
            }
        }
    }
}