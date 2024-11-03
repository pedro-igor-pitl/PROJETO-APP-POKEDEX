package com.example.projeto_pokedex_app;

public class Pokemon {
    private String name;
    private String type1;
    private String type2;
    private String description;

    public Pokemon(String name, String type1, String type2, String description) {
        this.name = name;
        this.type1 = type1;
        this.type2 = type2;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getType1() {
        return type1;
    }

    public String getType2() {
        return type2;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return name + " (" + type1 + (type2 != null ? ", " + type2 : "") + ")";
    }
}
