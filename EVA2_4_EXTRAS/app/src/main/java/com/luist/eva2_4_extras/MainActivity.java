package com.luist.eva2_4_extras;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements ListView.OnItemClickListener {
    final String[] asMaterias = {
            "Fundamentos de Programacion",
            "Programacion orientada a objetos",
            "Estructura de datos",
            "Topicos avanzados de programacion",
            "Graficacion",
            "Programacion Web",
            "Aplicaciones 1",
            "Aplicaciones 2",
            "Aplicaciones 3",
            "Aplicaciones Hibridas",
            "Topicos Selectos"
    };

    final String[] asProfesores = {
            "Royce Rodriguez",
            "Hector Fuentes",
            "Oscar",
            "Ruben Hernandez",
            "Jesus Espadas",
            "Leonardo Nevarez",
            "Ruben Hernandez",
            "Samuel Hernandez",
            "alguien +",
            "alguien ++",
            "alguien +++"
    };

    ListView lstMaterias;
    Intent inSecundaria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lstMaterias = findViewById(R.id.listItems);
        lstMaterias.setAdapter(new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, asMaterias));
        lstMaterias.setOnItemClickListener(this);
        inSecundaria = new Intent(this, Secundaria.class);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //ENVIAR A SECUNDARIA EL MAESTRO QUE DA LA CLASE
        inSecundaria.putExtra("MAESTRO", asProfesores[position]);
        startActivity(inSecundaria);
    }
}
