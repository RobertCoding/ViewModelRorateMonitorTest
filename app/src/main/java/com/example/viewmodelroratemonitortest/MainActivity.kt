package com.example.viewmodelroratemonitortest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.ViewModelProvider
import com.example.viewmodelroratemonitortest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MyViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(MyViewModel ::class.java)

        viewModel.editTextValue.observe(this) {
            binding.textView.text = it.toString()
        }

        binding.button.setOnClickListener {
            viewModel.editTextValue.value = binding.editTextText.text.toString()

            binding.editTextText.addTextChangedListener {
                viewModel.editTextValue.value = it.toString()
            }
        }
    }
}