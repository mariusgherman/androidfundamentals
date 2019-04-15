package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activity_layout);
        Log.d("LIFECYCLE_TAG", "onCreate");

        setupForImplicitIntent();
        setupForExplicitIntent();
        setupForActivityResult();
    }

    private void setupForImplicitIntent() {
        findViewById(R.id.implicit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://wwww.google.com"));
                startActivity(intent);
            }
        });
    }

    private void setupForExplicitIntent() {
        findViewById(R.id.explicit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void setupForActivityResult() {
        findViewById(R.id.result).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyActivity.this, MainActivity.class);
                intent.putExtra("key", "New label");
                startActivityForResult(intent, 2000);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2000 && resultCode == Activity.RESULT_OK) {
            if (data != null) {
                String result = data.getStringExtra("result");
                Toast.makeText(this, "The result is: " + result, Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("LIFECYCLE_TAG", "onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("LIFECYCLE_TAG", "onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("LIFECYCLE_TAG", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("LIFECYCLE_TAG", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("LIFECYCLE_TAG", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("LIFECYCLE_TAG", "onDestroy");
    }
}
