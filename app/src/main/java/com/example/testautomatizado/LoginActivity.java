package com.example.testautomatizado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        getSupportActionBar().setBackgroundDrawable(
                new ColorDrawable(getResources().getColor(R.color.teal_200)));
    }
    public void openMain1(View view) {startActivity(new Intent(this, BienvenidaActivity.class));}
    public void openMain2(View view) {startActivity(new Intent(this, RegistroActivity.class));}
}