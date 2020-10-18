package com.example.appcompat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static final int REQUEST_CODE = 1000;


    private EditText mNameEditText;
    private EditText mAgeEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //화면에 레이아웃 표시

        setContentView(R.layout.activity_main);

        mNameEditText = (EditText) findViewById(R.id.name_edit);
        mAgeEditText = (EditText) findViewById(R.id.age_edit);

        findViewById(R.id.submit_button).setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent(this, Second_Activity.class);

        intent.putExtra("name", mNameEditText.getText().toString());
        intent.putExtra("Age", mAgeEditText.getText().toString());

        startActivityForResult(intent, REQUEST_CODE);

    }


    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK && data != null){
            //결과를 받음
            String result = data.getStringExtra("result");
            //토스트 메시지 표시
            Toast.makeText(MainActivity.this,result,Toast.LENGTH_SHORT).show();
        }

    }
}