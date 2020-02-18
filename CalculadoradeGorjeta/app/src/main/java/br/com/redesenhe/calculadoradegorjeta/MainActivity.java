package br.com.redesenhe.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText iptValor;
    private TextView txtPorcentagem;
    private SeekBar barraPorcentagem;
    private TextView gorjeta;
    private TextView total;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iptValor = findViewById(R.id.iptValor);
        txtPorcentagem = findViewById(R.id.txtPorcentage);
        barraPorcentagem = findViewById(R.id.seekBarGorjeta);
        gorjeta = findViewById(R.id.txtGorjeta);
        total = findViewById(R.id.txtTotal);

        barraPorcentagem.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = progress;
                txtPorcentagem.setText( Math.round(porcentagem) + "%");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void calcular(){

        final String valorRecuperado = iptValor.getText().toString();

        if (valorRecuperado.isEmpty()){
            Toast.makeText(
                    getApplicationContext(),
                    "Digite um Valor Primeiro!",
                    Toast.LENGTH_LONG
            ).show();
        }

        double valorDigitado = Double.parseDouble(valorRecuperado);

        // calculo gorgeta
        double vlrGorgeta = valorDigitado * (porcentagem/100);
        final String vlrGorgetaFormatada = new DecimalFormat("#,##").format(vlrGorgeta);
        double vlrTotal = valorDigitado + vlrGorgeta;

        gorjeta.setText("R$ " + vlrGorgetaFormatada);
        total.setText("R$ " + vlrTotal);

    }
}
