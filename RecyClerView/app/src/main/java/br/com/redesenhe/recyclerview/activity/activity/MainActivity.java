package br.com.redesenhe.recyclerview.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.redesenhe.recyclerview.R;
import br.com.redesenhe.recyclerview.activity.RecyclerItemClickListener;
import br.com.redesenhe.recyclerview.activity.adapter.Adapter;
import br.com.redesenhe.recyclerview.activity.model.Filme;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<Filme> filmeList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);


        // Lista de filmes
        criarFilmes();


        // config adapter
        Adapter adapter = new Adapter( filmeList );

        // config recyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapter);

        // evenyo click
        recyclerView.addOnItemTouchListener(
            new RecyclerItemClickListener(
                    getApplicationContext(),
                    recyclerView,
                    new RecyclerItemClickListener.OnItemClickListener() {
                        @Override
                        public void onItemClick(View view, int position) {
                            final String message = String.format("Filme %s selecionado!",
                                    filmeList.get(position).getTitulo()
                            );

                            Toast.makeText(
                                    getApplicationContext(),
                                    message,
                                    Toast.LENGTH_SHORT
                            ).show();
                        }

                        @Override
                        public void onLongItemClick(View view, int position) {
                            final String message = String.format("Filme %s click long !",
                                    filmeList.get(position).getTitulo()
                            );

                            Toast.makeText(
                                    getApplicationContext(),
                                    message,
                                    Toast.LENGTH_SHORT
                            ).show();
                        }

                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        }
                    }
            )
        );

    }

    public void criarFilmes(){

        Filme filme = new Filme("Matrix", "Ação", "2007");
        filmeList.add(filme);

        filme = new Filme("Homem de Ferro", "Ação", "2012");
        filmeList.add(filme);

        filme = new Filme("Liga da Justiça", "Ficção", "2017");
        filmeList.add(filme);

        filme = new Filme("Frozen", "Desenho Animado", "2013");
        filmeList.add(filme);

        filme = new Filme("Homem de Ferro 2", "Ação", "2014");
        filmeList.add(filme);

        filme = new Filme("Matrix 2 ", "Ação", "2008");
        filmeList.add(filme);

        filme = new Filme("Frozen 2", "Desenho Animado", "2020");
        filmeList.add(filme);

        filme = new Filme("Homem de Ferro 3", "Ação", "2016");
        filmeList.add(filme);

        filme = new Filme("Matrix 4 ", "Ação", "2021");
        filmeList.add(filme);

    }
}
