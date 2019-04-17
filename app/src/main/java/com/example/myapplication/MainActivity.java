package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Listener {

    private boolean userPressedBackForFirstTime = false;
    private boolean isLandscape;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.isLandscape = findViewById(R.id.detail) != null;

        if (savedInstanceState == null) {
            MasterFragment masterFragment = new MasterFragment();
            masterFragment.setListener(this);
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.master, masterFragment, MasterFragment.class.getSimpleName())
                    .commit();
        } else {
            Fragment masterFragment = getSupportFragmentManager().findFragmentByTag(MasterFragment.class.getSimpleName());
            if (masterFragment != null) {
                ((MasterFragment) masterFragment).setListener(this);
            }
        }
    }

    @Override
    public void showHelloFragment() {
        if (isLandscape) {
            addHelloFragment();
        } else {
            Intent intent = new Intent(this, MasterActivty.class);
            intent.putExtra("whatToLoad", "hello");
            startActivity(intent);
        }
    }

    @Override
    public void showAnotherFragment() {
        if (isLandscape) {
            addOtherFragment();
        } else {
            Intent intent = new Intent(this, MasterActivty.class);
            intent.putExtra("whatToLoad", "another");
            startActivity(intent);
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

    @Override
    public void onBackPressed() {
        if (!userPressedBackForFirstTime) {
            Toast.makeText(this, "To exit press back again", Toast.LENGTH_LONG)
                    .show();
            userPressedBackForFirstTime = true;
        } else {
            super.onBackPressed();
        }
    }
}
