package com.example.david.amigoinvisible;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Register_activity extends AppCompatActivity {

    private Button registrar;
    private EditText RetxtPass,txtPass,name,user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_activity);
        Helper bdH=new Helper(this);
        final SQLiteDatabase db=bdH.getReadableDatabase();

        registrar=  (Button) findViewById(R.id.btnregister);
        RetxtPass= (EditText) findViewById(R.id.RetxtPass);
        txtPass= (EditText) findViewById(R.id.txtPass);
        name= (EditText) findViewById(R.id.name);
        user= (EditText) findViewById(R.id.user);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}
