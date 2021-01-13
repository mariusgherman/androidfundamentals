package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends AppCompatActivity {

    private static final String MY_SHARED_PREFS = "my_prefs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        EditText username = findViewById(R.id.username);
        EditText password = findViewById(R.id.password);

        findViewById(R.id.login_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().isEmpty()) {
                    return;
                }
                if (password.getText().toString().isEmpty()) {
                    return;
                }

                // TODO - validate login is correct
                saveUserSession();
                startMainActivity();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences sharedPreferences = getSharedPreferences(MY_SHARED_PREFS, Context.MODE_PRIVATE);
        boolean isUserLoggedIn = sharedPreferences.getBoolean("is_logged_in", false);

        if (isUserLoggedIn) {
            startMainActivity();
        }
    }

    private void startMainActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void saveUserSession() {
        SharedPreferences sharedPreferences = getSharedPreferences(MY_SHARED_PREFS, Context.MODE_PRIVATE);
        sharedPreferences.edit().putBoolean("is_logged_in", true).apply();
    }
}