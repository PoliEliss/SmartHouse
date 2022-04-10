package com.rorono.smarthouse

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.rorono.smarthouse.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnStart.setOnClickListener {
            if (binding.etInputName.text.toString().trim().isEmpty()) {
                //Toast.makeText(this,"Please enter your name",Toast.LENGTH_LONG).show()
                Snackbar.make(binding.linear, "Please enter your name", Snackbar.LENGTH_LONG).show()
            } else {
                val intent = Intent(this, Menu::class.java)
                startActivity(intent)
                finish()
            }
        }
        }
    }
