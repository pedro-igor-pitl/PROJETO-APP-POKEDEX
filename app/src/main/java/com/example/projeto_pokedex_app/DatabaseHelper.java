package com.example.projeto_pokedex_app;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "pokedex.db";
    private static final int DATABASE_VERSION = 2; // Atualize a versão do banco de dados

    public static final String TABLE_POKEMON = "pokemon";
    public static final String COLUMN_ID = "_id";
    public static final String COLUMN_NAME = "name";
    public static final String COLUMN_TYPE1 = "type1";
    public static final String COLUMN_TYPE2 = "type2";
    public static final String COLUMN_GENERATION = "generation";
    public static final String COLUMN_DESCRIPTION = "description"; // Adiciona a constante para a nova coluna

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_POKEMON_TABLE = "CREATE TABLE " + TABLE_POKEMON + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_NAME + " TEXT, " +
                COLUMN_TYPE1 + " TEXT, " +
                COLUMN_TYPE2 + " TEXT, " +
                COLUMN_GENERATION + " INTEGER, " + // Geração
                COLUMN_DESCRIPTION + " TEXT)"; // Adiciona a nova coluna de descrição
        db.execSQL(CREATE_POKEMON_TABLE);

        // Inserção de dados iniciais
        addInitialData(db);
    }

    private void addInitialData(SQLiteDatabase db) {
        PokemonDataSeeder.seedInitialData(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 2) { // Verifica se a versão anterior é menor que 2
            db.execSQL("ALTER TABLE " + TABLE_POKEMON + " ADD COLUMN " + COLUMN_DESCRIPTION + " TEXT");
        }
    }

    public Cursor getPokemonByGeneration(int generation) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_POKEMON, null, COLUMN_GENERATION + "=?", new String[]{String.valueOf(generation)}, null, null, null);
    }

    public Cursor getPokemonByType(String type) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_POKEMON, null, COLUMN_TYPE1 + "=? OR " + COLUMN_TYPE2 + "=?", new String[]{type, type}, null, null, null);

        // Log para depuração
        Log.d("DatabaseHelper", "Querying for type: " + type + " Result Count: " + cursor.getCount());

        return cursor;
    }
}
