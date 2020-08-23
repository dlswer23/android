package com.example.githubapi;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class UserActivity extends AppCompatActivity {

    ImageView avatarImg;
    TextView login, following, followers, email;
    Button ownedRepos;

    Bundle extras;
    String newString;

    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        avatarImg = findViewById(R.id.avatar);
        login = findViewById(R.id.login);
        followers = findViewById(R.id.followers);
        following = findViewById(R.id.following);
        email = findViewById(R.id.email);
        ownedRepos = findViewById(R.id.ownedReposBtn);

        extras = getIntent().getExtras();
        newString = extras.getString("username_String");

    }
}