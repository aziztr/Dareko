package com.example.dareko;

import android.content.Intent;
import android.os.BatteryManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.slider.Slider;

public class front_door extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_front_door);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        findViewById(R.id.previous).setOnClickListener(v -> {
            Intent intent = new Intent(this, home_page.class);
            startActivity(intent);
        });
        TextView batteryTextView = findViewById(R.id.textView28);
        BatteryManager batteryManager = (BatteryManager) getSystemService(BATTERY_SERVICE);
        int batteryLevel = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY);
        batteryTextView.setText("" + batteryLevel + "%");
        Slider slider = findViewById(R.id.continuousSlider);
        TextView sliderValueTextView = findViewById(R.id.volume);

        CardView cameraButton = findViewById(R.id.cardView2);
        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                launchCameraApp();
            }
        });

        CardView button = findViewById(R.id.cardView21);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = generateCode();
                Toast.makeText(getApplicationContext(), "Generated code: " + code, Toast.LENGTH_SHORT).show();
            }
        });
        CardView button2 = findViewById(R.id.cardViewcode);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code2 = generateCode();
                Toast.makeText(getApplicationContext(), "Generated code: " + code2, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void launchCameraApp() {
        Log.d("FrontDoor", "Launching camera app");
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE_SECURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "Camera app not found", Toast.LENGTH_SHORT).show();
        }
    }

    private String generateCode() {
        StringBuilder code = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            code.append((int) (Math.random() * 10));
        }
        return code.toString();
    }
    @Override
    public void onBackPressed() {
    }


}