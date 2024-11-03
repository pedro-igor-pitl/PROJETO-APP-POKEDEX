package com.example.projeto_pokedex_app;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class WaterActivity extends AppCompatActivity { // Classe para exibir Pokémon do tipo Water

    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water); // Verifique se 'activity_water' está correto

        ListView listViewWaterPokemon = findViewById(R.id.listViewWaterPokemon); // ID do ListView correspondente

        dbHelper = new DatabaseHelper(this);
        List<String> waterPokemonList = getPokemonByType("Water"); // Buscar Pokémon do tipo "Water"

        // Exibir mensagem caso a lista esteja vazia
        if (waterPokemonList.isEmpty()) {
            Toast.makeText(this, "Nenhum Pokémon do tipo Water encontrado.", Toast.LENGTH_SHORT).show();
        }

        // Configurar o adaptador para o ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, waterPokemonList);
        listViewWaterPokemon.setAdapter(adapter);
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
        cursor.close(); // Fechar o cursor após o uso
        return pokemonList;
    }
}
