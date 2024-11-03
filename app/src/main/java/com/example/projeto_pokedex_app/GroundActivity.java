package com.example.projeto_pokedex_app;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class GroundActivity extends AppCompatActivity { // Classe para exibir Pokémon do tipo Ground

    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ground); // Altere para o layout correspondente

        ListView listViewGroundPokemon = findViewById(R.id.listViewGroundPokemon); // ID do ListView correspondente

        dbHelper = new DatabaseHelper(this);
        List<String> groundPokemonList = getPokemonByType("Ground"); // Buscar Pokémon do tipo "Ground"

        if (groundPokemonList.isEmpty()) {
            Toast.makeText(this, "Nenhum Pokémon do tipo Ground encontrado.", Toast.LENGTH_SHORT).show();
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, groundPokemonList);
        listViewGroundPokemon.setAdapter(adapter);
    }

    private List<String> getPokemonByType(String type) {
        List<String> pokemonList = new ArrayList<>();
        Cursor cursor = dbHelper.getPokemonByType(type);

        if (cursor.moveToFirst()) {
            do {
                String name = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_NAME));
                String type1 = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_TYPE1));
                String type2 = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_TYPE2));
                // Exiba o nome e os tipos
                String displayName = name + " (" + type1 + (type2 != null ? ", " + type2 : "") + ")";
                pokemonList.add(displayName);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return pokemonList;
    }
}
