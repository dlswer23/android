package com.example.change;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView result;
    EditText first;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        first = (EditText) findViewById(R.id.first);
        result = (TextView) findViewById(R.id.result);
        button = (Button) findViewById(R.id.button);

        View.OnClickListener onClickListener = new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                if (view.getId() == R.id.button) {
                    if (!first.getText().toString().equals("")) {
                        exchange();
                    } else {
                        Toast.makeText(getApplicationContext(), "값을 입력해주세요", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        };
        button.setOnClickListener(onClickListener);
    }


            void exchange() {
                int count = Integer.parseInt(first.getText().toString());
                count *= 1121;
                String text = Integer.toString(count);
                result.setText(text);
            }
        };
