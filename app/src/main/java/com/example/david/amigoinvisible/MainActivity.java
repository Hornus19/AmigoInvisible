package com.example.david.amigoinvisible;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.database.sqlite.SQLiteDatabase;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MainActivity extends AppCompatActivity{

    private TextView lblGotoRegister;
    private Button btnLogin;
    private EditText inputEmail;
    private EditText inputPassword;
    private TextView loginErrorMsg;
    private Statement st;
    private ResultSet rs;
    private Connection con;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inputEmail = (EditText) findViewById(R.id.user);
        inputPassword = (EditText) findViewById(R.id.txtPass);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        loginErrorMsg = (TextView) findViewById(R.id.login_error);



        btnLogin.setOnClickListener(
                new View.OnClickListener() {

                    public void onClick(View view) {
                        String user = inputEmail.getText().toString();
                        String password = inputPassword.getText().toString();

                        if (!user.equalsIgnoreCase("")) {
                            if (!password.equalsIgnoreCase("")) {
                                Acceso acceso= Acceso.getInstance(getApplicationContext());
                                acceso.open();

                                Cursor cursor =acceso.getAddress(user);
                                if (cursor != null) {
                                    cursor.isFirst();
                                    if (cursor.getString(cursor.getColumnIndex("pass")).equals(password)) {
                                        Cursor g = acceso.friend(cursor);
                                        String diner = g.getString(cursor.getColumnIndex("diner"));
                                        String amigo = g.getString(cursor.getColumnIndex("amigo"));
                                        String fecha = g.getString(cursor.getColumnIndex("fecha"));
                                        Toast.makeText(MainActivity.this, "Fue bien", Toast.LENGTH_LONG)
                                                .show();
                                        Intent i = new Intent(MainActivity.this, Second_activity.class);
                                        i.putExtra("friend", amigo);
                                        i.putExtra("diner", diner);
                                        i.putExtra("fecha", fecha);
                                        startActivity(i);
                                    } else {
                                        Toast.makeText(MainActivity.this, "Contraseña no valida", Toast.LENGTH_LONG)
                                                .show();
                                    }
                                } else {
                                    Toast.makeText(MainActivity.this, "Usuario no encontrado", Toast.LENGTH_LONG)
                                            .show();
                                }


                            } else {
                                Toast.makeText(MainActivity.this, "Contraseña vacía", Toast.LENGTH_LONG).show();
                            }
                        } else {
                            Toast.makeText(MainActivity.this, "Usuario vacio", Toast.LENGTH_LONG).show();
                        }
                    }
                });

        lblGotoRegister = (TextView) findViewById(R.id.link_to_register);
        lblGotoRegister.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i;
                        i = new Intent(MainActivity.this, Register_activity.class);
                        startActivity(i);
                    }
                });
    }
}
