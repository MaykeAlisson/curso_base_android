package br.com.redesenhe.componentesbasicos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {


    private EditText campoNome;
    private TextInputEditText campoEmail;
    private TextView resultado;

    private CheckBox checkVerde;
    private CheckBox checkBranco;
    private CheckBox checkVermelho;

    private RadioButton rbM;
    private RadioButton rbF;
    private RadioGroup rdG;

    private Switch swt;
    private ToggleButton tog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        campoNome = findViewById(R.id.inptNome);
        campoEmail = findViewById(R.id.editEmail);
        resultado = findViewById(R.id.textResultado);

        checkVerde = findViewById(R.id.checkVerde);
        checkBranco = findViewById(R.id.checkBranco);
        checkVermelho = findViewById(R.id.checkVermelho);

        rbM = findViewById(R.id.radioButtonM);
        rbF = findViewById(R.id.radioButtonF);
        rdG = findViewById(R.id.radioGroup);

        swt = findViewById(R.id.swSenha);
        tog = findViewById(R.id.togSenha);

        radioButton();

    }

    public  void selecionado(){

//        tog.isChecked();
        
        if (swt.isChecked()){
            resultado.setText("Switch Ligado");
        }else{
            resultado.setText("Switch Desligado");
        }
    }


    public void enviar(View view) {


        /*
        final String nome = campoNome.getText().toString();
        final String email = campoEmail.getText().toString();
        resultado.setText(String.format("Nome %s, email %s ", nome, email));
         */

        //        checkBox();

//        radioButton();

    }

    public void checkBox(){
        String texto = "";

        if (checkVerde.isChecked()) texto = texto + "Verde selecionado - ";
        if (checkBranco.isChecked()) texto = texto + "Branco selecionado - ";
        if (checkVermelho.isChecked()) texto = texto + "Vermelho selecionado ";

        resultado.setText(texto);

    }

    public void radioButton(){

        rdG.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (checkedId == R.id.radioButtonF) {
                    resultado.setText("Femenino");
                }else{
                    resultado.setText("Masculino");
                }
            }
        });

        /*
        if (rbM.isChecked()){
            resultado.setText("Femenino");
        }else{
            resultado.setText("Masculino");
        }
         */

    }

    public void limparCampos() {
        campoNome.setText("");
        campoEmail.setText("");
    }
}
