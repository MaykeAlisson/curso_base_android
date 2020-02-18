package br.com.redesenhe.listview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private ListView listaLocais;
    private String[] itens = {
            "Caldas Novas", "Uberlandia", "Alagoas",
            "Maceio", "Estados Unidos", "Maranhao",
            "Piaui", "Londres", "Canada", "Caldas Novas", "Uberlandia", "Alagoas",
            "Maceio", "Estados Unidos", "Maranhao",
            "Piaui", "Londres","Caldas Novas", "Uberlandia", "Alagoas",
            "Maceio", "Estados Unidos", "Maranhao",
            "Piaui", "Londres"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listaLocais = findViewById(R.id.listLocais);

        // Criar adapdator para lista
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                android.R.id.text1,
                itens
        );

        // adiciona adaptador a lista
        listaLocais.setAdapter(arrayAdapter);

        // on click
        listaLocais.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final String valorSelecionado = listaLocais.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), valorSelecionado, Toast.LENGTH_LONG).show();
            }
        });

    }
}
