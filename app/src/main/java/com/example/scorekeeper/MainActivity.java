package com.example.scorekeeper;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static  String STATE_SCORE_1;
    private static  String STATE_SCORE_2;
    int score1 = 0;
    int score2 = 0;
    TextView scoreview1;
    TextView scoreview2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        scoreview1 = findViewById(R.id.score1);
        scoreview2 = findViewById(R.id.score2);
        STATE_SCORE_1="Team value 1";
        STATE_SCORE_2="Team value 2";
        if (savedInstanceState != null) {
            score1 = savedInstanceState.getInt(STATE_SCORE_1);
            score2 = savedInstanceState.getInt(STATE_SCORE_2);
            scoreview1.setText(String.valueOf(score1));
            scoreview2.setText(String.valueOf(score2));
        }

    }

    public void increasescore(View view) {

        switch (view.getId()) {
            case R.id.sumar1:
                score1 += 1;
                scoreview1.setText(String.valueOf(score1));
                break;
            case R.id.sumar2:
                score2 += 1;
                scoreview2.setText(String.valueOf(score2));
                break;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_SCORE_1, score1);
        outState.putInt(STATE_SCORE_2, score2);
        super.onSaveInstanceState(outState);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
//Inflate the menu from XML
        getMenuInflater().inflate(R.menu.main_menu, menu);
//Change the label of the menu based on the state of the app
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else {
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.night_mode) {//Get the night mode state of the app
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }

        }
        recreate();
        return true;

    }

    public void decreasescore(View view) {

        switch (view.getId()) {
            case R.id.restar1:
                score1 -= 1;
                scoreview1.setText(String.valueOf(score1));
                break;
            case R.id.restar2:
                score2 -= 1;
                scoreview2.setText(String.valueOf(score2));
                break;
        }
    }

}