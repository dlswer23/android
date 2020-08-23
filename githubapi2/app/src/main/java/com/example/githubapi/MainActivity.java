package com.example.githubapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    private RetrofitAPI mRetrofitAPI;
    private Call<string> user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setmRetrofitlnit();
        user;
    }

    private void setmRetrofitlnit() {
        Retrofit mRetrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        mRetrofitAPI = mRetrofit.create(RetrofitAPI.class);
    }

    private void user() {
        muser = mRetrofitAPI.user();
        muser.enqueue(mRetrofitCallback);
    }
    private Gson mGson;


    private Callback<string> mRetrofitCallback = new Callback<string>() {

        @Override
        public void onResponse(Call<String> call, Response<string> response) {
            String result = response.body();
          userVO userVO=(com.example.githubapi.userVO)mGson.fromJson(result, com.example.githubapi.userVO.class)
        }
        @Override

        public void onFailure(Call<String>call,Throwable t){
            t.printStackTrace();
        }

        }
    public void on1(View v) {

        Intent intent = new Intent(getBaseContext(), api.class);
        startActivity(intent);
    }

}