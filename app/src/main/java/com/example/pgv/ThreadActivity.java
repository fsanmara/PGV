package com.example.pgv;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class ThreadActivity extends AppCompatActivity {

    //el mensaje lo hace el thread y el toast el mainactivity

    TextView tvMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread);

        tvMensaje = findViewById(R.id.tvMensaje);

        /*new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    Thread.sleep(1000);

                }catch (InterruptedException e){


                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {

                        tvMensaje.setText("Soy el hilo secundario");
                    }
                });

            }
        }).start();*/

        MiHilo h1 = new MiHilo("1");
        h1.start();
        MiHilo h2 = new MiHilo("2");
        h2.start();
        MiHilo h3 = new MiHilo("3");
        h3.start();




        Toast.makeText(this, "Soy el hilo principal", Toast.LENGTH_SHORT).show();

    }

    private class MiHilo extends Thread{

        private String nombre;

        public MiHilo(String nombre) {
            super();

            this.nombre = nombre;
        }

        @Override
        public void run() {

            try {

                Thread.sleep(5000);

            }catch (InterruptedException e){


            }

            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    tvMensaje.setText(tvMensaje.getText().toString() + "\n" + "Soy el hilo" + nombre);

                }

            });

        }
    }
}
