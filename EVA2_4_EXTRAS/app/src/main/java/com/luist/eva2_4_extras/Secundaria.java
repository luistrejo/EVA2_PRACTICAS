package com.luist.eva2_4_extras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class Secundaria extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);

        Intent inDatos = getIntent();
        String sNom = inDatos.getStringExtra("MAESTRO");
        Toast.makeText(this, sNom, Toast.LENGTH_LONG).show();
    }
}
