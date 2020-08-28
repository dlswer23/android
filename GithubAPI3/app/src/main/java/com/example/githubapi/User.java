package com.example.githubapi;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.IOException;
import java.sql.SQLTransactionRollbackException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class User extends AppCompatActivity {

private TextView mTestViewResult;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);
        mTestViewResult = findViewById(R.id.ID);


        OkHttpClient client = new OkHttpClient();
        String url ="https://api.github.com/users/dlswer23";
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

                            User.this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    mTestViewResult.setText(myResponse);
                                }
                            });
                        }
                    }
            });
    }
}