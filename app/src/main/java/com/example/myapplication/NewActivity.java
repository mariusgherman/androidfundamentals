package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

public class NewActivity extends AppCompatActivity {

    private String height;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_activity);

        if (getIntent().getExtras() != null) {
            height = getIntent().getStringExtra("height");
        }

        findViewById(R.id.analyze).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    int heightInCm = Integer.valueOf(height);
                    if (heightInCm < 0) {
                        setResult(Activity.RESULT_CANCELED);
                        finish();
                    }

                    String isEnough;
                    if (heightInCm < 180) {
                        isEnough = "YES";
                    } else {
                        isEnough = "NO";
                    }

                    Intent intent = new Intent();
                    intent.putExtra("result", isEnough);
                    setResult(Activity.RESULT_OK, intent);

                    finish();
                } catch (NumberFormatException e) {
                    setResult(Activity.RESULT_CANCELED);
                    finish();
                }
            }
        });

        Log.i("Lifecyle", "onCreate - " + height);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("Lifecyle", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("Lifecyle", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("Lifecyle", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("Lifecyle", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("Lifecyle", "onDestroy");
    }
}
