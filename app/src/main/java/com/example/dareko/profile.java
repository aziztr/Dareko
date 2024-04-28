package com.example.dareko;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class profile extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_profile);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Intent intent = getIntent();
        if (intent != null) {
            String text = intent.getStringExtra("text");
            if (text != null) {
                TextView textView2 = findViewById(R.id.txt2);
                textView2.setText(text);
            }
        }

        ProgressBar progressBar = findViewById(R.id.progressBar2);
        TextView textView = findViewById(R.id.txt3);

        Random random = new Random();
        int progress = random.nextInt(101);

        progressBar.setProgress(progress);
        textView.setText(progress + "Kw");

        findViewById(R.id.previous).setOnClickListener(v -> {
            Intent intent2 = new Intent(this, home_page.class);
            startActivity(intent2);
        });
    }
    @Override
    public void onBackPressed() {
    }
}