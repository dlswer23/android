package com.example.exchage


import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    var money = findViewById<TextView>(R.id.result)
    val result_button = findViewById<Button>(R.id.result_button)
    var before = findViewById<EditText>(R.id.doallar)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

            var money : Int = 0

        result_button.setOnClickListener(){

            caculator()

            }
        }

    fun caculator(){
        var get = Integer.parseInt(before.getText().toString())
        get *= 1121
        val text = Integer.toString(get)
        money.setText("" + text)
        }
    }



