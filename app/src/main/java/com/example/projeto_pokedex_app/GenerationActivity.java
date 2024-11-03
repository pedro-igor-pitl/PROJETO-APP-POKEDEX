package com.example.projeto_pokedex_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class GenerationActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gen_pokemon);

        // Configura cada botão para enviar o número da geração como parâmetro
        setupButton(R.id.btnGen1, 1);
        setupButton(R.id.btnGen2, 2);
        setupButton(R.id.btnGen3, 3);
        setupButton(R.id.btnGen4, 4);
        setupButton(R.id.btnGen5, 5);
        setupButton(R.id.btnGen6, 6);
        setupButton(R.id.btnGen7, 7);
        setupButton(R.id.btnGen8, 8);
        setupButton(R.id.btnGen9, 9);
    }

    private void setupButton(int buttonId, int generation) {
        Button button = findViewById(buttonId);
        button.setOnClickListener(view -> openPokemonListActivity(generation));
    }

    private void openPokemonListActivity(int generation) {
        Intent intent = new Intent(this, PokemonListActivity.class);
        intent.putExtra("GENERATION", generation);  // Passa a geração como extra
        startActivity(intent);
    }


}
