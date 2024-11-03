package com.example.projeto_pokedex_app;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.List;

public class PokemonListActivity extends AppCompatActivity {

    private ListView listViewPokemon; // ListView para exibir Pokémon
    private PokemonDatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokemon_list);

        // Inicializa o helper do banco de dados
        dbHelper = new PokemonDatabaseHelper(this);

        // Verifica se o banco de dados foi criado e está acessível
        if (dbHelper != null) {
            // Recebe a geração passada pela Intent
            int generation = getIntent().getIntExtra("GENERATION", -1);
            String generationStr = "Geração " + generation;

            TextView textView = findViewById(R.id.textViewGeneration);
            textView.setText("Exibindo Pokémon da " + generationStr);

            listViewPokemon = findViewById(R.id.listViewPokemon); // Inicializa o ListView

            // Carrega a lista de Pokémon com base na geração
            loadPokemonList(generation);  // Passa diretamente o número da geração
        }
    }

    private void loadPokemonList(int generation) {
        List<String> pokemonList = dbHelper.getPokemonByGeneration(generation); // Passa o número da geração diretamente

        // Verifica se a lista está vazia
        if (pokemonList.isEmpty()) {
            pokemonList.add("Nenhum Pokémon encontrado");
        }

        // Cria um ArrayAdapter para conectar os dados ao ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pokemonList);
        listViewPokemon.setAdapter(adapter); // Define o adapter para o ListView
    }
}
