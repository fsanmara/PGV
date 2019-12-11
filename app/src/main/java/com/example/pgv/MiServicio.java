package com.example.pgv;

import android.app.IntentService;
import android.content.Intent;

import androidx.annotation.Nullable;

public class MiServicio extends IntentService {
    public static final String ACTION = "edu.dam.pgv.miservicio.notify";

    public MiServicio() {
        super("MiServicio");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        int n = intent.getExtras().getInt("N");
        int r = (int) ((Math.random() * n) + 1);

        publishResult(r);
    }

    private void publishResult(int result) {
        Intent intent = new Intent(ACTION);
        intent.putExtra("RESULT", result);
        sendBroadcast(intent);
    }
}
