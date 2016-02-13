package com.example.alvaro.listaintents;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends Activity {

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onLogin(View v) {
        EditText usuario = (EditText) findViewById(R.id.usr);
        EditText contra = (EditText) findViewById(R.id.pass);

        Intent i = new Intent(MainActivity.this,ListActivity.class);

        i.putExtra("usr", usuario.getText().toString());
        i.putExtra("pass", contra.getText().toString());

        startActivity(i);
    }
}
