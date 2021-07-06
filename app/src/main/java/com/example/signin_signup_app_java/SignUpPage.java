package com.example.signin_signup_app_java;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class SignUpPage extends AppCompatActivity {
    EditText nameField, emailField, passwordField;
    Button signupButton, backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_page);
        nameField = findViewById(R.id.editTextTextPersonName3);
        emailField = findViewById(R.id.editTextTextPersonName4);
        passwordField = findViewById(R.id.editTextTextPersonName5);
        signupButton = findViewById(R.id.button3);

    }
}