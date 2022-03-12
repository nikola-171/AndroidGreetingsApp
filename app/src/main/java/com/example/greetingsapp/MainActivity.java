package com.example.greetingsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button _nameInputActivityButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _nameInputActivityButton = findViewById(R.id.button_name);
        _nameInputActivityButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                OpenNameInputActivity();
            }
        });

    }

    private void OpenNameInputActivity() {
        Intent intent = new Intent(this, NameInput.class);

        startActivity(intent);
    }
}