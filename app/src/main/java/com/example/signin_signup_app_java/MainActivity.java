package com.example.signin_signup_app_java;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText emailField, passwordField;
    Button signUpButton, loginButton;

//    I will be using an offline database.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailField = findViewById(R.id.editTextTextPersonName);
        passwordField = findViewById(R.id.editTextTextPersonName2);

        signUpButton = findViewById(R.id.button2);
        loginButton = findViewById(R.id.button);

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUpPage.class);
            }
        });
    }
}