package com.example.viewmodel

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // Declare module-level variable
    private lateinit var counterViewModel: CountViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("MainActivity", "onCreate")

        // Initialise the ViewModel
        counterViewModel = ViewModelProviders.of(this).get(CountViewModel::class.java)

        // Add an observer to the CountViewModel
        counterViewModel.count.observe(
            this,
            // it is count
            Observer {
                if(it.equals(4))
                    goodLuck()
            }
        )

        textViewCount.text = counterViewModel.count.value.toString()

        buttonPlus.setOnClickListener {
            counterViewModel.increment()
            textViewCount.text = counterViewModel.count.value.toString()
        }

        buttonMinus.setOnClickListener {
            counterViewModel.decrement()
            textViewCount.text = counterViewModel.count.value.toString()
        }

    }

    private fun goodLuck() {
        Toast.makeText(applicationContext, "Good Luck!!!", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        Log.d("MainActivity", "onDestroy")
        super.onDestroy()
    }
}
