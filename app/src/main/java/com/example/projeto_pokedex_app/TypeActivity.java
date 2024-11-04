package com.example.projeto_pokedex_app;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class TypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type);


        // Inicialização das ImageViews
        ImageView iv_logo = findViewById(R.id.iv_logo);
        ImageView ic_fire = findViewById(R.id.ic_fire);
        ImageView ic_flying = findViewById(R.id.ic_flying);
        ImageView ic_electric = findViewById(R.id.ic_electric);
        ImageView ic_ice = findViewById(R.id.ic_ice);
        ImageView ic_normal = findViewById(R.id.ic_normal);
        ImageView ic_bug = findViewById(R.id.ic_bug);
        ImageView ic_water = findViewById(R.id.ic_water);
        ImageView ic_dark = findViewById(R.id.ic_dark);
        ImageView ic_fighting = findViewById(R.id.ic_fighting);
        ImageView ic_psychic = findViewById(R.id.ic_psychic);
        ImageView ic_grass = findViewById(R.id.ic_grass);
        ImageView ic_fairy = findViewById(R.id.ic_fairy);
        ImageView ic_dragon = findViewById(R.id.ic_dragon);
        ImageView ic_poison = findViewById(R.id.ic_poison);
        ImageView ic_steel = findViewById(R.id.ic_steel);
        ImageView ic_rock = findViewById(R.id.ic_rock);
        ImageView ic_ground = findViewById(R.id.ic_ground);
        ImageView ic_ghost = findViewById(R.id.ic_ghost);

        // Definindo os ouvintes de clique para as ImageViews
        ic_fire.setOnClickListener(v -> navigateToPokemonList("Fire"));
        ic_flying.setOnClickListener(v -> navigateToPokemonList("Flying"));
        ic_electric.setOnClickListener(v -> navigateToPokemonList("Electric"));
        ic_ice.setOnClickListener(v -> navigateToPokemonList("Ice"));
        ic_normal.setOnClickListener(v -> navigateToPokemonList("Normal"));
        ic_bug.setOnClickListener(v -> navigateToPokemonList("Bug"));
        ic_water.setOnClickListener(v -> navigateToPokemonList("Water"));
        ic_dark.setOnClickListener(v -> navigateToPokemonList("Dark"));
        ic_fighting.setOnClickListener(v -> navigateToPokemonList("Fighting"));
        ic_psychic.setOnClickListener(v -> navigateToPokemonList("Psychic"));
        ic_grass.setOnClickListener(v -> navigateToPokemonList("Grass"));
        ic_fairy.setOnClickListener(v -> navigateToPokemonList("Fairy"));
        ic_dragon.setOnClickListener(v -> navigateToPokemonList("Dragon"));
        ic_poison.setOnClickListener(v -> navigateToPokemonList("Poison"));
        ic_steel.setOnClickListener(v -> navigateToPokemonList("Steel"));
        ic_rock.setOnClickListener(v -> navigateToPokemonList("Rock"));
        ic_ground.setOnClickListener(v -> navigateToPokemonList("Ground"));
        ic_ghost.setOnClickListener(v -> navigateToPokemonList("Ghost"));

        // Configurando o listener para a logo
        iv_logo.setOnClickListener(v -> {
            Intent mainIntent = new Intent(TypeActivity.this, MainActivity.class);
            startActivity(mainIntent);
        });
    }



    private void navigateToPokemonList(String type) {
        Intent intent = new Intent(TypeActivity.this, PokemonListActivity.class);
        intent.putExtra("type", type);  // Passa o tipo de Pokémon como string
        startActivity(intent);
    }
}
