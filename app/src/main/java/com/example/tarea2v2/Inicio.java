package com.example.tarea2v2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Inicio extends AppCompatActivity implements View.OnClickListener {
Button btnEditar,btnEliminar,btnMostrar,btnSalir;
TextView nombre;
int id=0;
Usuario u;
daoUsuario dao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        btnEditar=(Button)findViewById(R.id.btn_editar_inicio);
        btnEliminar=(Button)findViewById(R.id.btn_eliminar_inicio);
        btnMostrar=(Button)findViewById(R.id.btn_mostrar_inicio);
        btnSalir=(Button)findViewById(R.id.btn_cancelar_inicio);

        nombre = (TextView)findViewById(R.id.nombre_inicio);

        btnEditar.setOnClickListener(this);
        btnEliminar.setOnClickListener(this);
        btnMostrar.setOnClickListener(this);
        btnSalir.setOnClickListener(this);

        Bundle b=getIntent().getExtras();
        id=b.getInt("Id");
        dao= new daoUsuario(this);
        u=dao.getUsuarioById(id);
        nombre.setText(u.getNombre()+""+u.getApellidos());
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_editar_inicio:
                Intent a = new Intent(Inicio.this,Editar.class);
                startActivity(a);
                break;
            case R.id.btn_eliminar_inicio:
                break;
            case R.id.btn_mostrar_inicio:
                Intent i3= new Intent(Inicio.this,Mostrar.class);
                startActivity(i3);
                break;
            case R.id.btn_cancelar_inicio:
                Intent i2=new Intent(Inicio.this,MainActivity.class);
                startActivity(i2);
                finish();
                break;
        }
    }
}