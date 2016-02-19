package com.example.alumnot.viewholder;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by AlumnoT on 18/02/2016.
 */
public class Activity2 extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        //Cogemos el paquete del intent.
        Bundle bundle=this.getIntent().getExtras();

        ArrayList<DatosUser> datos=new ArrayList<>();
        datos.add(new DatosUser(bundle.getString("usr").toString(),bundle.getString("pass").toString()));

        AdaptadorLista adaptadorLista=new AdaptadorLista(this.getApplicationContext(),datos);

        ListView listView=(ListView) findViewById(R.id.listView);
        listView.setAdapter(adaptadorLista);
    }
}
