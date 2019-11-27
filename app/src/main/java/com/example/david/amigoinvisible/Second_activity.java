package com.example.david.amigoinvisible;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Second_activity extends AppCompatActivity {
    public TextView amigo;
    public TextView infocoste;
    public TextView infofecha;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_activity);
        Intent i = getIntent();

        amigo = (TextView) findViewById(R.id.amigo);
        infocoste = (TextView) findViewById(R.id.infocoste);
        infofecha = (TextView) findViewById(R.id.infofecha);

        amigo.setText(i.getStringExtra("amigo"));
        infocoste.setText("Recuerda máx " + i.getStringExtra("diner") + "€");
        infofecha.setText("El dia que se entrega es el " + i.getStringExtra("fecha"));


    }
}
