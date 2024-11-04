package com.example.projeto_pokedex_app;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class PokemonDataSeeder {
    private static final String TABLE_POKEMON = "pokemon";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_TYPE1 = "type1";
    private static final String COLUMN_TYPE2 = "type2";
    private static final String COLUMN_GENERATION = "generation";
    private static final String COLUMN_DESCRIPTION = "description";

    // Método público para adicionar Pokémon
    public void addPokemon(SQLiteDatabase db, String name, String type1, String type2, int generation, String description) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_TYPE1, type1);
        values.put(COLUMN_TYPE2, type2);
        values.put(COLUMN_GENERATION, generation);
        values.put(COLUMN_DESCRIPTION, description);
        db.insert(TABLE_POKEMON, null, values);
    }

    public void addInitialData(SQLiteDatabase db) {
        // Usando o novo método addPokemon
        addPokemon(db, "Mew", "Psychic", "Fairy", 1, "Mew is a mythical Pokémon known for its ability to learn any move.");
        // Adicione mais Pokémon conforme necessário
    }
}
