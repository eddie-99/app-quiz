package com.example.testautomatizado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class RespuestasActivity extends AppCompatActivity {

    TextView cal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_respuestas);
        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(getResources().getColor(R.color.teal_200)));

        cal = findViewById(R.id.cal);

        Bundle bundle = getIntent().getExtras();

        String calificacion = bundle.getString("c");
        String res = bundle.getString("res");

        cal.setText(calificacion + "/10");
    }

    public void openMain5(View view) {startActivity(new Intent(this, BienvenidaActivity.class));}
}