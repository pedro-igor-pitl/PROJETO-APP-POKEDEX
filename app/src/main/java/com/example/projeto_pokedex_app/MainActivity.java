package com.example.projeto_pokedex_app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Botão para Gerações
        Button btnGen = findViewById(R.id.btnGen);
        btnGen.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, GenerationActivity.class);
            startActivity(intent);
        });

        // Botão para Tipos com expressão lambda
        Button btnTypes = findViewById(R.id.btnTypes);
        btnTypes.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, TypeActivity.class);
            startActivity(intent);
        });
    }
}
