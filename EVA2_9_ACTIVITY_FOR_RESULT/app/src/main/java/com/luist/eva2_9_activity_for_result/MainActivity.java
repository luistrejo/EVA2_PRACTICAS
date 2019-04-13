package com.luist.eva2_9_activity_for_result;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView txtVwResu;
    Intent inSecun, inOtra;
    final int SECUNDARIA = 333;
    final int OTRA_ACTIVIDAD = 666;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inSecun = new Intent(this, Secundaria.class);
        inOtra = new Intent(this, OtraActividad.class);
        txtVwResu = findViewById(R.id.txtResu);
    }

    public void onClick(View v) {
        startActivityForResult(inSecun, SECUNDARIA);
    }

    public void onClick2(View v) {
        startActivityForResult(inOtra, OTRA_ACTIVIDAD);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        //1. DISTINGUIR LA ACTIVIDAD QUE DEVUELVE EL RESULTADO

        //2. SABER SI ENVIO RESULTADOS O CANCELO

        //3. PROCEDER LOS DATOS

        if (requestCode == SECUNDARIA) {
            if (resultCode == Activity.RESULT_OK) {
                //PROCESAR LOS RESULTADOS
                //PONERLOS EN EL TEXTVIEW
                String sCade = data.getStringExtra("DATOS");
                txtVwResu.setText(sCade);
            } else if (requestCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "ACCION CANCELADA POR EL USUARIO", Toast.LENGTH_LONG).show();
            }
        } else if (requestCode == OTRA_ACTIVIDAD) {
            if (resultCode == Activity.RESULT_OK) {
                //PROCESAR LOS RESULTADOS
                //PONERLOS EN EL TEXTVIEW
                String sCade = data.getStringExtra("DATOS");
                txtVwResu.setText(sCade);
            } else if (requestCode == Activity.RESULT_CANCELED) {
                Toast.makeText(this, "ACCION CANCELADA POR EL USUARIO", Toast.LENGTH_LONG).show();
            }
        }
    }
}
