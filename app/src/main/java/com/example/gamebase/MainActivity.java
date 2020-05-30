package com.example.gamebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    ImageButton psScreenButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        psScreenButton = findViewById(R.id.psButton);
        psScreenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent secondScreenIntent = new Intent(view.getContext(), SecondScreen.class);
                secondScreenIntent.putExtra("CONSOLE", 3);
                startActivity(secondScreenIntent);
            }
        });
    }
}
