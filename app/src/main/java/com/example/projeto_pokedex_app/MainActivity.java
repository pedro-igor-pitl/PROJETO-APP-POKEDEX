package com.example.projeto_pokedex_app; // Altere para o pacote do seu projeto

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button btnGen;
    private Button btnTypes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Certifique-se de que o nome do layout XML corresponde

        // Inicializando as views
        imageView = findViewById(R.id.imageView2);
        btnGen = findViewById(R.id.btnGen);
        btnTypes = findViewById(R.id.btnTypes);

        // Definindo listeners para os botões
        btnGen.setOnClickListener(v -> {
            // Inicia a GenerationActivity quando o botão GENERATIONS é clicado
            Intent intent = new Intent(MainActivity.this, GenerationsActivity.class);
            startActivity(intent);
        });

        btnTypes.setOnClickListener(v -> {
            // Inicia a TypeActivity quando o botão TYPES é clicado
            Intent intent = new Intent(MainActivity.this, TypeActivity.class);
            startActivity(intent);
        });
    }
}
