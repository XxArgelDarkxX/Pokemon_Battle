package Entrenador;

import Pokemon.Pokemon;
import java.util.ArrayList;

public class Trainer {
    
    private String name;

    private ArrayList<Pokemon> pokemonTeam = new ArrayList<>();

    public Trainer() {
    }

    public Trainer(String name, ArrayList<Pokemon> pokemonTeam) {
        this.name = name;
        this.pokemonTeam = pokemonTeam;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Pokemon> getPokemonTeam() {
        return pokemonTeam;
    }

    public void setPokemonTeam(ArrayList<Pokemon> pokemonTeam) {
        this.pokemonTeam = pokemonTeam;
    }
    
    public void setRandomPokemonTeam(ArrayList<Pokemon> pokemons) {
        // Se crea un equipo de 3 Pokemon aleatorios.
        for (int i = 0; i < 3; i++) {
            int randomIndex = (int) (Math.random() * pokemons.size());
            this.pokemonTeam.add(pokemons.get(randomIndex));
            pokemons.remove(randomIndex);
        }
    }
}
