package com.example.alumnot.practicasql;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private int i=0;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UsuariosSQLiteHelper bd= new UsuariosSQLiteHelper(this, "DBUsuarios",null,1);
        db=bd.getWritableDatabase();
    }

    public void onClickAdd(View v){
        i++;
        EditText usertv=(EditText) findViewById(R.id.userin);
        EditText passtv=(EditText) findViewById(R.id.passin);

        String user=usertv.getText().toString();
        String pass=passtv.getText().toString();

        String updb="INSERT INTO usuarios VALUES("+i+", '"+user+"', '"+pass+"')";
        db.execSQL(updb);

        usertv.setText("");
        passtv.setText("");
    }

    public void onClickLogin(View v){
        Intent intent=new Intent(getApplicationContext(),Activity2.class);
        startActivity(intent);
    }
}
