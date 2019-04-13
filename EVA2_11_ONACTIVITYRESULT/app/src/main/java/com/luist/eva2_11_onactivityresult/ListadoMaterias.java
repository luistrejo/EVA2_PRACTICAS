package com.luist.eva2_11_onactivityresult;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListadoMaterias extends AppCompatActivity implements ListView.OnItemClickListener {

    ListView lstMaterias;
    String[] asMaterias = {
            "Fundamentos de Programacion",
            "Programacion orientada a objetos",
            "Estructura de datos",
            "Topicos avanzados de Programacion",
            "Graficacion",
            "Programacion Web",
            "Apps 1",
            "Apps 2",
            "Apps 3",
            "Apps Hibridas"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado_materias);
        lstMaterias = findViewById(R.id.listMaterias);
        lstMaterias.setAdapter(new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                asMaterias
        ));
        lstMaterias.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent inDatos = new Intent();
        inDatos.putExtra("MATERIA",asMaterias[position]+"\n");
        setResult(Activity.RESULT_OK,inDatos);
        finish();
    }
}
