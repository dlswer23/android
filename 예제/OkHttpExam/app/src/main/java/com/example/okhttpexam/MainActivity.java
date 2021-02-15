package com.example.okhttpexam;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.WeakHashMap;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //소스를 확인하고 싶은 사이트 주소
        new HttpAsyncTask().execute("http://goo.gl/eIXu9l");
    }
    private class HttpAsyncTask extends AsyncTask<String ,Void, List<Weather>> {

        //Okhttp 클라이언트
        OkHttpClient client = new OkHttpClient();
        @Override
        protected List<Weather> doInBackground(String...params){

            List<Weather> weatherList = new ArrayList<>();
            String strUrl = params[0];
            try {
                //요청
                Request request = new Request.Builder()
                        .url(strUrl)
                        .build();
                //응답
                Response response = client.newCall(request).execute();
                JSONArray jsonArray = new JSONArray(response.body().string());
                for(int i=0;i<jsonArray.length();i++){
                    JSONObject jsonObject = jsonArray.getJSONObject(i);
                    String country= jsonObject.getString("country");
                    String weather = jsonObject.getString("weather");
                    String temperature = jsonObject.getString("temperature");
                    Weather w = new Weather(country, weather,temperature);
                    weatherList.add(w);
                }
                Log.d(TAG,"onCreate: " + weatherList.toString());
            } catch (IOException e){
                e.printStackTrace();
            }catch (JSONException e){
                e.printStackTrace();
            }
            return weatherList;
        }
        @Override드
        protected void onPostExecute(List<Weather> weatherList){
            super.onPostExecute(weatherList);
            if (weatherList != null){
                Log.d("HttpAsynTask", weatherList.toString());

                //리스트뷰를 조작하기 위한 코
                WeatherAdapter adapter = new WeatherAdapter(weatherList);
                mweatherListView.setAdapter(adapter);
            }
        }
    }
}
