package com.example.pgv;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AsyncTaskActivity extends AppCompatActivity {

    private Monitor monitor;
    private TextView tvMensajeAsyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_async_task);

        monitor = new Monitor();

        MiTareaAsincrona miTarea1 = new MiTareaAsincrona();
        miTarea1.execute("1");
        MiTareaAsincrona miTarea2 = new MiTareaAsincrona();
        miTarea2.execute("2");
        MiTareaAsincrona miTarea3 = new MiTareaAsincrona();
        miTarea3.execute("3");

        tvMensajeAsyncTask = findViewById(R.id.tvMensajeAsyncTask);
        tvMensajeAsyncTask.setText(monitor.getMensaje());

    }
//los parámetros son: los datos que le voy a pasar,lo que voy a procesar, el resultado final

    private class MiTareaAsincrona extends AsyncTask<String, String, Boolean>{

        @Override
        protected Boolean doInBackground(String... strings) {

            publishProgress(strings);
            //en la tarea 2 aquí se pasa la vocal

            return true;
        }

        @Override
        protected void onProgressUpdate(String... values) {
            //en la tarea 2 aquí se cuenta las vocales
            try {
                Thread.sleep(1000);
                monitor.append("Soy el hilo" + values);

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
