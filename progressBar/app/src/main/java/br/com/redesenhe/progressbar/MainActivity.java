package br.com.redesenhe.progressbar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {

    private ProgressBar loadHorizontal;
    private ProgressBar loadVertical;

    private int progresso = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadHorizontal = findViewById(R.id.progressBar);
        loadVertical = findViewById(R.id.progressBar2);

        loadVertical.setVisibility(View.GONE);
    }

    public void carregar(View view){
        this.progresso = this.progresso + 1;
        loadHorizontal.setProgress(this.progresso);

        // load circular
        loadVertical.setVisibility(View.VISIBLE);

        if (this.progresso == 10) loadVertical.setVisibility(View.GONE);
    }
}
