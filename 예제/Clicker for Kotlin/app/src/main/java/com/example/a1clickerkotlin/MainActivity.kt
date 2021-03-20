package com.example.a1clickerkotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import com.google.android.material.snackbar.BaseTransientBottomBar.LENGTH_SHORT

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //레이아웃 선
        var count = 0
        val result = findViewById<TextView>(R.id.tv_result)
        val up = findViewById<Button>(R.id.btn_up)
        val down = findViewById<Button>(R.id.btn_down)



        up.setOnClickListener{

            count++
            result.text = count.toString()

            if (count == 10){
                var t1 = Toast.makeText(this,"10점 달성",Toast.LENGTH_SHORT)
                t1.show()

            }

            else if(count == 20){
                var t1 = Toast.makeText(this,"20점 달성",Toast.LENGTH_SHORT)
                t1.show()
            }


        }

        down.setOnClickListener(){

            count --
            result.text = count.toString()


            if (count == 10){
                var t1 = Toast.makeText(this,"10점 달성",Toast.LENGTH_SHORT)
                t1.show()

            }

            else if(count == 20){
                var t1 = Toast.makeText(this,"20점 달성",Toast.LENGTH_SHORT)
                t1.show()
            }

        }



    }
}