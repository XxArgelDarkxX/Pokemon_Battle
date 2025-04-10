package Menu;

import Entrenador.Trainer;
import Pokemon.Pokemon;
import java.util.Scanner;



public class BattleMenu {
    Pokemon[] pokemonsBattle = new Pokemon[2];
    public void battleBegins(Scanner sc, Trainer[] trainers) {

        for (Trainer trainer : trainers) {
            trainer.choosePokemon(pokemonsBattle, trainers, sc);
        }
        System.out.println("\n\n______VAMOS A COMENZAR LA BATALLA______\n");

        int comenzar = (pokemonsBattle[1].getHp() < pokemonsBattle[0].getHp()) ? 1 : 0;
        System.out.println("Tu turno entrenador:  " + trainers[comenzar].getName());
        while(pokemonsBattle[0] != null && pokemonsBattle[1] != null) {
            battle(sc, trainers, comenzar);
            verificationHp(sc, trainers);
            if(pokemonsBattle[0] != null && pokemonsBattle[1] != null) {
                comenzar = 1- comenzar;
            }
        }
    }

    // Maneja la batalla entre los dos entrenadores.
    public void battle(Scanner sc, Trainer[] trainers, int comenzar) {
        // Se elige el ataque y se ejecuta el movimiento.
        System.out.println("\nEntrenador "+trainers[comenzar].getName() +" es tu turno con el pokemon " + pokemonsBattle[comenzar].getName()  );
        for(int i = 0; i< pokemonsBattle[comenzar].getMoves().size(); i++){
            System.out.println("\t" + (i +1)  + " " +  pokemonsBattle[comenzar].getMoves().get(i).getName() + " " + pokemonsBattle[comenzar].getMoves().get(i).getPower() );
        }
        int ataque;

        do {
            System.out.println("elije el ataque");
            ataque = sc.nextInt();
            sc.nextLine();
        }while(ataque < 0 || ataque > pokemonsBattle[comenzar].getMoves().size());

        int oponente = 1 - comenzar;
        pokemonsBattle[comenzar].movement(pokemonsBattle[oponente], ataque-1);
    }


    public void verificationHp(Scanner sc, Trainer[] trainers) {
        if (pokemonsBattle[0] != null && pokemonsBattle[0].getHp() <= 0) {
            handleDefeatedPokemon(0, trainers, sc);
        } else if (pokemonsBattle[1] != null && pokemonsBattle[1].getHp() <= 0) {
            handleDefeatedPokemon(1, trainers, sc);
        }
    }

    private void handleDefeatedPokemon(int index, Trainer[] trainers, Scanner sc) {
        trainers[index].getPokemonTeam().remove(pokemonsBattle[index]);
        pokemonsBattle[index] = null;
        if (trainers[index].getPokemonTeam().isEmpty()) {
            win(index, trainers);
        } else {
            trainers[index].choosePokemon(pokemonsBattle, trainers, sc);
        }
    }

    // Se define el ganador de la batalla.
    public void win(int index, Trainer[] trainers) {
        System.out.println("Felicitaciones");
        System.out.println(trainers[1- index].getName() + " ha ganado la batalla ");
        for(int i = 0; i< trainers[1- index].getPokemonTeam().size(); i++) {
            // Se imprime el pokemon que queda en pie y su vida.
            System.out.println("pokemon: " + trainers[1- index].getPokemonTeam().get(i).getName() + ", vida : " +  pokemonsBattle[1- index].getHp());
        }
        System.exit(0);

    }
}