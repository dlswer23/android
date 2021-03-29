package com.example.clickergame1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    TextView Result = null;
    Button up = null;
    Button down = null;
    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        up = (Button) findViewById(R.id.up_button);
        down = (Button) findViewById(R.id.down_button);
        Result = findViewById(R.id.result);

        View.OnClickListener clickListener = new View.OnClickListener() {

            public void onClick(View view) {

                switch (view.getId()) {


                    case R.id.up_button:
                        count++;
                        Result.setText(""+count);
                        break;
                    case R.id.down_button:
                        count--;
                        Result.setText(""+count);
                        break;

                }
                if (count == 10) {
                    Toast.makeText(MainActivity.this, "10점에 도달했습니다", Toast.LENGTH_SHORT).show();
                } else if (count == 20) {
                    Toast.makeText(MainActivity.this, "20점에 도달했습니다", Toast.LENGTH_SHORT).show();
                }


            }
        };
        up.setOnClickListener(clickListener);
        down.setOnClickListener(clickListener);
    }
}