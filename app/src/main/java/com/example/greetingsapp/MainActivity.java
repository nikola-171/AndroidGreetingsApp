package com.example.greetingsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button _nameInputActivityButton = null;
    private Button _greetingButton = null;

    private String _firstName = "";
    private String _lastName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _firstName = getIntent().getStringExtra("FirstName");
        _lastName = getIntent().getStringExtra("LastName");

        _nameInputActivityButton = findViewById(R.id.button_name);
        _greetingButton = findViewById(R.id.button_greeting);

        if(_firstName != null && _lastName != null){
            _greetingButton.setEnabled(!_firstName.isEmpty() && !_lastName.isEmpty());
        }

        _nameInputActivityButton.setOnClickListener(view -> OpenNameInputActivity());

        _greetingButton.setOnClickListener(view -> DisplayGreetingMessage());

    }

    private void OpenNameInputActivity() {
        Intent intent = new Intent(this, NameInput.class);

        startActivity(intent);
    }

    private void DisplayGreetingMessage(){
        Toast.makeText(MainActivity.this,
                String.format("Greetings to you %s %s", _firstName, _lastName), Toast.LENGTH_LONG).show();
    }
}