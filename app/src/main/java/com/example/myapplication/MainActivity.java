package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.frame, new HelloFragment(), HelloFragment.class.getSimpleName())
                .commit();
    }

    @Override
    protected void onStart() {
        super.onStart();

        HelloFragment fragment =
                (HelloFragment) getSupportFragmentManager().findFragmentByTag(HelloFragment.class.getSimpleName());
        fragment.setLabel("This is a method set label");
    }
}
