package com.example.githubapi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import retrofit2.Retrofit;
import retrofit2.http.GET;

public interface RetrofitAPI{
    @GET("/movie.json")
            Call<string>user();
}
public class RetrofitAPI extends AppCompatActivity {
    private Retrofit mRetrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.RetrofitAPI);

    }

    }