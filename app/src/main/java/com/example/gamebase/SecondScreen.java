package com.example.gamebase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondScreen extends AppCompatActivity {

    Button buttonTest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_screen);

        Intent activityThatCalled = getIntent();
        int console = activityThatCalled.getExtras().getInt("CONSOLE");
        buttonTest = findViewById(R.id.buttonTest);

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
