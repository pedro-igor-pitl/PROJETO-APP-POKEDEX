package com.example.projeto_pokedex_app;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class PoisonActivity extends AppCompatActivity { // Classe para exibir Pokémon do tipo Poison

    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_poison); // Altere para o layout correspondente

        ListView listViewPoisonPokemon = findViewById(R.id.listViewPoisonPokemon); // ID do ListView correspondente

        dbHelper = new DatabaseHelper(this);
        List<String> poisonPokemonList = getPokemonByType("Poison"); // Buscar Pokémon do tipo "Poison"

        // Exibir mensagem caso a lista esteja vazia
        if (poisonPokemonList.isEmpty()) {
            Toast.makeText(this, "Nenhum Pokémon do tipo Poison encontrado.", Toast.LENGTH_SHORT).show();
        }

        // Configurar o adaptador para o ListView
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, poisonPokemonList);
        listViewPoisonPokemon.setAdapter(adapter);
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
