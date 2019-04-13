package com.luist.eva2_11_onactivityresult;

import android.content.Intent;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtVwResumen;
    Intent inCaptura;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtVwResumen = findViewById(R.id.txtVwRes);
        inCaptura = new Intent(this, Captura.class);

    }

    public void Captura(View v) {
        startActivityForResult(inCaptura, 2000);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 2000) {
            if (resultCode == RESULT_OK) {
                txtVwResumen.setText(
                        "Nombre: " + data.getStringExtra("NOMBRE") +
                                "APELLIDO: " + data.getStringExtra("APELLIDO") +
                                "MATERIAS: " + data.getStringExtra("MATERIAS")
                );
            }
        }
    }
}
