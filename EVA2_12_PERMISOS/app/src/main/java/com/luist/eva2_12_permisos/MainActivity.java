package com.luist.eva2_12_permisos;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.net.URI;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText edtTxtTel;
    Button btnLlamar;
    Intent inllamar;
    final int PERMISO_CALL_PHONE = 333;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtTxtTel = findViewById(R.id.eTxtNum);
        btnLlamar = findViewById(R.id.btnLlamar);
        btnLlamar.setOnClickListener(this);
        btnLlamar.setEnabled(false);
        //VERIFICAMOS SI TENEMOS PERMISOS
        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.CALL_PHONE)
                != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CALL_PHONE},
                    PERMISO_CALL_PHONE);
        } else {
            btnLlamar.setEnabled(true);
        }
    }


    @Override
    public void onClick(View v) {
        String sTel = "tel:" + edtTxtTel.getText().toString();
        inllamar = new Intent(Intent.ACTION_CALL, Uri.parse(sTel));
        startActivity(inllamar);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case PERMISO_CALL_PHONE:
                if (requestCode == PERMISO_CALL_PHONE) {
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(this, "YA TENGO PERMISO", Toast.LENGTH_LONG).show();
                        btnLlamar.setEnabled(true);
                    } else {
                        Toast.makeText(this, "NEL", Toast.LENGTH_LONG).show();
                    }
                }
                break;
            default:
        }
    }
}
