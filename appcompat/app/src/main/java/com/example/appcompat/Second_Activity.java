package com.example.appcompat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.view.View;
import android.widget.TextView;

public class Second_Activity extends AppCompatActivity implements View.OnClickListener {

    private TextView mMessageTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String age = intent.getStringExtra("age");

        mMessageTextView =(TextView)findViewById(R.id.message_edit_text);
        mMessageTextView.setText(age + " 살 " + name);

        findViewById(R.id.result_button).setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        Intent intent = new Intent();
        intent.putExtra("result",mMessageTextView.getText().toString());
        //결과 전달
        setResult(RESULT_OK, intent);
        //이 액티비티 종료
        finish();
    }
}