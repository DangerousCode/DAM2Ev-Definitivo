package com.example.alumnot.ejemplointentslogin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
        //Cogemos el paquete del intent.
        Bundle bundle=this.getIntent().getExtras();
        //Creamos las variables donde introduciremos los datos.
        TextView usuario=(TextView) findViewById(R.id.usuarioA2);
        TextView contraseña=(TextView) findViewById(R.id.contraseñaA2);
        //Escribiremos el texto en cada textView del paquete.
        usuario.setText(bundle.getString("usr"));
        contraseña.setText(bundle.getString("pass"));
    }
}
