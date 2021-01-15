package com.serafinebot.dint.lesson8a;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;

public class MainActivity extends AppCompatActivity {
    private static final String STATE_SCORE_1 = "score1";
    private static final String STATE_SCORE_2 = "score2";
    private int score_1 = 0;
    private int score_2 = 0;
    private TextView counter_1;
    private TextView counter_2;
    private ImageButton team1MinusBtn;
    private ImageButton team1PlusBtn;
    private ImageButton team2MinusBtn;
    private ImageButton team2PlusBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.counter_1 = findViewById(R.id.team1counter);
        this.counter_2 = findViewById(R.id.team2counter);
        this.team1MinusBtn = findViewById(R.id.team1minus);
        this.team1PlusBtn = findViewById(R.id.team1plus);
        this.team2MinusBtn = findViewById(R.id.team2minus);
        this.team2PlusBtn = findViewById(R.id.team2plus);

        if (savedInstanceState != null) {
            this.score_1 = savedInstanceState.getInt(STATE_SCORE_1);
            this.score_2 = savedInstanceState.getInt(STATE_SCORE_2);
            updateScore();
        }
    }

    public void updateScore() {
        this.counter_1.setText(String.valueOf(this.score_1));
        this.counter_2.setText(String.valueOf(this.score_2));
    }

    public void increaseScore(View view) {
        if (view.equals(this.team1PlusBtn)) {
            this.score_1++;
        } else if (view.equals(this.team2PlusBtn)) {
            this.score_2++;
        }
        updateScore();
    }

    public void decreaseScore(View view) {
        if (view.equals(this.team1MinusBtn)) {
            this.score_1--;
        } else if (view.equals(this.team2MinusBtn)) {
            this.score_2--;
        }
        updateScore();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
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
        if (item.getItemId() == R.id.night_mode) {
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            recreate();
        }
        return true;
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(STATE_SCORE_1, this.score_1);
        outState.putInt(STATE_SCORE_2, this.score_2);
        super.onSaveInstanceState(outState);
    }
}