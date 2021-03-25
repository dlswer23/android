package com.example.clicker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int count =0;
    TextView result = null;
    Button up = null;
    Button down = null;
    ImageView imageView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        up = (Button) findViewById(R.id.up_btn);
        down = (Button) findViewById(R.id.down_btn);
        result = (TextView) findViewById(R.id.result_tv);
        imageView = (ImageView) findViewById(R.id.imageView);

        View.OnClickListener clickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                switch (v.getId()) {

                    case R.id.up_btn:
                        count++;
                        result.setText("" + count);
                        break;

                    case R.id.down_btn:
                        count--;
                        result.setText("" + count);
                        break;

                }

                if(count == 10){
                    Toast.makeText(MainActivity.this,"알이 부화 중 입니당",Toast.LENGTH_SHORT).show();
                    imageView.setImageResource(R.drawable.egg);
                }

                else if(count == 20){
                    Toast.makeText(MainActivity.this,"병아리가 나왔습니당",Toast.LENGTH_SHORT).show();
                    imageView.setImageResource(R.drawable.cute);
                }

                else if(count == 30){
                    Toast.makeText(MainActivity.this,"치킨 먹고싶당",Toast.LENGTH_SHORT).show();
                    imageView.setImageResource(R.drawable.chicken);
                }
            }
        };
        up.setOnClickListener(clickListener);
        down.setOnClickListener(clickListener);


    }
}