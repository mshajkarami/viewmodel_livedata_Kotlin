package com.irisaco.viewmodel_livedata

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var counterTextView: TextView
    private lateinit var increaseButton: Button

    private val viewModel : CounterViewModel by viewModels()
    private var counter = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        counterTextView =findViewById(R.id.txt_counter)
        increaseButton = findViewById(R.id.btn_increase)

        counterTextView.text = viewModel.getCounter().toString()


        increaseButton.setOnClickListener {
            viewModel.increaseCounter()
            counterTextView.text = viewModel.getCounter().toString()
        }
    }
}