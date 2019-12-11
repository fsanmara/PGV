package com.example.pgv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class IntentServiceActivity extends AppCompatActivity {
    private EditText etN;
    private Button btnGenerarAleatorio;
    private BroadcastReceiver broadcastReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service);

        etN = findViewById(R.id.etN);
        btnGenerarAleatorio = findViewById(R.id.btnGenerarAleatorio);
        btnGenerarAleatorio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntentServiceActivity.this, MiServicio.class);
                String n = etN.getText().toString().trim();
                if (n.equals("")) {
                    intent.putExtra("N", 10);
                } else {
                    intent.putExtra("N", Integer.parseInt(n));
                }
                startService(intent);
            }
        });

        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int result = intent.getExtras().getInt("RESULT");
                Toast.makeText(IntentServiceActivity.this,
                        "Aleatorio generado: " + result,
                        Toast.LENGTH_LONG).show();
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(broadcastReceiver, new IntentFilter(MiServicio.ACTION));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadcastReceiver);
    }
}