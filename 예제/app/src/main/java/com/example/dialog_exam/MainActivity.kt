package com.example.dialog_exam

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.RatingBar
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    override fun onBackPressed(){


        val builder = AlertDialog.Builder(this)
        builder.setTitle("Are you sure?")
        builder.setTitle("Do you want to close the app")
        builder.setPositiveButton("Yes",{ dialogInterface : DialogInterface,i :Int->
            finish()
        })
        builder.setNegativeButton("No",{ dialogInterface: DialogInterface, i: Int -> })
        builder.show()
        
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
}