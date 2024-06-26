package com.sanyam.viewmodeldemo2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.sanyam.viewmodeldemo2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]
        binding.resultTextView.text = viewModel.getTotal().toString()

        binding.apply {
            insertButton.setOnClickListener {
                viewModel.setTotal(inputEditText.text.toString().toInt())
                resultTextView.text = viewModel.getTotal().toString()
                inputEditText.text.clear()
            }
        }
    }
}