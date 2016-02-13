package com.example.alvaro.listaintents;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.util.ArrayList;

/**
 * Created by Alvaro on 05/02/2016.
 */
public class ListActivity extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista);

        Intent bundle=this.getIntent();
        String usr=bundle.getStringExtra("usr");
        String pass=bundle.getStringExtra("pass");

        ArrayList<String> al=new ArrayList<>();
        al.add(usr);
        al.add(pass);

        ListView listView=(ListView) findViewById(R.id.listView);

        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(this,R.layout.textfield,al);
        listView.setAdapter(arrayAdapter);
    }
}
