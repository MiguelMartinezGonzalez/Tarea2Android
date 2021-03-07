package com.example.tarea2v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
EditText user,pass;
Button btnEntrar, btnRegistrar;
daoUsuario dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user=(EditText)findViewById(R.id.User);
        pass =(EditText)findViewById(R.id.Password);
        btnEntrar =(Button)findViewById(R.id.btn_iniciar_login);
        btnRegistrar=(Button)findViewById(R.id.btn_registro_login);

        btnEntrar.setOnClickListener(this);
        btnRegistrar.setOnClickListener(this);
        dao=new daoUsuario(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_iniciar_login:
                String u=user.getText().toString();
                String p=pass.getText().toString();
                if(u.equals("")&&p.equals("")){
                    Toast.makeText(this,"Error, campos vacios",Toast.LENGTH_LONG).show();
                }else if(dao.login(u,p)==1){
                    Usuario ux = dao.getUsuario(u,p);
                    Toast.makeText(this,"Datos correctos",Toast.LENGTH_LONG).show();
                    Intent i2 = new Intent(MainActivity.this,Inicio.class);
                    i2.putExtra("Id",ux.getId());
                    startActivity(i2);
                    finish();
                }else {
                    Toast.makeText(this,"Usuario y/o password incorrectos",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btn_registro_login:
                Intent i = new Intent(MainActivity.this,Registar.class);
                startActivity(i);
                break;
        }
    }


}