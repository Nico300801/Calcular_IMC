package com.example.calcular_imc;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Menu;
import android.widget.NumberPicker;

public class MainActivity extends AppCompatActivity {

    TextView Altura;
    TextView Peso;
    TextView IMC;
    EditText et_altura;
    EditText et_peso;
    Button calcular;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_altura = (EditText) findViewById(R.id.ET_altura);
        et_peso = (EditText) findViewById(R.id.ET_peso);
        Altura = (TextView) findViewById(R.id.Altura);
        Peso = (TextView) findViewById(R.id.Peso);
        IMC = (TextView) findViewById(R.id.IMC);
        calcular = (Button) findViewById((R.id.Boton_calcular));

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calcular_IMC();
            }
        });
    }

    private void Calcular_IMC(){
        String et_alturaValorTexto=et_altura.getText().toString();
        String et_pesoValorTexto=et_peso.getText().toString();

        if(et_alturaValorTexto != null && !"".equals(et_alturaValorTexto) && et_pesoValorTexto != null && !"".equals(et_pesoValorTexto)){
            float valor_altura = Float.parseFloat(et_alturaValorTexto) / 100;
            float valor_peso = Float.parseFloat(et_pesoValorTexto);
            float imc_valor = valor_peso / (valor_altura * valor_altura);

            mostrarIMC(imc_valor);
        }

        /*int et_alturaValor = Integer.parseInt(et_alturaValorTexto);
        int et_pesoValor = Integer.parseInt(et_pesoValorTexto);

        int CalculoIMC = et_pesoValor / (et_alturaValor * et_alturaValor);
        String Resultado_IMC =String.valueOf(CalculoIMC);
        IMC.setText("Su IMC es" + Resultado_IMC);*/

    }

    private void mostrarIMC(float imc_valor){
        String IMC_valor = "";
        if(Float.compare(imc_valor, 15f) <= 0){
            IMC_valor = "Peso gravemente insuficiente";
        } else if(Float.compare(imc_valor, 15f) > 0 && Float.compare(imc_valor, 16f) <=0){
            IMC_valor = "Peso bastante insuficiente";
        } else if(Float.compare(imc_valor, 16f) > 0 && Float.compare(imc_valor, 18.5f) <=0){
            IMC_valor = "Peso insuficiente";
        } else if(Float.compare(imc_valor, 18.5f) > 0 && Float.compare(imc_valor, 16f) <=0){
            IMC_valor = "Peso normal";
        } else if(Float.compare(imc_valor, 25f) > 0 && Float.compare(imc_valor, 16f) <=0){
            IMC_valor = "Sobrepeso";
        } else if(Float.compare(imc_valor, 30f) > 0 && Float.compare(imc_valor, 16f) <=0){
            IMC_valor = "Obesidad tipo I";
        } else if(Float.compare(imc_valor, 35f) > 0 && Float.compare(imc_valor, 16f) <=0){
            IMC_valor = "Obesidad tipo II";
        } else if(Float.compare(imc_valor, 40f) > 0 && Float.compare(imc_valor, 16f) <=0){
            IMC_valor = "Obesidad tipo III(mórbida)";
        }
        IMC_valor = IMC + "\n" + IMC_valor;
        IMC.setText(IMC_valor);
    }
}