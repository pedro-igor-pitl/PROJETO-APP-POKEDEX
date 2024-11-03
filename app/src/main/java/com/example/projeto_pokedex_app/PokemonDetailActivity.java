package com.example.projeto_pokedex_app;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PokemonDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokemon_detail_activity);

        TextView textViewPokemonName = findViewById(R.id.textViewPokemonName);
        TextView textViewPokemonType = findViewById(R.id.textViewPokemonType);
        TextView textViewPokemonDescription = findViewById(R.id.textViewPokemonDescription);

        // Obtém os dados passados pela Intent
        String pokemonName = getIntent().getStringExtra("pokemon_name");
        String pokemonType = getIntent().getStringExtra("pokemon_type");
        String pokemonDescription = getIntent().getStringExtra("pokemon_description");

        // Define os dados nas Views
        textViewPokemonName.setText(pokemonName);
        textViewPokemonType.setText(pokemonType);
        textViewPokemonDescription.setText(pokemonDescription); // Exibe a descrição
    }
}
