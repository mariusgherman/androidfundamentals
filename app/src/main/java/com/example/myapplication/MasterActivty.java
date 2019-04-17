package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MasterActivty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.master_activity);

        String whatToLoad = getIntent().getStringExtra("whatToLoad");

        if (whatToLoad.equals("hello")) {
            addHelloFragment();
        } else if (whatToLoad.equals("another")) {
            addOtherFragment();
        }
    }

    private void addOtherFragment() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.detail, new AnotherFragment(), AnotherFragment.class.getSimpleName())
                .commit();
    }

    private void addHelloFragment() {
        HelloFragment fragment = new HelloFragment();
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.detail, fragment, HelloFragment.class.getSimpleName())
                .commit();
    }
}
