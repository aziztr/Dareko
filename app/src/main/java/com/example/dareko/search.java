package com.example.dareko;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class search extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_search);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        findViewById(R.id.previous).setOnClickListener(v -> {
            Intent intent = new Intent(this, home_page.class);
            startActivity(intent);
        });
        findViewById(R.id.cardView_echo).setOnClickListener(v -> {
            Intent intent = new Intent(this, amazon_ech_dot.class);
            startActivity(intent);
        });
        findViewById(R.id.cardView_light).setOnClickListener(v -> {
            Intent intent = new Intent(this, light.class);
            startActivity(intent);
        });
        findViewById(R.id.cardView_wifi).setOnClickListener(v -> {
            Intent intent = new Intent(this, wifi_router.class);
            startActivity(intent);
        });
        findViewById(R.id.cardView_door).setOnClickListener(v -> {
            Intent intent = new Intent(this, front_door.class);
            startActivity(intent);
        });
        findViewById(R.id.cardView_f).setOnClickListener(v -> {
            Intent intent = new Intent(this, feature.class);
            startActivity(intent);
        });
        findViewById(R.id.cardView_a).setOnClickListener(v -> {
            Intent intent = new Intent(this, feature.class);
            startActivity(intent);
        });
    }
    @Override
    public void onBackPressed() {
    }
}