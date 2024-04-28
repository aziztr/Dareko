package com.example.dareko;

import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.text.format.Formatter;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class wifi_router extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_wifi_router);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        findViewById(R.id.previous).setOnClickListener(v -> {
            Intent intent = new Intent(this, home_page.class);
            startActivity(intent);
        });
        WifiManager wifiManager = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        String wifiConfig = String.valueOf(wifiManager.getConnectionInfo().getIpAddress());
        String password = String.valueOf(wifiConfig);

        EditText passwordEditText = findViewById(R.id.pwd);
        passwordEditText.setText(password);

        WifiManager wifiManager2 = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager2.getConnectionInfo();

        EditText ssidEditText = findViewById(R.id.ssid);
        ssidEditText.setText(wifiInfo.getSSID());

        EditText ipEditText = findViewById(R.id.ipadd);
        ipEditText.setText(Formatter.formatIpAddress(wifiInfo.getIpAddress()));

        WifiManager wifiManager3 = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        String wifiConfig2 = String.valueOf(wifiManager3.getConnectionInfo().getMaxSupportedTxLinkSpeedMbps());
        String ping = String.valueOf(wifiConfig2);
        TextView pingx = findViewById(R.id.ping);
        pingx.setText(ping + "ms");

        WifiManager wifiManager4 = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        String wifiConfig3 = String.valueOf(wifiManager4.getConnectionInfo().getWifiStandard());
        String data = String.valueOf(wifiConfig3);
        TextView datax = findViewById(R.id.data);
        datax.setText(data + "gb");

        TextView textView = findViewById(R.id.wname);

        WifiManager wifiManager5 = (WifiManager) getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo4 = wifiManager5.getConnectionInfo();
        String wifiSSID = wifiInfo4.getBSSID();

        textView.setText("Connected to: " + wifiSSID);
    }
    @Override
    public void onBackPressed() {
    }
}