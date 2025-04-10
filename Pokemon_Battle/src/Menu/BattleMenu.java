package Menu;

import Entrenador.Trainer;
import Pokemon.Pokemon;
import java.util.Scanner;



public class BattleMenu {

    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_RESET = "\u001B[0m";

    Pokemon[] pokemonsBattle = new Pokemon[2];
    public static void battleMenu() throws Exception {


    }


    public void battleBegins(Scanner sc, Trainer[] trainers) {
        for (Trainer trainer : trainers) {
            trainer.choosePokemon(pokemonsBattle, trainers, sc);
        }
        System.out.println("\n\n\n" + ANSI_RED +
                "▄▄▄▄·  ▄▄▄·▄▄▄▄▄ ▄▄▄· ▄▄▌  ▄▄▌   ▄▄▄·      ▄▄▄·      ▄ •▄ ▄▄▄ .• ▌ ▄ ·.        ▐ ▄ \n" +
                "▐█ ▀█▪▐█ ▀█•██  ▐█ ▀█ ██•  ██•  ▐█ ▀█     ▐█ ▄█▪     █▌▄▌▪▀▄.▀··██ ▐███▪▪     •█▌▐█\n" +
                "▐█▀▀█▄▄█▀▀█ ▐█.▪▄█▀▀█ ██▪  ██▪  ▄█▀▀█      ██▀· ▄█▀▄ ▐▀▀▄·▐▀▀▪▄▐█ ▌▐▌▐█· ▄█▀▄ ▐█▐▐▌\n" +
                "██▄▪▐█▐█ ▪▐▌▐█▌·▐█ ▪▐▌▐█▌▐▌▐█▌▐▌▐█ ▪▐▌    ▐█▪·•▐█▌.▐▌▐█.█▌▐█▄▄▌██ ██▌▐█▌▐█▌.▐▌██▐█▌\n" +
                "·▀▀▀▀  ▀  ▀ ▀▀▀  ▀  ▀ .▀▀▀ .▀▀▀  ▀  ▀     .▀    ▀█▄▀▪·▀  ▀ ▀▀▀ ▀▀  █▪▀▀▀ ▀█▄▀▪▀▀ █▪\n\n"+ ANSI_RESET);

        int comenzar = (pokemonsBattle[1].getHp() < pokemonsBattle[0].getHp()) ? 1 : 0; //cual de los dos primeros pokemones tiene menor vida para comenzar
        System.out.println("Tu turno entrenador:  " + trainers[comenzar].getName());

        //verificar si tiene los dos pokemones iniciales
        while(pokemonsBattle[0] != null && pokemonsBattle[1] != null) {
            battle(sc, trainers, comenzar);
            verificationHp(sc, trainers);
            if(pokemonsBattle[0] != null && pokemonsBattle[1] != null) {
                comenzar = 1- comenzar;
            }
        }
    }

    public void battle(Scanner sc, Trainer[] trainers, int comenzar) {
        System.out.println("entrenador "+ ANSI_RED +trainers[comenzar].getName() +ANSI_RESET +" es tu turno con el pokemon " + pokemonsBattle[comenzar].getName()  );
        //imprimer los ataque de los pokemones
        for(int i = 0; i< pokemonsBattle[comenzar].getMoves().size(); i++){
            System.out.println("\t" + (i +1)  + " " +  pokemonsBattle[comenzar].getMoves().get(i).getName() + " " + pokemonsBattle[comenzar].getMoves().get(i).getPower() );
        }
        int ataque;

        //elige el ataque
        do {
            System.out.println(ANSI_RED + "elije el ataque" + ANSI_RESET);
            ataque = sc.nextInt();
            sc.nextLine();
        }while(ataque < 0 || ataque > pokemonsBattle[comenzar].getMoves().size());

        int oponente = 1 - comenzar;
        //llama a la funcion para quitarle vida al pokemon
        pokemonsBattle[comenzar].movement(pokemonsBattle[oponente], ataque-1);
    }

    //verificar si el pokemon no sea nulo y del riban tenga menor de 0
    public void verificationHp(Scanner sc, Trainer[] trainers) {
        if (pokemonsBattle[0] != null && pokemonsBattle[0].getHp() <= 0) {
            handleDefeatedPokemon(0, trainers, sc);
        } else if (pokemonsBattle[1] != null && pokemonsBattle[1].getHp() <= 0) {
            handleDefeatedPokemon(1, trainers, sc);
        }
    }

    //verificar si el entrenador escoge otro pokemon o si ya hay ganador
    private void handleDefeatedPokemon(int index, Trainer[] trainers, Scanner sc) {
        trainers[index].getPokemonTeam().remove(pokemonsBattle[index]);
        pokemonsBattle[index] = null;
        if (trainers[index].getPokemonTeam().isEmpty()) {
            win(index, trainers);
        } else {
            trainers[index].choosePokemon(pokemonsBattle, trainers, sc);
        }
    }


    //clase para dar la felicitacion al ganador
    public void win(int index, Trainer[] trainers) {
        System.out.println("\n"+ ANSI_RED +
                " ______  ______  __      __  ______  __  ______  ______  ______  __  ______  __   __  ______  ______    \n" +
                "/\\  ___\\/\\  ___\\/\\ \\    /\\ \\/\\  ___\\/\\ \\/\\__  _\\/\\  __ \\/\\  ___\\/\\ \\/\\  __ \\/\\ \"-.\\ \\/\\  ___\\/\\  ___\\   \n" +
                "\\ \\  __\\\\ \\  __\\\\ \\ \\___\\ \\ \\ \\ \\___\\ \\ \\/_/\\ \\/\\ \\  __ \\ \\ \\___\\ \\ \\ \\ \\/\\ \\ \\ \\-.  \\ \\  __\\\\ \\___  \\  \n" +
                " \\ \\_\\   \\ \\_____\\ \\_____\\ \\_\\ \\_____\\ \\_\\ \\ \\_\\ \\ \\_\\ \\_\\ \\_____\\ \\_\\ \\_____\\ \\_\\\\\"\\_\\ \\_____\\/\\_____\\ \n" +
                "  \\/_/    \\/_____/\\/_____/\\/_/\\/_____/\\/_/  \\/_/  \\/_/\\/_/\\/_____/\\/_/\\/_____/\\/_/ \\/_/\\/_____/\\/_____/ \n" +
                "                                                                                                        \n"+ ANSI_RESET);
        System.out.println(trainers[1- index].getName() + " ha ganado la batalla ");
        for(int i = 0; i< trainers[1- index].getPokemonTeam().size(); i++) {
            System.out.println("pokemon: " + trainers[1- index].getPokemonTeam().get(i).getName() + ", vida : " +  pokemonsBattle[1- index].getHp());
        }
        System.exit(0);

    }
}