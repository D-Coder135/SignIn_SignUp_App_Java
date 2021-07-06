package com.example.signin_signup_app_java;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
                String name = nameField.getText().toString();
                String email = emailField.getText().toString();
                String password = passwordField.getText().toString();

                if (name.equals("") || email.equals("") || password.equals("")) {
                    Toast.makeText(SignUpPage.this, "Please fill all the details!", Toast.LENGTH_SHORT).show();
                } else {
                    SQLiteDatabase sqLiteDatabase = openOrCreateDatabase("offlineDatabase", MODE_PRIVATE, null);
                    sqLiteDatabase.execSQL("create table if not exists student (name varchar, email varchar, password varchar)");
                    String data = "select * from student where email='" + email + "' and password = '" + password + "'";
                    Cursor cursor = sqLiteDatabase.rawQuery(data, null);

                    if (cursor.getCount() > 0) {
                        Toast.makeText(SignUpPage.this, "User Already Registered!", Toast.LENGTH_SHORT).show();
                    } else {
                        sqLiteDatabase.execSQL("insert into student values ('" + name + "', '" + email + "', '" + password + "')");
                        Toast.makeText(SignUpPage.this, "Congratulations, User Is Registered!", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(SignUpPage.this, MainActivity.class);
                        startActivity(intent);
                    }
                }
            }
        });
    }
}