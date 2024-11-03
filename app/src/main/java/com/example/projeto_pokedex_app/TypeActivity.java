package com.example.projeto_pokedex_app; // Substitua pelo seu pacote

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class TypeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_type); // Certifique-se de que o nome do layout está correto

        // Inicialização dos botões
        Button btnFire = findViewById(R.id.btnFire);
        Button btnFlying = findViewById(R.id.btnFlying);
        Button btnElectric = findViewById(R.id.btnElectric);
        Button btnIce = findViewById(R.id.btnIce);
        Button btnNormal = findViewById(R.id.BtnNormal);
        Button btnBug = findViewById(R.id.btnBug);
        Button btnWater = findViewById(R.id.btnWater);
        Button btnDark = findViewById(R.id.btnDark);
        Button btnFighting = findViewById(R.id.btnFighting);
        Button btnPsychic = findViewById(R.id.btnPsychic);
        Button btnGrass = findViewById(R.id.btnGrass);
        Button btnFairy = findViewById(R.id.btnFairy);
        Button btnDragon = findViewById(R.id.btnDragon);
        Button btnPoison = findViewById(R.id.btnPoison);
        Button btnSteel = findViewById(R.id.btnSteel);
        Button btnRock = findViewById(R.id.btnRock);
        Button btnGround = findViewById(R.id.btnGround);
        Button btnGhost = findViewById(R.id.btnGhost);

        // Definindo os ouvintes de clique para os botões
        btnFire.setOnClickListener(v -> startActivity(new Intent(TypeActivity.this, FireActivity.class)));
        btnFlying.setOnClickListener(v -> startActivity(new Intent(TypeActivity.this, FlyingActivity.class)));
        btnElectric.setOnClickListener(v -> startActivity(new Intent(TypeActivity.this, ElectricActivity.class)));
        btnIce.setOnClickListener(v -> startActivity(new Intent(TypeActivity.this, IceActivity.class)));
        btnNormal.setOnClickListener(v -> startActivity(new Intent(TypeActivity.this, NormalActivity.class)));
        btnBug.setOnClickListener(v -> startActivity(new Intent(TypeActivity.this, BugActivity.class)));
        btnWater.setOnClickListener(v -> startActivity(new Intent(TypeActivity.this, WaterActivity.class)));
        btnDark.setOnClickListener(v -> startActivity(new Intent(TypeActivity.this, DarkActivity.class)));
        btnFighting.setOnClickListener(v -> startActivity(new Intent(TypeActivity.this, FightingActivity.class)));
        btnPsychic.setOnClickListener(v -> startActivity(new Intent(TypeActivity.this, PsychicActivity.class)));
        btnGrass.setOnClickListener(v -> startActivity(new Intent(TypeActivity.this, GrassActivity.class)));
        btnFairy.setOnClickListener(v -> startActivity(new Intent(TypeActivity.this, FairyActivity.class)));
        btnDragon.setOnClickListener(v -> startActivity(new Intent(TypeActivity.this, DragonActivity.class)));
        btnPoison.setOnClickListener(v -> startActivity(new Intent(TypeActivity.this, PoisonActivity.class)));
        btnSteel.setOnClickListener(v -> startActivity(new Intent(TypeActivity.this, SteelActivity.class)));
        btnRock.setOnClickListener(v -> startActivity(new Intent(TypeActivity.this, RockActivity.class)));
        btnGround.setOnClickListener(v -> startActivity(new Intent(TypeActivity.this, GroundActivity.class)));
        btnGhost.setOnClickListener(v -> startActivity(new Intent(TypeActivity.this, GhostActivity.class)));
    }
}
