package com.example.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HelloFragment fragment = new HelloFragment();
        fragment.setListener(this);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.frame, fragment, HelloFragment.class.getSimpleName())
                .commit();
    }

    @Override
    public void theseAreTheNumbers(int no1, int no2) {
        Toast.makeText(this, "These are the numbers, no1: " + no1 + " no2: " + no2, Toast.LENGTH_LONG)
                .show();
    }
}
