package com.example.dareko;

import android.content.Intent;
import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class login_page extends AppCompatActivity {

    private boolean isEmailValid = false;
    private boolean isPasswordValid = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button signInButton = findViewById(R.id.sign_btn);
        signInButton.setOnClickListener(v -> {
            if (isEmailValid && isPasswordValid) {
                Intent intent = new Intent(login_page.this, valid_page.class);
                startActivity(intent);
            } else {
                Toast.makeText(login_page.this, "Please enter a valid email and password", Toast.LENGTH_SHORT).show();
            }
        });

        findViewById(R.id.signup_btn).setOnClickListener(v -> {
            Intent intent = new Intent(this, error.class);
            startActivity(intent);
        });


        EditText emailEditText = findViewById(R.id.editTextTextEmailAddress2);
        emailEditText.addTextChangedListener(emailTextWatcher);


        EditText passwordEditText = findViewById(R.id.editTextTextPassword);
        passwordEditText.addTextChangedListener(passwordTextWatcher);
    }


    private TextWatcher emailTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            checkEmailValidation();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };


    private TextWatcher passwordTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            checkPasswordValidation();
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };


    private void checkEmailValidation() {
        EditText emailEditText = findViewById(R.id.editTextTextEmailAddress2);
        String email = emailEditText.getText().toString();

        if (email.isEmpty() || !email.contains("@")) {
            emailEditText.setError("Please enter a valid email address");
            isEmailValid = false;
        } else {
            emailEditText.setError(null);
            isEmailValid = true;
        }
    }


    private void checkPasswordValidation() {
        EditText passwordEditText = findViewById(R.id.editTextTextPassword);
        String password = passwordEditText.getText().toString();

        if (password.isEmpty() || !password.matches(".*[a-zA-Z].*") || !password.matches(".*[0-9].*") || password.length() < 8) {
            if (password.length() < 8) {
                passwordEditText.setError("Password must be at least 8 characters long");
                isPasswordValid = false;
            } else {
                passwordEditText.setError("Please enter a valid password");
                isPasswordValid = false;
            }
        } else {
            passwordEditText.setError(null);
            isPasswordValid = true;
        }
    }
    @Override
    public void onBackPressed() {
    }
}