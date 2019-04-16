package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Bundle bundle = new Bundle();
        bundle.putString("label", "This is an activity label");
        HelloFragment fragment = new HelloFragment();
        fragment.setArguments(bundle);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.frame, fragment, HelloFragment.class.getSimpleName())
                .commit();
    }
}
