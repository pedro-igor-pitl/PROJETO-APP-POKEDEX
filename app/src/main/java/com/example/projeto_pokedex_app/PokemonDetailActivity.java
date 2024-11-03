package com.example.projeto_pokedex_app;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PokemonDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokemon_detail_activity); // Layout para a atividade de detalhes

        TextView textViewPokemonName = findViewById(R.id.textViewPokemonName); // ID de exemplo no layout
        TextView textViewPokemonType = findViewById(R.id.textViewPokemonType);

        // Obtém os dados passados pela intent
        String pokemonName = getIntent().getStringExtra("pokemon_name");
        String pokemonType = getIntent().getStringExtra("pokemon_type");

        // Define os dados nas Views
        textViewPokemonName.setText(pokemonName);
        textViewPokemonType.setText(pokemonType);
    }
}
