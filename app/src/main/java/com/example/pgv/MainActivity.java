package com.example.pgv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnThread;
    Button btnThreadMonitor;
    Button btnAsyncTask;
    Button btnServicios;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnThread = findViewById(R.id.btnThread);
        btnThreadMonitor = findViewById(R.id.btnThreadMonitor);
        btnAsyncTask = findViewById(R.id.btnAsynctask);
        btnServicios = findViewById(R.id.btnServicios);


        btnThread.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ThreadActivity.class);
                startActivity(intent);
            }
        });

        btnThreadMonitor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ThreadMonitorActivity.class);
                startActivity(intent);
            }
        });



        btnAsyncTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, AsyncTaskActivity.class);
                startActivity(intent);
            }
        });

        btnServicios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, IntentServiceActivity.class);
                startActivity(intent);
            }
        });
    }
}
