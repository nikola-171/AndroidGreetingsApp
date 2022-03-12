package com.example.greetingsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NameInput extends AppCompatActivity {

    private Button _buttonCancel = null;
    private Button _buttonSave = null;

    private String _firstName = "";
    private String _lastName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_input);

        _buttonCancel = findViewById(R.id.button_cancel);
        _buttonCancel.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                GoToMainPage();
            }
        });
        _buttonSave = findViewById(R.id.button_save);

    }

    private void GoToMainPage(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}