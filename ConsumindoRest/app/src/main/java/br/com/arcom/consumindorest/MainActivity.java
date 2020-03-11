package br.com.arcom.consumindorest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import br.com.arcom.consumindorest.api.CepService;
import br.com.arcom.consumindorest.model.Cep;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    // API
    final String request = "https://api.hgbrasil.com/finance"; // key = 1c1cb8a6
    final String requestCep = "https://viacep.com.br/ws/";

    private Retrofit retrofit;

    private Button mBtnRecuperarDados;
    private TextView mTextDadosRecuperados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Config retrofit URL/CONVERSOR
        retrofit = new Retrofit.Builder()
                .baseUrl(requestCep)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Button
        mBtnRecuperarDados = findViewById(R.id.btnRecuperarDados);
        mBtnRecuperarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                requestValorMoedas();
            }
        });

        // Resultado Request
        mTextDadosRecuperados = findViewById(R.id.textDadosRecuperado);
    }

    private void requestValorMoedas() {

        CepService cepService = retrofit.create(CepService.class);
        Call<Cep> call = cepService.recuperarCep();

        // Tarefa Asinc new thread
        call.enqueue(new Callback<Cep>() {
            @Override
            public void onResponse(Call<Cep> call, Response<Cep> response) {
                if (response.isSuccessful()) {
                    Cep cep = response.body();
                    mTextDadosRecuperados.setText(cep.getLogradouro());
                }
            }

            @Override
            public void onFailure(Call<Cep> call, Throwable t) {

            }
        });

    }

}
