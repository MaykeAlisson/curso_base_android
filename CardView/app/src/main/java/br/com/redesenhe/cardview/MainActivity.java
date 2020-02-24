package br.com.redesenhe.cardview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import br.com.redesenhe.cardview.adapter.PostagemAdapter;
import br.com.redesenhe.cardview.model.Postagem;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerPostagem;
    private List<Postagem> postagens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerPostagem = findViewById(R.id.recyclerPostagem);

        // Definir layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerPostagem.setLayoutManager(layoutManager);


        //Definir Adapter
        prepararPostagem();
        PostagemAdapter adapter = new PostagemAdapter(postagens);
        recyclerPostagem.setAdapter(adapter);
    }

    public void prepararPostagem(){

        Postagem postagem ;
        postagem =  new Postagem();
        postagem.setNome("Mayke Alisson");
        postagem.setPostagem("Amor");
        postagem.setImagem(R.drawable.imagem2);
        postagens.add(postagem);

        postagem =  new Postagem();
        postagem.setNome("Isabela Regina");
        postagem.setPostagem("Vida Boa");
        postagem.setImagem(R.drawable.imagem3);
        postagens.add(postagem);

        postagem =  new Postagem();
        postagem.setNome("Dayanne");
        postagem.setPostagem("Eita nos");
        postagem.setImagem(R.drawable.imagem4);
        postagens.add(postagem);

        postagem =  new Postagem();
        postagem.setNome("Laura");
        postagem.setPostagem("oi miga");
        postagem.setImagem(R.drawable.imagem1);
        postagens.add(postagem);


    }
}
