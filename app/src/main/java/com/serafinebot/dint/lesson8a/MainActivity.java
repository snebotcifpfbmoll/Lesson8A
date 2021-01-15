package com.serafinebot.dint.lesson8a;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView counter_1;
    private TextView counter_2;
    private ImageButton team1MinusBtn;
    private ImageButton team1PlusBtn;
    private ImageButton team2MinusBtn;
    private ImageButton team2PlusBtn;
    private int score_1 = 0;
    private int score_2 = 0;

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
}