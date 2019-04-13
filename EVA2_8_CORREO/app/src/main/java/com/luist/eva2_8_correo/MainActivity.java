package com.luist.eva2_8_correo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText etxtAsunto, eTxtMensaje, eTxtCorreo;
    private Intent inEnviarCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etxtAsunto = findViewById(R.id.eTxtAsunto);
        eTxtMensaje = findViewById(R.id.eTxtMensaje);
        eTxtCorreo = findViewById(R.id.eTxtCorreo);

    }

    public void enviarCorreo(View v) {
        inEnviarCorreo = new Intent(Intent.ACTION_SEND);

        inEnviarCorreo.setType("vnd.android.cursor.dir/email");
        inEnviarCorreo.putExtra(Intent.EXTRA_SUBJECT, etxtAsunto.getText().toString());
        inEnviarCorreo.putExtra(Intent.EXTRA_EMAIL, eTxtCorreo.getText().toString());
        inEnviarCorreo.putExtra(Intent.EXTRA_TEXT, eTxtMensaje.getText().toString());
        startActivity(Intent.createChooser(inEnviarCorreo, "Enviar correo"));
    }
}
