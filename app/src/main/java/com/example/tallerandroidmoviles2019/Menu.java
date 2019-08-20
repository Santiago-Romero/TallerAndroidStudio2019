package com.example.tallerandroidmoviles2019;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Menu extends AppCompatActivity {
    TextView usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Bundle delivery = getIntent().getExtras();
        String usert = delivery.getString("username");
        usuario = findViewById(R.id.vista_user);
        usuario.setText("Iniciado sesión como: "+usert);
    }

    public  void consulta(int n) {
        String tipo;
        if(n==1){
            tipo="Semilleros";
        }else if(n==2){
            tipo="Trabajos";
        }else{
            tipo="Actividades";
        }
        Bundle data = new Bundle();
        Intent ir = new Intent(this, Consulta.class);
        data.putString("tipo",tipo);
        ir.addFlags(ir.FLAG_ACTIVITY_CLEAR_TOP | ir.FLAG_ACTIVITY_CLEAR_TASK);
        ir.putExtras(data);
        startActivity(ir);
    }
    public  void goSemilleros(View v){
        this.consulta(1);
    }
    public  void goTrabajos(View v){
        this.consulta(2);
    }
    public  void goActividades(View v){
        this.consulta(3);
    }
}
