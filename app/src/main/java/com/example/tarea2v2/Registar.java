package com.example.tarea2v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Registar extends AppCompatActivity implements View.OnClickListener {
EditText us, pas,nom,ap;
Button reg,can;
daoUsuario dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registar);

        dao=new daoUsuario(this);

        us=(EditText)findViewById(R.id.User_register);
        pas=(EditText)findViewById(R.id.Password_register);
        nom=(EditText)findViewById(R.id.Nombre_register);
        ap=(EditText)findViewById(R.id.Apellido_register);

        reg=(Button)findViewById(R.id.btn_registro_register);
        can=(Button) findViewById(R.id.btn_cancelar_register);

        reg.setOnClickListener(this);
        can.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_registro_register:
                Usuario u = new Usuario();
                u.setUsuario(us.getText().toString());
                u.setPassword(pas.getText().toString());
                u.setNombre(nom.getText().toString());
                u.setApellidos(ap.getText().toString());
                if(!u.isNull()){
                    Toast.makeText(this,"Error,campos vacios",Toast.LENGTH_LONG).show();
                }else if(dao.insertUsuario(u)){
                    Toast.makeText(this,"Registro Realizado",Toast.LENGTH_LONG).show();
                    Intent i2 = new Intent(Registar.this,MainActivity.class);
                    startActivity(i2);
                    finish();
                }else {
                    Toast.makeText(this,"Usuario ya registrado",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btn_cancelar_register:
                Intent i = new Intent(Registar.this,MainActivity.class);
                startActivity(i);
                finish();
                break;
        }
    }
}