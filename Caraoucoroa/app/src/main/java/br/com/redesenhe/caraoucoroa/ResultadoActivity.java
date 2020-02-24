package br.com.redesenhe.caraoucoroa;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class ResultadoActivity extends AppCompatActivity {


    private ImageView imgMoeda;
    private Button btnVoltar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        imgMoeda = findViewById(R.id.imgMoeda);
        btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();// finaliza a activity
            }
        });

        caraOuCoroa();
    }

    public void caraOuCoroa(){

        int numero =  new Random().nextInt(2);

        if(numero == 0){
            imgMoeda.setImageResource(R.drawable.moeda_coroa);
        }else{
            imgMoeda.setImageResource(R.drawable.moeda_cara);
        }

    }
}
