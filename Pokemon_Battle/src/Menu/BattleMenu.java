package Menu;

import Entrenador.Trainer;
import Pokemon.Pokemon;

import java.util.Random;
import java.util.Scanner;



public class BattleMenu {
    Pokemon[] pokemonsBattle = new Pokemon[2];
    public static void battleMenu() throws Exception {


    }

    public void battleBegins(Scanner sc, Trainer[] trainers) {

        //esta preguntado
        for(int i = 0; i < trainers.length; i++) {
            trainers[i].choosePokemon(pokemonsBattle, trainers, sc);
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

    public void battle(Scanner sc, Trainer[] trainers, int comenzar) {
        System.out.println("entrenador "+trainers[comenzar].getName() +" es tu turno con el pokemon " + pokemonsBattle[comenzar].getName()  );
        for(int i = 0; i< pokemonsBattle[comenzar].getMoves().size(); i++){
            System.out.println("\t" + (i +1)  + " " +  pokemonsBattle[comenzar].getMoves().get(i).getName() + " " + pokemonsBattle[comenzar].getMoves().get(i).getPower() );
        }
        int ataque;

        do {
            System.out.println("elije el ataque");
            ataque = sc.nextInt();
            sc.nextLine();
        }while(ataque < 0 || ataque > pokemonsBattle[comenzar].getMoves().size());

        //mirar si dejarlo de esta forma o llamar al metodo
        int oponente = 1 - comenzar;
        short damage = pokemonsBattle[comenzar].getMoves().get(ataque -1).getPower();
        short nuevoHp = (short)(pokemonsBattle[oponente].getHp()- damage);
        pokemonsBattle[oponente].setHp(nuevoHp);
        System.out.println(pokemonsBattle[comenzar].getName() + " atacó con " + pokemonsBattle[comenzar].getMoves().get(ataque -1).getName() + " (" + damage + " de daño)");
        System.out.println(pokemonsBattle[oponente].getName() + " hp : " + pokemonsBattle[oponente].getHp());
        Trainer traine = new Trainer();
        System.out.println(traine.getPokemonTeam().size());
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

    public void win(int index, Trainer[] trainers) {
        System.out.println("Felicitaciones");
        System.out.println(trainers[1- index].getName() + " ha ganado la batalla ");
        for(int i = 0; i< trainers[1- index].getPokemonTeam().size(); i++) {
            System.out.println("pokemon: " + trainers[1- index].getPokemonTeam().get(i).getName() + ", vida :" +  trainers[1- index].getPokemonTeam().get(i).getHp());
        }
        System.exit(0);

    }
}
