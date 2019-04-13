package com.luist.eva2_3_intentos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Intent inLanzarSecundaria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inLanzarSecundaria = new Intent(this, Secundaria.class);
    }

    public void onClick(View v) {
        startActivity(inLanzarSecundaria);
    }
}
