package com.example.gamebase;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class SecondScreen extends AppCompatActivity {

    ImageButton homeButton;
    ImageButton gameButton;
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        Intent activityThatCalled = getIntent();
        String console = activityThatCalled.getExtras().getString("CONSOLE");

        homeButton = findViewById(R.id.homeButton);
        gameButton = findViewById(R.id.gameImageButton);

        TextView title;
        title = findViewById(R.id.titleText);

        if(console.equals("steam")){
            title.setText("Steam");
        }

        if(console.equals("nintendo")){
            title.setText("Nintendo");
        }

        if(console.equals("ps")){
            title.setText("PlayStation");
        }

        if(console.equals("xbox")){
            title.setText("XBox");
        }

        if(console.equals("play")){
            title.setText("Google PlayStore");
        }

        gameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent gameScreenIntent = new Intent(view.getContext(), GameScreen.class);

                finish();
                startActivity(gameScreenIntent);

                //kill activity

            }
        });
        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goBack = new Intent();

                setResult(RESULT_OK, goBack);

                //kill activity
                finish();
            }
        });
    }
}
