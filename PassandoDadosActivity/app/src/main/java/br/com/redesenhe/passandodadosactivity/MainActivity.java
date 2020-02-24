package br.com.redesenhe.passandodadosactivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btEnviarDados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btEnviarDados = findViewById(R.id.btnPassarDados);
        btEnviarDados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Intent = intenção(abrir camera, ligar wifi....)
                Intent intent = new Intent(getApplicationContext(), SegundaActivity.class);

                // Passar Dados
                intent.putExtra("nome","Mayke Alisson");
                intent.putExtra("idade", 28);

                startActivity(intent);
            }
        });
    }
}
