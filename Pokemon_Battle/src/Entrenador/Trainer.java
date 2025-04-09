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

    public void choosePokemon(Pokemon[] pokemonsBattle, Trainer[] trainers, Scanner scanner) {
        if(pokemonsBattle[0] == null && pokemonsBattle[1] == null) {
            for(int i = 0; i < trainers.length; i++) {
                Trainer trainer = trainers[i];
                System.out.println("Entrenador: " + trainer.getName() + " elija su pokemon inicial: ");
                for(int j = 0 ; j < trainer.pokemonTeam.size(); j++){
                    System.out.println((j+1)+ " " + trainer.pokemonTeam.get(j).getName() + " " + trainer.pokemonTeam.get(j).getHp());
                }
                int opcion;
                do{
                    System.out.print("\ningrese el numero del pokemon (1 -" + trainer.getPokemonTeam().size() + "): ");
                    while(!scanner.hasNextInt()){
                        System.out.println("Debde ser un numero");
                        scanner.next();
                    }
                    opcion = scanner.nextInt();
                }while(opcion > trainer.pokemonTeam.size() || opcion < 1);
                scanner.nextLine();
                pokemonsBattle[i] = trainer.pokemonTeam.get(opcion -1 );
            }
        }else if (pokemonsBattle[1] == null || pokemonsBattle[0] == null) {
            int index = (pokemonsBattle[0] == null) ? 0 : 1;
            int contador = 0, option;
            Trainer trainer = trainers[index];
            for (int i = 0; i < pokemonTeam.size(); i++) {
                System.out.println("\t" + (i+1)+ " " + trainer.pokemonTeam.get(i).getName() + " " + trainer.pokemonTeam.get(i).getHp());
            }
            System.out.println("elija un pokemon ");
            option = scanner.nextInt();
            pokemonsBattle[index] = pokemonTeam.get(option - 1);


        }
    }
}
