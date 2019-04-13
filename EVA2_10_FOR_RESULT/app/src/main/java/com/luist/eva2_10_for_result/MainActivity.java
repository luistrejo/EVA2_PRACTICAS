package com.luist.eva2_10_for_result;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.support.annotation.Nullable;
import android.support.v4.content.CursorLoader;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private static final int CONTACT = 333;
    private static final int IMAGEN = 666;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickContactos(View v) {
        Intent inContact = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
        startActivityForResult(inContact, CONTACT);
    }

    public void onClickImagen(View v) {
        Intent inContact = new Intent(Intent.ACTION_PICK, Uri.parse("content://media/external/images/media"));
        startActivityForResult(inContact, IMAGEN);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case CONTACT:
                Uri contactsData = Uri.parse(data.getDataString());
                CursorLoader loader = new CursorLoader(this, contactsData, null, null, null, null);
                Cursor c = loader.loadInBackground();
                String number;
                if (c.moveToFirst()) {
                    number = c.getString(c.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
                    Intent iCall = new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + number));
                    startActivity(iCall);
                }
                Log.d("CONTACTOS", data.getDataString());

                break;
            case IMAGEN:
                Intent iImg = new Intent(Intent.ACTION_VIEW, Uri.parse(data.getDataString()));
                startActivity(iImg);
                break;
        }
    }
}
