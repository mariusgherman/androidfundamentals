package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String ANDROID_LOG_TAG = "Android Tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Examples are below. Please uncomment ONE LINE AT A TIME !

        textViewExample();
//        imageViewExample();
//        buttonExample();
//        viewExample();
//        editTextExample();
//        checkBoxExample();
//        radioButtonExample();
//        ratingBarExample();
//        switchExample();
//        seekbarExample();
//        progressBarExample();
    }

    private void textViewExample() {
        setContentView(R.layout.activity_main_textview);
        // get the text from the label
        TextView label = findViewById(R.id.label);
        String labelText = label.getText().toString();

        Log.d(ANDROID_LOG_TAG, labelText);
    }

    private void imageViewExample() {
        setContentView(R.layout.activity_main_imageview);
    }

    private void buttonExample() {
        setContentView(R.layout.activity_main_button);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Button pressed!", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void viewExample() {
        setContentView(R.layout.activity_main_view);
    }

    private void editTextExample() {
        setContentView(R.layout.activity_main_edittext);

        ((EditText) findViewById(R.id.inputbox)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.d(ANDROID_LOG_TAG, "Text in edit text is: " + s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    private void checkBoxExample() {
        setContentView(R.layout.activity_main_checkbox);

        ((CheckBox) findViewById(R.id.checkbox)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Log.d(ANDROID_LOG_TAG, "Checkbox has changed : " + (isChecked ? "Checked" : "Unchecked"));
            }
        });

    }

    private void radioButtonExample() {
        setContentView(R.layout.activity_main_radio_buttons);

        ((RadioGroup) findViewById(R.id.radio_group)).setOnCheckedChangeListener(
                new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup group, int checkedId) {
                        RadioButton checkedButton = group.findViewById(checkedId);
                        Log.d(ANDROID_LOG_TAG, "The checked radio button is : " + checkedButton.getText().toString());
                    }
                });
    }

    private void ratingBarExample() {
        setContentView(R.layout.activity_main_rating_bar);

        ((RatingBar) findViewById(R.id.rating_bar)).setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Log.d(ANDROID_LOG_TAG, "Rating has changed to: " + rating + " stars");
            }
        });
    }

    private void switchExample() {
        setContentView(R.layout.activity_main_switch);

        ((Switch) findViewById(R.id.switch_view)).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this, "The switch is now: " + (isChecked ? "ON" : "OFF"), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void seekbarExample() {
        setContentView(R.layout.activity_main_seekbar);

        ((SeekBar) findViewById(R.id.seek_bar)).setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d(ANDROID_LOG_TAG, "Seek has been changed by user ? " + fromUser + "\nTo progress: " + progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d(ANDROID_LOG_TAG, "Seekbar tracking has started !");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d(ANDROID_LOG_TAG, "Seekbar has been touched !");
            }
        });
    }

    private void progressBarExample() {
        setContentView(R.layout.activity_main_progressbar);

        final ProgressBar progressBar = findViewById(R.id.progress_bar);
        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (progressBar.getVisibility() == View.VISIBLE) {
                    progressBar.setVisibility(View.INVISIBLE);
                } else if (progressBar.getVisibility() == View.INVISIBLE) {
                    progressBar.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
