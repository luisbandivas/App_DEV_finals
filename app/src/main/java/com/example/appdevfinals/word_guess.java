package com.example.appdevfinals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class word_guess extends AppCompatActivity {

    private int randomNumber;
    private EditText guessEditText;
    private TextView resultTextView;
    private TextView lifeCount;
    int life = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word_guess);

        guessEditText = findViewById(R.id.guessEditText);
        resultTextView = findViewById(R.id.resultTextView);
        lifeCount = findViewById(R.id.lifeCount);

        // Generate a random number between 1 and 100
        randomNumber = new Random().nextInt(100) + 1;

        Button submitButton = findViewById(R.id.btn_submit);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkGuess();
            }
        });
        Button resetButton = findViewById(R.id.btn_reset);
        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetGame();
            }
        });

        Toast.makeText(word_guess.this, "Guessing Game", Toast.LENGTH_LONG).show();
    }

    private void checkGuess() {
        String guessString = guessEditText.getText().toString();

        if (life != 0 && !guessString.isEmpty()) {
            try {
                int userGuess = Integer.parseInt(guessString);
                String result;

                if (userGuess < randomNumber) {
                    result = "Try Higher!";
                    life -= 1;

                } else if (userGuess > randomNumber) {
                    result = "Try Lower!";
                    life -= 1;

                } else {
                    result = "You Got it!";
                    resetGame();
                }

                resultTextView.setText(result);
                lifeCount.setText(String.valueOf(life));

            } catch (NumberFormatException e) {
                resultTextView.setText("Please enter a valid number.");
            }
        } else {
            resultTextView.setText("Game Over! Please restart the game.");
            resetGame();
        }
    }

    private void resetGame() {
        randomNumber = new Random().nextInt(100) + 1;
        guessEditText.getText().clear();
        resultTextView.setText("");
        life = 5;
        lifeCount.setText(String.valueOf(life));
    }
}