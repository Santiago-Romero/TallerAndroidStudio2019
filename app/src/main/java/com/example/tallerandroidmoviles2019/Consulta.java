package com.example.tallerandroidmoviles2019;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Consulta extends AppCompatActivity {
    TextView consult;
    String tipo;
    RadioButton buga;
    RadioButton tulua;
    RadioButton cali;
    TextView resultado;
    String bugas[]={
            "Nadita","No se","Otro"
    };
    String calis[]={
            "Avispa","EVA","Camaleon","Guia","Genesis"
    };
    String tuluas[]={
            "HiperIA","Ingeniux","Otrico"
    };
    String bugaa[]={
            "Procrastinar","Procrear","Provisionar"
    };
    String calia[]={
            "Ver pericoardilla","Observar pericoardilla","Fijarse en la pericoardilla"
    };
    String tuluaa[]={
            "Dormir","Beber","Culiar"
    };
    String bugat[]={
            "Barrendero de techos ","Acomodador de hormigas","Perro de dia"
    };
    String calit[]={
            "Buscador de perros","Dormidor de puentes","Sisas socio"
    };
    String tuluat[]={
            "Dormidor profesional","Catador de panes","Oledor de sancochos"
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);
        Bundle delivery = getIntent().getExtras();
        tipo = delivery.getString("tipo");
        consult=findViewById(R.id.consulta);
        resultado=findViewById(R.id.resultados);
        buga=findViewById(R.id.buga);
        tulua=findViewById(R.id.tulua);
        cali=findViewById(R.id.cali);
        consult.setText(consult.getText()+" "+tipo);
    }

    public void buscar(View v){
        resultado.setText("Resultados: ");
        String elBuga[];
        String elTulua[];
        String elCali[];
        String res="";

        if(tipo.equals("Semilleros")){
            elBuga=bugas;
            elTulua=tuluas;
            elCali=calis;
        }else if(tipo.equals("Trabajos")){
            elBuga=bugat;
            elTulua=tuluat;
            elCali=calit;
        }else{
            elBuga=bugaa;
            elTulua=tuluaa;
            elCali=calia;
        }
        if(buga.isChecked()){
            for(int i=0;i<elBuga.length;i++){
                res+=elBuga[i]+"\n";
            }
        }else if(tulua.isChecked()){
            for(int i=0;i<elTulua.length;i++){
                res+=elTulua[i]+"\n";
            }
        }else{
            for(int i=0;i<elCali.length;i++){
                res+=elCali[i]+"\n";
            }
        }
        resultado.setText("Resultados: \n"+res);
    }
}
