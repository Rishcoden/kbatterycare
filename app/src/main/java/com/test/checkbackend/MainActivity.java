package com.test.checkbackend;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ActivityResultLauncher<Intent> launcher = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), result -> {
        if (result.getResultCode() == Activity.RESULT_OK) {
            // Handle the result if needed
        }
    });

    WifiManager wlte;
    TextView rDisp;
    Button bt,bt1,bt2,bt3,bt4,bt5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = (Button)findViewById(R.id.wifibopt);
        wlte = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
        rDisp = (TextView)findViewById(R.id.disp);
        bt1 =(Button)findViewById(R.id.wifibopt2);
        bt2 = (Button)findViewById(R.id.Rblue);
        bt3 = (Button)findViewById(R.id.Rloc);
        bt4 = (Button)findViewById(R.id.Rsync);
        bt5 = (Button)findViewById(R.id.Rbat);


        if (wlte.isWifiEnabled()){
            rDisp.setText("Kwifi Staus:activated");
        }
        else{
            rDisp.setText("Kwifi Staus:Deactivated");
        }

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                WifiManager my_wifi = (WifiManager)getApplicationContext().getSystemService(Context.WIFI_SERVICE);
                my_wifi.setWifiEnabled(false);

            }
        });

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Settings.ACTION_WIFI_SETTINGS);
                launcher.launch(intent);

            }
        });

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Settings.ACTION_BLUETOOTH_SETTINGS);
                launcher.launch(intent);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                launcher.launch(intent);
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Settings.ACTION_SYNC_SETTINGS);
                launcher.launch(intent);
            }
        });
        bt5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Settings.ACTION_BATTERY_SAVER_SETTINGS);
                launcher.launch(intent);
            }
        });





    }
}