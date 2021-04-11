package com.example.clickergame_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var count = 0;
        val result = findViewById<TextView>(R.id.tv_result)
        val up = findViewById<Button>(R.id.btn_up)
        val down = findViewById<Button>(R.id.btn_down)


        up.setOnClickListener{
            count++
            result.text = count.toString()
            //result.setText(""+count);

            if(count == 10){
                var t1 = Toast.makeText(this,"10점에 도달했습니다",Toast.LENGTH_SHORT)
                t1.show()
                //Toast.make(MainActivity.this,"10점에 도달했습니다",Toast.LENGTH_SHORT).show
            }

            else if(count == 20) {

                var t1 = Toast.makeText(this,"20점에 도달했습니다",Toast.LENGTH_SHORT)
                t1.show()
            }
        }

        down.setOnClickListener{

            count--
            result.text = count.toString()
            //result.setText(""+count);

            if(count == 10){
                var t1 = Toast.makeText(this,"10점에 도달했습니다",Toast.LENGTH_SHORT)
                t1.show()
                //Toast.make(MainActivity.this,"10점에 도달했습니다",Toast.LENGTH_SHORT).show
            }

            else if(count == 20) {

                var t1 = Toast.makeText(this,"20점에 도달했습니다",Toast.LENGTH_SHORT)
                t1.show()
            }

        }


    }
}