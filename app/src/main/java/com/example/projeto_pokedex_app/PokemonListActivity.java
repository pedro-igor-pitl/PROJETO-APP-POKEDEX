package com.example.projeto_pokedex_app;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.AdapterView;
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
        setContentView(R.layout.pokemonlistactivity); // Certifique-se de que o nome do layout está correto

        ListView listViewPokemon = findViewById(R.id.listViewPokemon); // ID da ListView no layout
        dbHelper = new DatabaseHelper(this);

        // Recebendo o número da geração da Intent
        int generation = getIntent().getIntExtra("generation", 1);
        List<Pokemon> pokemonList = getPokemonByGeneration(generation);

        ArrayAdapter<Pokemon> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, pokemonList);
        listViewPokemon.setAdapter(adapter);

        // Configurando o listener para cliques na lista
        listViewPokemon.setOnItemClickListener((parent, view, position, id) -> {
            Pokemon clickedPokemon = pokemonList.get(position);
            Intent intent = new Intent(PokemonListActivity.this, PokemonDetailActivity.class);
            intent.putExtra("pokemon_name", clickedPokemon.getName());
            intent.putExtra("pokemon_type", clickedPokemon.getType1() + (clickedPokemon.getType2() != null ? ", " + clickedPokemon.getType2() : ""));
            intent.putExtra("pokemon_description", clickedPokemon.getDescription()); // Passa a descrição
            startActivity(intent);
        });
    }

    private List<Pokemon> getPokemonByGeneration(int generation) {
        List<Pokemon> pokemonList = new ArrayList<>();
        Cursor cursor = dbHelper.getPokemonByGeneration(generation);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_NAME));
                String type1 = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_TYPE1));
                String type2 = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_TYPE2));
                String description = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_DESCRIPTION)); // Obtém a descrição
                pokemonList.add(new Pokemon(name, type1, type2, description));
            } while (cursor.moveToNext());
            cursor.close(); // Fecha o cursor após o uso
        } else if (cursor != null) {
            cursor.close(); // Fecha o cursor se não houver dados
        }
        return pokemonList;
    }
}
