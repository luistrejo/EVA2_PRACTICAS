package com.luist.eva2_5_extras_2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {
    Intent inSecun;
    EditText eTxtNom, eTxtEdad, eTxtSal;
    CheckBox cBoxtrabaja;
    RadioButton rBtnSoltero, rBtnJuntado, rBtnDivorciado, rBtnCasado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inSecun = new Intent(this, Secundaria.class);
        eTxtNom = findViewById(R.id.eTxtNombre);
        eTxtEdad = findViewById(R.id.eTxtEdad);
        eTxtSal = findViewById(R.id.eTxtSal);
        rBtnSoltero = findViewById(R.id.rBtnSoltero);
        rBtnDivorciado = findViewById(R.id.rBtnDivorciado);
        rBtnJuntado = findViewById(R.id.rBtnJuntado);
        rBtnCasado = findViewById(R.id.rBtnCasado);
        cBoxtrabaja = findViewById(R.id.checkTrabaja);
    }

    public void onClick(View v) {
        inSecun.putExtra("NOMBRE", eTxtNom.getText().toString());
        int iEdad = Integer.parseInt(eTxtEdad.getText().toString());
        inSecun.putExtra("EDAD", iEdad);
        double dSal = Double.parseDouble(eTxtSal.getText().toString());
        inSecun.putExtra("SALARIO", dSal);
        inSecun.putExtra("ES_CHAMBEADOR", cBoxtrabaja.isChecked());
        if (rBtnJuntado.isChecked()) {
            inSecun.putExtra("ESTADO", "Juntado");
        } else if (rBtnDivorciado.isChecked()) {
            inSecun.putExtra("ESTADO", "Divorciado");
        } else if (rBtnSoltero.isChecked()) {
            inSecun.putExtra("ESTADO", "Soltero");
        } else if (rBtnCasado.isChecked()) {
            inSecun.putExtra("ESTADO", "Casado");
        }
        startActivity(inSecun);
    }
}
