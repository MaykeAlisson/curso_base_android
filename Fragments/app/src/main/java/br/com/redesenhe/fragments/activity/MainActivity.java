package br.com.redesenhe.fragments.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import br.com.redesenhe.fragments.R;
import br.com.redesenhe.fragments.fragment.ContatosFragment;
import br.com.redesenhe.fragments.fragment.ConversasFragment;

public class MainActivity extends AppCompatActivity {

    private Button btnConversas;
    private Button btnContatos;

    private ConversasFragment conversasFragment;
    private ContatosFragment contatosFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Remover sombra da Activity
        getSupportActionBar().setElevation(0);

        conversasFragment = new ConversasFragment();



        // Configura Obj para o fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameConteudo, conversasFragment);
        transaction.commit();

        btnContatos = findViewById(R.id.btnContato);
        btnContatos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                contatosFragment = new ContatosFragment();

                // Configura Obj para o fragment
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, contatosFragment);
                transaction.commit();

            }
        });

        btnConversas = findViewById(R.id.btnConvercas);
        btnConversas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                conversasFragment = new ConversasFragment();

                // Configura Obj para o fragment
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.frameConteudo, conversasFragment);
                transaction.commit();

            }
        });
    }
}
