package Entrenador;

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
                System.out.println(trainer.getName() + " elija tu pokemon inicial: ");
                for(int j = 0 ; j < trainer.pokemonTeam.size(); j++){
                    System.out.println((j+1)+ " " + trainer.pokemonTeam.get(j).getName() + " " + trainer.pokemonTeam.get(j).getHp());
                }
                int opcion;
                do{
                    System.out.println("ingrese el numero del pokemon (1 -" + trainer.getPokemonTeam().size() + ")");
                    while(!scanner.hasNextInt()){
                        System.out.println("Debde ser un numero");
                        scanner.nextLine();
                    }
                    opcion = scanner.nextInt();
                }while(opcion > trainer.pokemonTeam.size() || opcion < 1);
                pokemonsBattle[i] = trainer.pokemonTeam.get(opcion -1 );
            }
        }else if (pokemonsBattle[1] == null) {
            int contador = 0;

            System.out.println("elija otro pokemon: ");
            for(Pokemon pokemon : pokemonTeam) {
                contador += 1 ;
                System.out.println(contador + " " +pokemon.getName() + " " + pokemon.getHp());
            }
            int opcion;
            System.out.println("ingrese el numero del pokemon");
            opcion = scanner.nextInt();
            pokemonsBattle[1] = pokemonTeam.get(opcion -1 );

        }else {
            System.out.println("elija otro pokemon: ");
            int contador =0;

            for(Pokemon pokemon : pokemonTeam) {
                contador += 1 ;
                System.out.println(contador + " " +pokemon.getName() + " " + pokemon.getHp());
            }
            int opcion;
            System.out.println("ingrese el numero del pokemon");
            opcion = scanner.nextInt();
            pokemonsBattle[0] = pokemonTeam.get(opcion -1 );

        }

    }




}
