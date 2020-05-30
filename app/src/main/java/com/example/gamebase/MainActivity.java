package com.example.gamebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton searchButton;
    ImageButton steamScreenButton;
    ImageButton nintendoScreenButton;
    ImageButton psScreenButton;
    ImageButton xboxScreenButton;
    ImageButton playScreenButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchButton = findViewById(R.id.searchButton);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        steamScreenButton = findViewById(R.id.steamButton);
        steamScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent secondScreenIntent = new Intent(view.getContext(), SecondScreen.class);
                secondScreenIntent.putExtra("CONSOLE", "steam");
                startActivity(secondScreenIntent);
            }
        });

        nintendoScreenButton = findViewById(R.id.nintendoButton);
        nintendoScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent secondScreenIntent = new Intent(view.getContext(), SecondScreen.class);
                secondScreenIntent.putExtra("CONSOLE", "nintendo");
                startActivity(secondScreenIntent);
            }
        });

        psScreenButton = findViewById(R.id.psButton);
        psScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent secondScreenIntent = new Intent(view.getContext(), SecondScreen.class);
                secondScreenIntent.putExtra("CONSOLE", "ps");
                startActivity(secondScreenIntent);
            }
        });

        xboxScreenButton = findViewById(R.id.xboxButton);
        xboxScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent secondScreenIntent = new Intent(view.getContext(), SecondScreen.class);
                secondScreenIntent.putExtra("CONSOLE", "xbox");
                startActivity(secondScreenIntent);
            }
        });

        playScreenButton = findViewById(R.id.playButton);
        playScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent secondScreenIntent = new Intent(view.getContext(), SecondScreen.class);
                secondScreenIntent.putExtra("CONSOLE", "play");
                startActivity(secondScreenIntent);
            }
        });


    }
}
