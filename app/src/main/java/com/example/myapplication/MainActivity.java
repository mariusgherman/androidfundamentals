package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements
        Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HelloFragment firstFragment = new HelloFragment();
        Bundle firstBundle = new Bundle();
        firstBundle.putString("message", "This is my first message");
        firstFragment.setArguments(firstBundle);

        HelloFragment secondFragment = new HelloFragment();
        Bundle secondBundle = new Bundle();
        secondBundle.putString("message", "This is my second message");
        secondFragment.setArguments(secondBundle);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.first_frame, firstFragment, "Hello 1")
                .add(R.id.second_frame, secondFragment, "Hello 2")
                .commit();
    }

    @Override
    public void onButtonPressed() {
        HelloFragment secondFragment =
                (HelloFragment) getSupportFragmentManager().findFragmentByTag("Hello 2");
        secondFragment.hideYourButton();
    }
}
