package com.example.dareko;

import android.content.Intent;
import android.os.BatteryManager;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.slider.Slider;

public class home_page extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            EdgeToEdge.enable(this);
            setContentView(R.layout.activity_home_page);
            ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });

            findViewById(R.id.cardView_echo).setOnClickListener(v -> {
                Intent intent = new Intent(this, amazon_ech_dot.class);
                startActivity(intent);
            });
            findViewById(R.id.cardView_light).setOnClickListener(v -> {
                Intent intent = new Intent(this, light.class);
                startActivity(intent);
            });
            findViewById(R.id.cardView_door).setOnClickListener(v -> {
                Intent intent = new Intent(this, front_door.class);
                startActivity(intent);
            });
            findViewById(R.id.cardView_wifi).setOnClickListener(v -> {
                Intent intent = new Intent(this, wifi_router.class);
                startActivity(intent);
            });
            findViewById(R.id.bar).setOnClickListener(v -> {
                Intent intent = new Intent(this, search.class);
                startActivity(intent);
            });
            findViewById(R.id.profile).setOnClickListener(v -> {
                Intent intent = new Intent(this, profile.class);
                startActivity(intent);
            });
            TextView textView = findViewById(R.id.txt);
            Intent intent = getIntent();
            String text = intent.getStringExtra("TextBox");
            textView.setText(text);

            TextView batteryTextView = findViewById(R.id.p);
            BatteryManager batteryManager = (BatteryManager) getSystemService(BATTERY_SERVICE);
            int batteryLevel = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
            batteryTextView.setText("" + batteryLevel + "%");

            TextView batteryTextView2 = findViewById(R.id.p2);
            BatteryManager batteryManager2 = (BatteryManager) getSystemService(BATTERY_SERVICE);
            int batteryLevel2 = batteryManager2.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
            batteryTextView2.setText("" + batteryLevel + "%");

            TextView batteryTextView3 = findViewById(R.id.p3);
            BatteryManager batteryManager3 = (BatteryManager) getSystemService(BATTERY_SERVICE);
            int batteryLevel3 = batteryManager3.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
            batteryTextView3.setText("" + batteryLevel + "%");

            findViewById(R.id.profile).setOnClickListener(v -> {
                String text2 = ((TextView) findViewById(R.id.txt)).getText().toString();
                Intent intent2 = new Intent(this, profile.class);
                intent2.putExtra("text", text2);
                startActivity(intent2);
            });



        }
    @Override
    public void onBackPressed() {
    }


}