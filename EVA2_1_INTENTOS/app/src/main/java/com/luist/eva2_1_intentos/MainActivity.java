package com.luist.eva2_1_intentos;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.SearchEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText eTxtNum;
    Button btnMarcar;
    Intent inMarcar;
    EditText eTxtBus;
    Button btnBuscar;
    Intent inBuscar;
    EditText eTxtNumMens;
    EditText eTxtContMens;
    Button btnMensaje;
    Intent inMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eTxtNum = findViewById(R.id.eTxtNum);
        btnMarcar = findViewById(R.id.btnMarcar);
        eTxtBus = findViewById(R.id.eTxtBus);
        btnBuscar = findViewById(R.id.btnBuscar);
        eTxtNumMens = findViewById(R.id.eTxtNumMens);
        eTxtContMens = findViewById(R.id.eTxtMen);
        btnMensaje = findViewById(R.id.btnMensaje);
    }

    public void onClick(View v) {
        //RECUPERAMOS EL NUM TELEFONICO
        String sTel = "tel:" + eTxtNum.getText().toString();
        //CREAMOS EL INTENTO PORQUE REQUERIMOS MARCAR
        inMarcar = new Intent(Intent.ACTION_CALL, Uri.parse(sTel));
        //INICIAR LA ACTIVIDAD
        //SIN RESULTAODS
        startActivity(inMarcar);
        //Con resultaods
        //startActivityForResult
    }

    public void onClickBuscar(View w) {
        String sBus = eTxtBus.getText().toString();
        //Generamos el intento
        inBuscar = new Intent(Intent.ACTION_WEB_SEARCH);
        inBuscar.putExtra(SearchManager.QUERY, sBus);
        startActivity(inBuscar);
    }

    public void onClickMensaje(View v) {
        String sTel = "smsto:" + eTxtNumMens.getText().toString();
        String sMen = eTxtContMens.getText().toString();
        //Generamos el intento
        inMensaje = new Intent(Intent.ACTION_SENDTO, Uri.parse(sTel));
        inMensaje.putExtra("sms_body", sMen);
        startActivity(inMensaje);
    }
}
