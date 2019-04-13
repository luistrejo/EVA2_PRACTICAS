package com.luist.eva2_5_extras_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Secundaria extends AppCompatActivity {
    TextView txtRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secundaria);
        txtRes = findViewById(R.id.txtVwRes);

        Intent inDatos = getIntent();

        txtRes.setText("Nombre:" + inDatos.getStringExtra("NOMBRE") + " \n");
        txtRes.append("Edad:" + inDatos.getIntExtra("EDAD", 0) + " \n");
        txtRes.append("Salario:" + inDatos.getDoubleExtra("SALARIO", 2000) + " \n");
        txtRes.append("Edad:" + inDatos.getIntExtra("EDAD", 0) + " \n");
        if (inDatos.getBooleanExtra("ES_CHAMBEADOR", false)) {
            txtRes.append("Trabaja\n");
        } else {
            txtRes.append("De Sabatico\n");
        }
    }
}
