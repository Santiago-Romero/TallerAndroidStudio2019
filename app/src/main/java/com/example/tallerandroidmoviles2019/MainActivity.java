package com.example.tallerandroidmoviles2019;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText usert,passt;
    TextView usuariosregis;
    public ArrayList<String> usuarios = new ArrayList<String>();
    public ArrayList<String> contras = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        passt = findViewById(R.id.password);
        usert = findViewById(R.id.user);
        usuariosregis=findViewById(R.id.usuariosregis);

        AlertDialog.Builder Beta = new AlertDialog.Builder(this);
        Beta.setTitle("Recuerde");
        Beta.setMessage("La aplicion se  encuentra en etapa beta "+"¿Desea utilizarla?");
        Beta.setCancelable(false);
        Beta.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface Beta, int id) {
                Aceptar();
            }
        });
        Beta.setNegativeButton("Rechazar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface Beta, int id) {
                Rechazar();
            }
        });
        Beta.show();
    }
    public void Aceptar(){
        Toast.makeText(this,"enhorabuena, Gracias por usar la aplicación",Toast.LENGTH_LONG).show();
    }
    public void Rechazar(){
        finish();
    }

    public  void goMenu(View v){
        this.navegar();
    }
    public  void navegar(){
        String user = usert.getText().toString();
        String pass = passt.getText().toString();
        Boolean encontrado = false;
        if(pass.length() > 0 && user.length() > 0){
            // ACAá IRIA LA VALIDACION BUSCANDO EN EL ARRAY PERRITO
            for (int i=0;i<usuarios.size();i++){
                if(user.equals(usuarios.get(i)) && pass.equals(contras.get(i))){
                    encontrado=true;
                    Bundle data = new Bundle();
                    data.putString("username",user);
                    Intent ir = new Intent(this, Menu.class);
                    ir.addFlags(ir.FLAG_ACTIVITY_CLEAR_TOP | ir.FLAG_ACTIVITY_CLEAR_TASK);
                    ir.putExtras(data);
                    startActivity(ir);
                }
            }
            if(encontrado==false){
                Toast.makeText(this,"Datos erroneos",Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this,"Debe ingresar nombre de usuario y contraseña",Toast.LENGTH_LONG).show();
        }
    }

    public  void registrar(View v){
        this.regist();
    }
    public  void regist(){
        String user2 = usert.getText().toString();
        String pass2 = passt.getText().toString();
        if(pass2.length() > 0 && user2.length() > 0){
            Toast.makeText(this,"Usuario "+user2+ " agregado",Toast.LENGTH_LONG).show();
            usuariosregis.setText(usuariosregis.getText()+"\n"+user2);
            usuarios.add(user2);
            contras.add(pass2);
        } else {
            Toast.makeText(this,"Debe ingresar nombre de usuario y contraseña",Toast.LENGTH_LONG).show();
        }
    }
}
