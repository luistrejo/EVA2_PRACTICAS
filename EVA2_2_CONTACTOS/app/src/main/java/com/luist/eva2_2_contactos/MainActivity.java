package com.luist.eva2_2_contactos;

import android.content.Intent;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Intent inContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickListaContactos(View view) {
        String sUri = "content://contacts/people/";
        inContactos = new Intent(Intent.ACTION_VIEW, Uri.parse(sUri));
        startActivity(inContactos);
    }

    public void onClickDetalleContacto(View view) {
        String sUri = ContactsContract.Contacts.CONTENT_URI + "/33";
        inContactos = new Intent(Intent.ACTION_EDIT, Uri.parse(sUri));
        startActivity(inContactos);
    }
}
