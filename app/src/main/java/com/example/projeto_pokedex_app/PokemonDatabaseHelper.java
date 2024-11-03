package com.example.projeto_pokedex_app;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class PokemonDatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "pokedex.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "pokemons";
    private static final String COLUMN_NAME = "name";
    private static final String COLUMN_GENERATION = "generation";

    public PokemonDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_NAME + " TEXT PRIMARY KEY, " +
                COLUMN_GENERATION + " INTEGER)"; // Altere para INTEGER
        db.execSQL(createTable);

        // Adicione Pokémon ao banco de dados inicial aqui
        insertInitialPokemon(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    private void insertInitialPokemon(SQLiteDatabase db) {
        insertPokemon(db, "Charmander", 1);
        insertPokemon(db, "Squirtle", 1);
        insertPokemon(db, "Bulbasaur", 1);
        insertPokemon(db, "Cyndaquil", 2);
        insertPokemon(db, "Totodile", 2);
        insertPokemon(db, "Chikorita", 2);
    }

    // Método para inserir Pokémon no banco de dados
    public void insertPokemon(SQLiteDatabase db, String name, int generation) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_NAME, name);
        values.put(COLUMN_GENERATION, generation); // Armazenar como inteiro
        db.insert(TABLE_NAME, null, values);
    }

    public List<String> getPokemonByGeneration(int generation) {
        List<String> pokemonList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();

        // Usa o inteiro diretamente na consulta
        Cursor cursor = db.query(TABLE_NAME, new String[]{COLUMN_NAME}, COLUMN_GENERATION + "=?", new String[]{String.valueOf(generation)}, null, null, null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                @SuppressLint("Range") String pokemonName = cursor.getString(cursor.getColumnIndex(COLUMN_NAME));
                pokemonList.add(pokemonName);
            }
            cursor.close(); // Fechar o cursor após o uso
        }

        return pokemonList;
    }
}
