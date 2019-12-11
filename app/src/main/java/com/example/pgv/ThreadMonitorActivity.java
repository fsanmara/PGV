package com.example.pgv;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class ThreadMonitorActivity extends AppCompatActivity {

    private Monitor monitor;
    private TextView tvMensajeMonitor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_monitor);

        monitor = new Monitor();

        MiHilo h1 = new MiHilo("1");
        h1.start();
        MiHilo h2 = new MiHilo("2");
        h2.start();
        MiHilo h3 = new MiHilo("3");
        h3.start();

        //join espera a que si un hilo accede a una variable, hasta que no termine
        //de acceder a esa variable, otro hilo no puede acceder a esa variable
        //Y no sigue leyendo el código hasta que terminan de ejecutarse todos los hilos
        try {
            h1.join();
            h2.join();
            h3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        tvMensajeMonitor = findViewById(R.id.tvMensajeMonitor);
        tvMensajeMonitor.setText(monitor.getMensaje());
    }



    private class MiHilo extends Thread{

        private String nombre;

        public MiHilo(String nombre) {

            this.nombre = nombre;
        }

        @Override
        public void run() {

            try {
                Thread.sleep(1000);
                monitor.append("Soy el hilo" + nombre);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    private class Monitor{

        private String mensaje;

        public Monitor() {
            this.mensaje = "";
        }


        public String getMensaje() {
            return mensaje;
        }

        public void setMensaje(String mensaje) {
            this.mensaje = mensaje;
        }

        public synchronized void append(String texto) {

            this.mensaje += texto + "\n";
        }
    }
}
