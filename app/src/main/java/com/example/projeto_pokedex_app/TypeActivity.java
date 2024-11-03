package com.example.projeto_pokedex_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class TypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_type);

        setupTypeButtons();
    }

    private void setupTypeButtons() {
        findViewById(R.id.btnFire).setOnClickListener(view -> startPokemonListActivity("Fire"));
        findViewById(R.id.btnWater).setOnClickListener(view -> startPokemonListActivity("Water"));
        findViewById(R.id.btnGrass).setOnClickListener(view -> startPokemonListActivity("Grass"));
        findViewById(R.id.btnElectric).setOnClickListener(view -> startPokemonListActivity("Electric"));
        findViewById(R.id.btnIce).setOnClickListener(view -> startPokemonListActivity("Ice"));
        findViewById(R.id.btnBug).setOnClickListener(view -> startPokemonListActivity("Bug"));
        findViewById(R.id.btnDark).setOnClickListener(view -> startPokemonListActivity("Dark"));
        findViewById(R.id.btnFighting).setOnClickListener(view -> startPokemonListActivity("Fighting"));
        findViewById(R.id.btnPsychic).setOnClickListener(view -> startPokemonListActivity("Psychic"));
        findViewById(R.id.btnFairy).setOnClickListener(view -> startPokemonListActivity("Fairy"));
        findViewById(R.id.btnDragon).setOnClickListener(view -> startPokemonListActivity("Dragon"));
        findViewById(R.id.btnPoison).setOnClickListener(view -> startPokemonListActivity("Poison"));
        findViewById(R.id.btnSteel).setOnClickListener(view -> startPokemonListActivity("Steel"));
        findViewById(R.id.btnRock).setOnClickListener(view -> startPokemonListActivity("Rock"));
        findViewById(R.id.btnGround).setOnClickListener(view -> startPokemonListActivity("Ground"));
        findViewById(R.id.btnGhost).setOnClickListener(view -> startPokemonListActivity("Ghost"));
    }

    private void startPokemonListActivity(String type) {
        Intent intent = new Intent(this, PokemonListActivity.class);
        intent.putExtra("POKEMON_TYPE", type);
        startActivity(intent);
    }
}
