package com.example.signin_signup_app_java;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText emailField, passwordField;
    Button signUpButton, loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        emailField = findViewById(R.id.editTextTextPersonName);
        passwordField = findViewById(R.id.editTextTextPersonName2);

        signUpButton = findViewById(R.id.button2);
        loginButton = findViewById(R.id.button);

        signUpButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, SignUpPage.class);
            startActivity(intent);
            finish();
        });

        loginButton.setOnClickListener(v -> {
            String email = emailField.getText().toString();
            String password = passwordField.getText().toString();

            if (email.equals("") || password.equals("")) {
                Toast.makeText(MainActivity.this, "Please Fill All The Fields!", Toast.LENGTH_SHORT).show();
            } else {
                //    I will be using an offline database.
                SQLiteDatabase sqLiteDatabase = openOrCreateDatabase("offlineDatabase", MODE_PRIVATE, null);
                String data = "select * from student where email = '" + email + "' and password = '" + password + "'";
                Cursor cursor = sqLiteDatabase.rawQuery(data, null);

                if (cursor.getCount() > 0) {
                    Toast.makeText(MainActivity.this, "Logged In Successfully!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, WelcomePage.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(MainActivity.this, "Invalid Details!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}