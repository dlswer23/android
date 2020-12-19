package com.example.implicitlntentexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void dialPhone(View view) {
        //아이디 찾
        EditText editText = (EditText) findViewById(R.id.phone_number_edit);
        dialPhonenumber(editText.getText().toString());
    }

    public void dialPhonenumber(String phoneNumber){
        //암시적 인텐드인 Action_Dial을 생성
        Intent intent = new Intent(Intent.ACTION_DIAL);
        //Url 형태의 전화번호를 데이터로 설정
        intent.setData(Uri.parse("tel:"+ phoneNumber));

        //이러한 intent를 처리할 수 있는 Activity를 찾는다면 액티비티를 실행
        if(intent.resolveActivity(getPackageManager()) != null){
            startActivity(intent);
        }
   }
}