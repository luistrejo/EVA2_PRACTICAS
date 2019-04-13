package com.luist.eva2_11_onactivityresult;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Captura extends AppCompatActivity {
    Intent inLista;
    EditText etxtNombre, eTxtApellido;
    TextView txtMaterias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_captura);
        inLista = new Intent(this, ListadoMaterias.class);
        etxtNombre = findViewById(R.id.eTxtNombre);
        eTxtApellido = findViewById(R.id.eTxtApellido);
        txtMaterias = findViewById(R.id.txtVwMaterias);
    }

    public void LanzarLista(View v) {
        startActivityForResult(inLista, 1000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1000) {
            if (resultCode == Activity.RESULT_OK) {
                txtMaterias.append(data.getStringExtra("MATERIA"));
            }
        }
    }

    public void guardarDatos(View v) {
        Intent inDatos = new Intent();
        inDatos.putExtra("NOMBRE", etxtNombre.getText().toString());
        inDatos.putExtra("APELLIDO", eTxtApellido.getText().toString());
        inDatos.putExtra("MATERIAS", txtMaterias.getText().toString());
        setResult(Activity.RESULT_OK, inDatos);
        finish();
    }
}
