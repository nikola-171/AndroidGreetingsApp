package com.example.greetingsapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

public class NameInput extends AppCompatActivity {

    private Button _buttonCancel = null;
    private Button _buttonSave = null;

    private EditText _firstNameInput = null;
    private EditText _lastNameInput = null;

    private String _firstName = "";
    private String _lastName = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name_input);

        _firstNameInput = findViewById(R.id.input_first_name);
        _lastNameInput = findViewById(R.id.input_last_name);

        _firstNameInput.addTextChangedListener(textWatcher);
        _lastNameInput.addTextChangedListener(textWatcher);


        _buttonCancel = findViewById(R.id.button_cancel);
        _buttonCancel.setOnClickListener(view -> GoToMainPage());
        _buttonSave = findViewById(R.id.button_save);

        _buttonSave.setOnClickListener(view -> GoToMainPage());

    }

    private TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            String firstName = _firstNameInput.getText().toString().trim();
            String lastName = _lastNameInput.getText().toString().trim();

            _buttonSave.setEnabled(!firstName.isEmpty() && !lastName.isEmpty());

            _firstName = firstName;
            _lastName = lastName;
        }

        @Override
        public void afterTextChanged(Editable editable) {

        }
    };

    private void GoToMainPage(){
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("FirstName", this._firstName);
        intent.putExtra("LastName", this._lastName);

        startActivity(intent);
    }
}