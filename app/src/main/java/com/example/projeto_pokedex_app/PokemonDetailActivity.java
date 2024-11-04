package com.example.projeto_pokedex_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PokemonDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokemon_detail_activity);

        ImageView iv_logo = findViewById(R.id.iv_logo);
        TextView textViewPokemonName = findViewById(R.id.textViewPokemonName);
        TextView textViewPokemonType = findViewById(R.id.textViewPokemonType);
        TextView textViewPokemonDescription = findViewById(R.id.textViewPokemonDescription);

        iv_logo.setOnClickListener(v -> {
            Intent intent = new Intent(PokemonDetailActivity.this, MainActivity.class); // Substitua GenActivity pela sua atividade de origem
            startActivity(intent);
            finish(); // Se você não quiser que a PokémonListActivity fique na pilha de atividades
        });
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
