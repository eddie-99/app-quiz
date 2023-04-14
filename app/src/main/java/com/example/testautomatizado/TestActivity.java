package com.example.testautomatizado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class TestActivity extends AppCompatActivity {

    private TextView tvPregunta, tvTiempo, tvNumPregunta;
    private RadioGroup radioGroup;
    private RadioButton rb1, rb2, rb3, rb4;
    private Button btnEnviar;
    private CountDownTimer temporizador;

    int totalPreguntas;
    int pContador = 0;
    int calificacion;
    int respuestaNum;

    String correcto = "CORRECTA";
    String incorrecto = "INCORRECTA";

    boolean respuesta;

    private ModeloPreguntas preguntaActual;

    private List<ModeloPreguntas> listaPreguntas;

    Intent i;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(getResources().getColor(R.color.teal_200)));

        listaPreguntas = new ArrayList<>();

        tvPregunta = findViewById(R.id.pregunta);
        tvTiempo = findViewById(R.id.temporizador);
        tvNumPregunta = findViewById(R.id.numPregunta);

        radioGroup = findViewById(R.id.radioGroup);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);

        btnEnviar = findViewById(R.id.btnEnviar);


        agregarPreguntas();
        totalPreguntas = listaPreguntas.size();
        mostrarSiguientePregunta();

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (respuesta == false){
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked()){
                        checkRespuesta();
                        temporizador.cancel();
                    }else {
                        Toast.makeText(TestActivity.this, "Selecciona una opción", Toast.LENGTH_SHORT).show();
                    }
                }else {
                    mostrarSiguientePregunta();
                }
            }
        });
    }

    private void checkRespuesta() {
        respuesta = true;
        RadioButton rbSeleccionado = findViewById(radioGroup.getCheckedRadioButtonId());

        respuestaNum = radioGroup.indexOfChild(rbSeleccionado) + 1;

        if (respuestaNum == preguntaActual.getPreguntaCorrecta()){
            calificacion++;
        }
        if (pContador < totalPreguntas){
            btnEnviar.setText("Siguiente");
        }else{
            Toast.makeText(this, "Test Finalizado", Toast.LENGTH_SHORT).show();
            finish();
            abrir();
        }
    }

    private void abrir() {

        i = new Intent(this, RespuestasActivity.class);
        int promedio = (calificacion*2) / 1;
        String c = String.valueOf(promedio);

        bundle = new Bundle();
        bundle.putString("c", c);
        bundle.putString("res", correcto);

        i.putExtras(bundle);
        startActivity(i);

    }

    private void mostrarSiguientePregunta() {

        radioGroup.clearCheck();

        if (pContador < totalPreguntas){
            timer();
            preguntaActual = listaPreguntas.get(pContador);
            tvPregunta.setText(preguntaActual.getPregunta());
            rb1.setText(preguntaActual.getRes1());
            rb2.setText(preguntaActual.getRes2());
            rb3.setText(preguntaActual.getRes3());
            rb4.setText(preguntaActual.getRes4());

            pContador++;
            btnEnviar.setText("Enviar");
            tvNumPregunta.setText("Pregunta: " + pContador);
            respuesta = false;

        }else {
            finish();
        }
    }

    private void timer() {
        temporizador = new CountDownTimer(11000, 1000) {
            @Override
            public void onTick(long l) {
                tvTiempo.setText("0:" + l/1000);
            }

            @Override
            public void onFinish() {
                mostrarSiguientePregunta();
            }
        }.start();
    }

    private void agregarPreguntas() {
        listaPreguntas.add(new ModeloPreguntas(
                "1.- ¿Cómo se llamaba el avión que transportó la bomba atómica que se lanzó sobre Hiroshima?",
                "Little Boy",
                "Enola Gay", //*
                "Little Wings",
                "Big Boom",
                2));

        listaPreguntas.add(new ModeloPreguntas(
                "2.- ¿Cuál fue el último país en rendirse concluyendo de este modo la Segunda Guerra Mundial?",
                "Alemania",
                "Italia",
                "Japón", //*
                "Austria",
                3));

        listaPreguntas.add(new ModeloPreguntas(
                "3.- ¿Con qué nombre en clave se conocía el decisivo desembarco de Normandía?",
                "Operación Führer",
                "Operación Overlord", //*
                "Operación Freedom",
                "Operación Scape",
                2
        ));

        listaPreguntas.add(new ModeloPreguntas(
                "4.- ¿En qué ciudad se lanzó primero la bomba atómica?",
                "Nagasaki",
                "Hiroshima", //*
                "Pearl Harbour",
                "Tokyo",
                2
        ));

        listaPreguntas.add(new ModeloPreguntas(
                "5.- ¿Cuándo se rindió definitivamente Alemania?",
                "El 8 de mayo de 1945", //*
                "El 30 de abril de 1945",
                "Alemania nunca firmó la rendición",
                "El 5 de mayo de 1945",
                1
        ));
    }
}