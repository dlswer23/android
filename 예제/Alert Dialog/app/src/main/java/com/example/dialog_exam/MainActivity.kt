package com.example.dialog_exam

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener() {
            dialogTest()
        }

    }

    private fun dialogTest() {
        val dlg: AlertDialog.Builder = AlertDialog.Builder(this, android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar_MinWidth)
        dlg.setTitle("재원이는 천재일까요?") //제목
        dlg.setMessage("자유로운 의견이 좋습니다") // 메시지
        dlg.setPositiveButton("확인", DialogInterface.OnClickListener { dialog, which ->
            next()
        })
        dlg.setNegativeButton("취소", DialogInterface.OnClickListener { dialog, which ->
            finish()
        })
        dlg.show()
    }

    fun next() {
        val intent = Intent(this, NewActivity::class.java)
        startActivity(intent)
    }


}