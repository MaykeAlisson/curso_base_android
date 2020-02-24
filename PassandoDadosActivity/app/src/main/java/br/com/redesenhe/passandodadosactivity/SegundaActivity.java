package br.com.redesenhe.passandodadosactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import static java.lang.String.valueOf;

public class SegundaActivity extends AppCompatActivity {

    // Atributos
    private TextView textNome;
    private TextView textIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);

        textNome = findViewById(R.id.textNome);
        textIdade = findViewById(R.id.texNumero);

        //Recuperando Dados
        Bundle dados = getIntent().getExtras();
        String nome = dados.getString("nome");
        int idade = dados.getInt("idade");

        textNome.setText(nome);
        textIdade.setText(valueOf(idade));

    }
}
