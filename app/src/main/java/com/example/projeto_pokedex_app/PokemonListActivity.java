package com.example.projeto_pokedex_app;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class PokemonListActivity extends AppCompatActivity {

    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pokemonlistactivity); // Verifique se o nome do layout está correto

        ListView listViewPokemon = findViewById(R.id.listViewPokemon); // ID da ListView no layout
        dbHelper = new DatabaseHelper(this);

        // Recebendo dados da Intent
        Intent intent = getIntent();
        String type = intent.getStringExtra("type"); // Recebendo o tipo
        int generation = intent.getIntExtra("generation", -1); // Recebendo a geração

        // Verificando se o tipo ou a geração foram passados
        List<Pokemon> pokemonList;
        if (type != null) {
            pokemonList = getPokemonByType(type); // Obter Pokémon pelo tipo
        } else {
            pokemonList = getPokemonByGeneration(generation); // Obter Pokémon pela geração
        }

        // Configurando o adapter da ListView
        ArrayAdapter<Pokemon> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pokemonList);
        listViewPokemon.setAdapter(adapter);

        // Configurando o listener para cliques na lista
        listViewPokemon.setOnItemClickListener((parent, view, position, id) -> {
            Pokemon clickedPokemon = pokemonList.get(position);
            Intent detailIntent = new Intent(PokemonListActivity.this, PokemonDetailActivity.class);
            detailIntent.putExtra("pokemon_name", clickedPokemon.getName());
            detailIntent.putExtra("pokemon_type", clickedPokemon.getType1() + (clickedPokemon.getType2() != null ? ", " + clickedPokemon.getType2() : ""));
            detailIntent.putExtra("pokemon_description", clickedPokemon.getDescription());
            startActivity(detailIntent);
        });
    }

    private List<Pokemon> getPokemonByType(String type) {
        List<Pokemon> pokemonList = new ArrayList<>();
        Cursor cursor = dbHelper.getPokemonByType(type); // Certifique-se de que você tem esse método no seu DatabaseHelper

        if (cursor != null && cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_NAME));
                String type1 = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_TYPE1));
                String type2 = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_TYPE2)); // Lê o segundo tipo, que pode ser nulo
                String description = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_DESCRIPTION));

                // Adiciona o Pokémon à lista
                Pokemon pokemon = new Pokemon(name, type1, type2, description);
                pokemonList.add(pokemon);
            } while (cursor.moveToNext());
        }

        // Fechar o cursor após uso
        if (cursor != null) {
            cursor.close();
        }

        return pokemonList; // Retorna a lista de Pokémon
    }

    private List<Pokemon> getPokemonByGeneration(int generation) {
        List<Pokemon> pokemonList = new ArrayList<>();
        Cursor cursor = dbHelper.getPokemonByGeneration(generation); // Certifique-se de que você tem esse método no seu DatabaseHelper

        if (cursor != null && cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_NAME));
                String type1 = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_TYPE1));
                String type2 = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_TYPE2)); // Lê o segundo tipo, que pode ser nulo
                String description = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_DESCRIPTION));

                // Adiciona o Pokémon à lista
                Pokemon pokemon = new Pokemon(name, type1, type2, description);
                pokemonList.add(pokemon);
            } while (cursor.moveToNext());
        }

        // Fechar o cursor após uso
        if (cursor != null) {
            cursor.close();
        }

        return pokemonList; // Retorna a lista de Pokémon
    }
}
