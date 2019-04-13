package com.luist.eva2_6_bundles;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Intent inSecun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inSecun = new Intent(this, Secundaria.class);
    }

    public void onClick(View v) {
        Bundle bDatos = new Bundle();
        bDatos.putString("NOMBRE", "Luis Trejo");
        bDatos.putDouble("ESTATURA", 1.85);
        inSecun.putExtras(bDatos);
        startActivity(inSecun);
    }
}
