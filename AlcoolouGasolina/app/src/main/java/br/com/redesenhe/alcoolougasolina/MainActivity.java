package br.com.redesenhe.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import static java.lang.Double.parseDouble;

public class MainActivity extends AppCompatActivity {


    private TextInputEditText campoAlcool;
    private TextInputEditText campoGasolina;
    private TextView resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoAlcool = findViewById(R.id.inptVlrAlcool);
        campoGasolina = findViewById(R.id.inptVlrGasolina);
        resultado = findViewById(R.id.txtresultado);
    }

    public void verificaOpcao(View view){

        final String precoAlcool = campoAlcool.getText().toString();
        final String precoGasolina = campoGasolina.getText().toString();

        // Valida campos
        final boolean validaCampo = ehVazio(precoAlcool, precoGasolina);

        if (!validaCampo){
            // Converter campos
            final Double valorAlcool = parseDouble(precoAlcool);
            final Double valorGasolina = parseDouble(precoGasolina);

            // Formula
            final double vlrResultado = valorAlcool / valorGasolina;

            if (vlrResultado >= 0.7) resultado.setText("Melhor utilizar Gasolina");

            resultado.setText("Melhor utilizar Alcool");


        }else{
            resultado.setText("Preencha os preços primeiro!");
        }

    }

    public boolean ehVazio(String alcool, String gasolina){
        return alcool.isEmpty() || gasolina.isEmpty();
    }
}
