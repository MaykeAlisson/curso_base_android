package br.com.redesenhe.alert;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirToast(View view){

        AlertDialog.Builder dialog = new AlertDialog.Builder(this);

        dialog.setTitle("Titulo da dialog");
        dialog.setMessage("Menssagem dialog");

        // nao sai ao clicar fora
        dialog.setCancelable(false);

        // icon
        dialog.setIcon(android.R.drawable.ic_btn_speak_now);


        dialog.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(
                        getApplicationContext(),
                        "Execulta ação Sim",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });
        dialog.setNegativeButton("Não", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(
                        getApplicationContext(),
                        "Execulta ação Nao",
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

        dialog.create();
        dialog.show();


        /*
        TextView textView = new TextView(getApplicationContext());
        textView.setBackgroundResource(R.color.colorAccent);
        textView.setText("Uai deu certo!!");

        ImageView imagem = new ImageView(getApplicationContext());
        imagem.setImageResource(android.R.drawable.star_big_off);

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
//        toast.setView(imagem);
        toast.setView(textView);
        toast.show();

         */

        /*
        Toast.makeText(
                getApplicationContext(),
                "Ação realizada com sucesso",
                Toast.LENGTH_LONG
        ).show();

         */
    }
}
