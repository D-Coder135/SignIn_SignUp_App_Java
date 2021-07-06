package com.example.signin_signup_app_java;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
        backButton = findViewById(R.id.button4);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpPage.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}