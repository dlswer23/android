package com.example.githubapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class follower extends AppCompatActivity {

    private TextView mTestViewResult2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_follower);

        mTestViewResult2 =  findViewById(R.id.textView3);

        OkHttpClient client = new OkHttpClient();
        String url ="https://api.github.com/users/dlswer23/followers";
        Request request = new Request.Builder()
                .url(url)
                .build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final String myResponse = response.body().string();

                    follower.this.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mTestViewResult2.setText(myResponse);
                        }
                    });
                }
            }
        });

    }
}