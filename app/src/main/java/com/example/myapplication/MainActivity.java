package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HelloFragment fragment = new HelloFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.second_frame, fragment, "Hello 2")
                .commit();
    }
}
