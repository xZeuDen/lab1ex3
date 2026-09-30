package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    int secretnum = (int)(Math.random() * 31);
    int count = 0;


    public void guess(View view) {
        EditText txt = findViewById(R.id.guess);
        TextView highlow = findViewById(R.id.higherlower);
        TextView numg = findViewById(R.id.numGuesses);
        Button again = findViewById(R.id.playagain);

        String input = txt.getText().toString();

        if(input.isEmpty()){
            txt.setError("Please enter a num");
            txt.requestFocus();
            return;
        }

        int guesses = Integer.parseInt(input);
        count ++;
        if(guesses < 1 || guesses > 30){
            txt.setError("Number has to be between 1 and 30");
            txt.requestFocus();
            return;
        }
        numg.setText("Number of Guesses: " + count);

        if(guesses < secretnum){
            highlow.setText("Higher");
        }else if(guesses > secretnum){
            highlow.setText("Lower");
        }else {
            highlow.setText("You guessed!");
            again.setVisibility(View.VISIBLE);
        }
    }

    public void playagain(View view) {
        EditText txt = findViewById(R.id.guess);
        TextView highlow = findViewById(R.id.higherlower);
        TextView numg = findViewById(R.id.numGuesses);
        Button again = findViewById(R.id.playagain);

        int secretnum = (int)(Math.random() * 31);
        count = 0;

        txt.setText("");
        highlow.setText("Guess a number");
        numg.setText("Number of guesses: 0");
        again.setVisibility(View.INVISIBLE);

    }
}