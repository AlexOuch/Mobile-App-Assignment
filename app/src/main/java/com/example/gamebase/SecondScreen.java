package com.example.gamebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondScreen extends AppCompatActivity {

    Button buttonTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        Intent activityThatCalled = getIntent();
        String console = activityThatCalled.getExtras().getString("CONSOLE");
        buttonTest = findViewById(R.id.buttonTest);

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
        buttonTest.setOnClickListener(new View.OnClickListener() {
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
