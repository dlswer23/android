package com.example.chickenclickergame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int count = 0;
    Button up = null;
    Button down = null;
    TextView result = null;
    ImageView photo = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        up = (Button) findViewById(R.id.up_button);
        down = (Button) findViewById(R.id.down_button);
        result = (TextView) findViewById(R.id.result);
        photo = (ImageView) findViewById(R.id.photo);

        View.OnClickListener clickListener = new View.OnClickListener()  {

            @Override
            public void onClick(View v) {

                switch (v.getId()) {

                    case R.id.up_button:
                        count++;
                        result.setText(" " + count);
                        break;

                    case R.id.down_button:
                        count--;
                        result.setText(" " + count);
                        break;
                }

                if (count == 10) {
                    Toast.makeText(MainActivity.this, "10점에 도달하였습니다", Toast.LENGTH_LONG).show();
                    photo.setImageResource(R.drawable.cute);

                } else if (count == 20) {
                    Toast.makeText(MainActivity.this, "20점에 도달하였습니다", Toast.LENGTH_LONG).show();
                    photo.setImageResource(R.drawable.chicken);

                } else if (count == 30) {
                    Toast.makeText(MainActivity.this, "30점에 도달하였습니다", Toast.LENGTH_LONG).show();
                }
            }

        };
        up.setOnClickListener(clickListener);
        down.setOnClickListener(clickListener);


    }
}