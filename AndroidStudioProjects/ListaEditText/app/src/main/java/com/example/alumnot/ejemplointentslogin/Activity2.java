package com.example.alumnot.ejemplointentslogin;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Activity2 extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        //Cogemos el paquete del intent.
        Bundle bundle=this.getIntent().getExtras();
        //Creamos las variables donde introduciremos los datos.
        ListView listView=(ListView) findViewById(R.id.listView);
        ArrayList<String> al=new ArrayList<>();

        String usuario=bundle.getString("usr");
        String contraseña=bundle.getString("pass");
        //Escribiremos el texto en cada textView del paquete.
        al.add(usuario);
        //al.add(contraseña);

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(getApplicationContext(), R.layout.row_item,al);

        listView.setAdapter(arrayAdapter);
    }
}
