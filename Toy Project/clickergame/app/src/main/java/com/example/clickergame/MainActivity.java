package com.example.clickergame;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ImageView;


public class MainActivity extends AppCompatActivity {

    TextView value = null;
    Button up = null;
    Button down = null;
    int count = 0;
    ImageView ImageView = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        up = (Button) findViewById(R.id.up);
        down = (Button) findViewById(R.id.down);
        value = (TextView) findViewById(R.id.Value);
        ImageView=(ImageView) findViewById(R.id.imageView);
        View.OnClickListener ClickListener = new View.OnClickListener() {
            public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.up:
                        count++;
                        value.setText("" + count);
                        break;

                    case R.id.down:
                        count--;
                        value.setText("" + count);
                        break;



                }

                if( count ==10){
                    Toast.makeText(MainActivity.this,"10에 도달하셨습니다",Toast.LENGTH_SHORT).show();
                    ImageView.setImageResource(R.drawable.egg2);
                }
                else if(count == 20){
                    Toast.makeText(MainActivity.this,"성공!",Toast.LENGTH_SHORT).show();
                    ImageView.setImageResource(R.drawable.egg3);
                }
            }

        };up.setOnClickListener(ClickListener);
        down.setOnClickListener(ClickListener);


    }
}