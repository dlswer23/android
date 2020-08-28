package com.example.githubapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
    public void button(View v){
        Intent intent = new Intent(getBaseContext(),User.class);

        startActivity(intent);

    }
        public void button2(View v){
            Intent intent = new Intent(getBaseContext(),follower.class);

            startActivity(intent);

    }
}