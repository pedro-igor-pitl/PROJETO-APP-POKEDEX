package com.example.projeto_pokedex_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class GenerationsActivity extends AppCompatActivity {

    private Button btnGen1;
    private Button btnGen2;
    private Button btnGen3;
    private Button btnGen4;
    private Button btnGen5;
    private Button btnGen6;
    private Button btnGen7;
    private Button btnGen8;
    private Button btnGen9;
    private View  iv_logo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gen_pokemon);

        // Inicializando os botões
        btnGen1 = findViewById(R.id.btnGen1);
        btnGen2 = findViewById(R.id.btnGen2);
        btnGen3 = findViewById(R.id.btnGen3);
        btnGen4 = findViewById(R.id.btnGen4);
        btnGen5 = findViewById(R.id.btnGen5);
        btnGen6 = findViewById(R.id.btnGen6);
        btnGen7 = findViewById(R.id.btnGen7);
        btnGen8 = findViewById(R.id.btnGen8);
        btnGen9 = findViewById(R.id.btnGen9);
        iv_logo = findViewById(R.id.iv_logo);


        // Voltar tela
        iv_logo.setOnClickListener(v -> {
            // Inicia a GenerationActivity quando o botão GENERATIONS é clicado
            Intent intent = new Intent(GenerationsActivity.this, MainActivity.class);
            startActivity(intent);
        });

        // Definindo listeners para os botões
        btnGen1.setOnClickListener(v -> navigateToPokemonList(1));
        btnGen2.setOnClickListener(v -> navigateToPokemonList(2));
        btnGen3.setOnClickListener(v -> navigateToPokemonList(3));
        btnGen4.setOnClickListener(v -> navigateToPokemonList(4));
        btnGen5.setOnClickListener(v -> navigateToPokemonList(5));
        btnGen6.setOnClickListener(v -> navigateToPokemonList(6));
        btnGen7.setOnClickListener(v -> navigateToPokemonList(7));
        btnGen8.setOnClickListener(v -> navigateToPokemonList(8));
        btnGen9.setOnClickListener(v -> navigateToPokemonList(9));
    }

    private void navigateToPokemonList(int generation) {
        Intent intent = new Intent(GenerationsActivity.this, PokemonListActivity.class);
        intent.putExtra("generation", generation);
        startActivity(intent);
    }
}
