package Entrenador;

import java.util.ArrayList;

public class Trainer {
    
    private String name;

    private ArrayList<String> pokemonTeam = new ArrayList<>();

    public Trainer() {
    }

    public Trainer(String name, ArrayList<String> pokemonTeam) {
        this.name = name;
        this.pokemonTeam = pokemonTeam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getPokemonTeam() {
        return pokemonTeam;
    }

    public void setPokemonTeam(ArrayList<String> pokemonTeam) {
        this.pokemonTeam = pokemonTeam;
    }
}
