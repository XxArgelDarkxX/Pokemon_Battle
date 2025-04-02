package Entrenador;

import Menu.BattleMenu;
import Pokemon.Pokemon;
import java.util.ArrayList;
import java.util.Scanner;

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


    public void chooseFirstPokemon(Pokemon[] pokemonsBattle, Trainer[] trainers, Scanner scanner) {
        if(pokemonsBattle[0] == null && pokemonsBattle[1] == null) {
            int contadorBattle = 0;
            int numberTrainers = 2;
            for(int i = 0; i < numberTrainers; i++) {
                int contador = 1;
                Trainer trainer = trainers[i];
                System.out.println(trainer.getName() + " elija tu pokemon inicial");
                for(Pokemon pokemon : trainer.pokemonTeam) {
                    System.out.println(contador + " " + pokemon.getName() + " " + pokemon.getHp());
                    contador++;
                }

                int opcion = scanner.nextInt();
                do{
                    System.out.println("ingrese el numero del pokemon (1 -" + trainer.getPokemonTeam().size() + ")");
                    opcion = scanner.nextInt();
                }while(opcion > trainer.pokemonTeam.size() || opcion < 1);
                pokemonsBattle[contadorBattle] = trainer.pokemonTeam.get(opcion -1 );
                contadorBattle++;
            }
        }else if (pokemonsBattle[1] == null) {
            
        }else{

        }

    }


}
