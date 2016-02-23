package com.example.alumnot.practicasql;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by AlumnoT on 18/02/2016.
 */
public class Activity2 extends Activity {
    //Aqui da problemas y creo que es por no pasar la base de datos en el intent
    UsuariosSQLiteHelper bd= new UsuariosSQLiteHelper(this, "DBUsuarios",null,1);
    SQLiteDatabase db = bd.getWritableDatabase();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        ArrayList<DatosUser> datos=new ArrayList<>();

        Cursor curows= db.rawQuery("SELECT count(*) FROM usuarios", null);
        int numrows=curows.getInt(0);

        for(int i=0;i<numrows;i++){
            Cursor curselect= db.rawQuery("SELECT usuario, pass FROM usuarios WHERE codigo="+i, null);
            datos.add(new DatosUser(curselect.getString(0),curselect.getString(1)));
        }

        AdaptadorLista adaptadorLista=new AdaptadorLista(this.getApplicationContext(),datos);

        ListView listView=(ListView) findViewById(R.id.listView);
        listView.setAdapter(adaptadorLista);
    }
}
