package com.example.projeto_pokedex_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class TypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type);

        // Inicialização das ImageViews
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
        ic_fire.setOnClickListener(v -> startActivity(new Intent(TypeActivity.this, FireActivity.class)));
        ic_flying.setOnClickListener(v -> startActivity(new Intent(TypeActivity.this, FlyingActivity.class)));
        ic_electric.setOnClickListener(v -> startActivity(new Intent(TypeActivity.this, ElectricActivity.class)));
        ic_ice.setOnClickListener(v -> startActivity(new Intent(TypeActivity.this, IceActivity.class)));
        ic_normal.setOnClickListener(v -> startActivity(new Intent(TypeActivity.this, NormalActivity.class)));
        ic_bug.setOnClickListener(v -> startActivity(new Intent(TypeActivity.this, BugActivity.class)));
        ic_water.setOnClickListener(v -> startActivity(new Intent(TypeActivity.this, WaterActivity.class)));
        ic_dark.setOnClickListener(v -> startActivity(new Intent(TypeActivity.this, DarkActivity.class)));
        ic_fighting.setOnClickListener(v -> startActivity(new Intent(TypeActivity.this, FightingActivity.class)));
        ic_psychic.setOnClickListener(v -> startActivity(new Intent(TypeActivity.this, PsychicActivity.class)));
        ic_grass.setOnClickListener(v -> startActivity(new Intent(TypeActivity.this, GrassActivity.class)));
        ic_fairy.setOnClickListener(v -> startActivity(new Intent(TypeActivity.this, FairyActivity.class)));
        ic_dragon.setOnClickListener(v -> startActivity(new Intent(TypeActivity.this, DragonActivity.class)));
        ic_poison.setOnClickListener(v -> startActivity(new Intent(TypeActivity.this, PoisonActivity.class)));
        ic_steel.setOnClickListener(v -> startActivity(new Intent(TypeActivity.this, SteelActivity.class)));
        ic_rock.setOnClickListener(v -> startActivity(new Intent(TypeActivity.this, RockActivity.class)));
        ic_ground.setOnClickListener(v -> startActivity(new Intent(TypeActivity.this, GroundActivity.class)));
        ic_ghost.setOnClickListener(v -> startActivity(new Intent(TypeActivity.this, GhostActivity.class)));
    }
}
