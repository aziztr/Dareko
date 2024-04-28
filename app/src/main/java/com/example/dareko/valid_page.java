package com.example.dareko;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class valid_page extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_valid_page);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        findViewById(R.id.terms_of_use1).setOnClickListener(v -> {
            Intent intent = new Intent(this, terms_of_use.class);
            startActivity(intent);
        });
        findViewById(R.id.buttonC).setOnClickListener(v -> {
            EditText dnameEditText = findViewById(R.id.dname);
            EditText usrnEditText = findViewById(R.id.usrn);
            String dname = String.valueOf(dnameEditText.getText());
            String usrn = String.valueOf(usrnEditText.getText());

            if (dname.isEmpty() || usrn.isEmpty()) {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(this, home_page.class);
                intent.putExtra("dname", dname);
                intent.putExtra("usrn", usrn);

                EditText editText = findViewById(R.id.dname);
                String text = String.valueOf(editText.getText());
                intent.putExtra("TextBox", text);

                startActivity(intent);
            }
        });



    }
    @Override
    public void onBackPressed() {
    }
}