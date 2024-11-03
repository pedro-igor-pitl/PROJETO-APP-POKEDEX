package com.example.projeto_pokedex_app;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class BugActivity extends AppCompatActivity {

    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bug);

        ListView listViewBugPokemon = findViewById(R.id.listViewBugPokemon);

        dbHelper = new DatabaseHelper(this);
        List<String> bugPokemonList = getPokemonByType("Bug");

        // Adaptador para exibir a lista de Pokémon
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, bugPokemonList);
        listViewBugPokemon.setAdapter(adapter);

        // Configura o clique para abrir os detalhes do Pokémon
        listViewBugPokemon.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Pegando o ID do Pokémon clicado (aqui estou assumindo que você tem uma lista de IDs para cada Pokémon)
                String pokemonId = getPokemonIdByPosition(position);

                // Inicia a atividade de detalhes com o ID do Pokémon
                Intent intent = new Intent(BugActivity.this, PokemonDetailActivity.class);
                intent.putExtra("pokemon_id", pokemonId);
                startActivity(intent);
            }
        });
    }

    private List<String> getPokemonByType(String type) {
        List<String> pokemonList = new ArrayList<>();
        Cursor cursor = dbHelper.getPokemonByType(type);

        if (cursor.moveToFirst()) {
            do {
                // Obtém o ID, nome e tipos do Pokémon
                String id = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_ID));
                String name = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_NAME));
                String type1 = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_TYPE1));
                String type2 = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.COLUMN_TYPE2));

                // Exiba o ID, nome e tipos
                String displayName = " " + id + " | " + name + " (" + type1 + (type2 != null ? ", " + type2 : "") + ")";
                pokemonList.add(displayName);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return pokemonList;
    }

    private String getPokemonIdByPosition(int position) {
        // Implementar lógica para pegar o ID do Pokémon de acordo com a posição
        // Isso pode ser feito usando uma lista auxiliar que armazena os IDs junto com os nomes.
        // Por exemplo, mantenha uma lista de IDs como parte da sua lógica.
        return "pokemon_id_exemplo";
    }
}
