package com.example.exchage
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var result = findViewById<TextView>(R.id.result)
        val result_button = findViewById<Button>(R.id.result_button)
        var before = findViewById<EditText>(R.id.doallar)
        var count = 0

        fun caculator(){
            var count = Integer.parseInt(before.text.toString())
            count *= 1121
            result.text = count.toString()
            Toast.makeText(this,"$count  원 입니다" ,Toast.LENGTH_SHORT).show();
            
        }

        result_button.setOnClickListener(){
            if(count >=0){
                caculator()
            }
            else if(count == 0 || count <= -1){
                var t1 =Toast.makeText(this, "정수를 입력해주세요", Toast.LENGTH_SHORT)
                t1.show()
                }
            }
        }
    }



