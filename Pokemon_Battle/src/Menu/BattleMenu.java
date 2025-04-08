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

        for(int i = 0; i < trainers.length; i++) {
            trainers[i].choosePokemon(pokemonsBattle, trainers, sc);
        }
        System.out.println("\n\n______VAMOS A COMENZAR LA BATALLA______\n");
        Random random = new Random();
        int comenzar = random.nextInt(0, 1);
        System.out.println("comenzara el jugador " + trainers[comenzar].getName());
        while(pokemonsBattle[0] != null && pokemonsBattle[1] != null) {
            battle(sc, trainers, comenzar);
            verificationHp(sc, trainers);
            if(pokemonsBattle[0] != null && pokemonsBattle[1] != null) {
                comenzar = 1- comenzar;
            }
        }
    }

    public void battle(Scanner sc, Trainer[] trainers, int comenzar) {
        System.out.println("entrenador "+trainers[comenzar].getName() +" es tu turno");
        for(int i = 0; i< pokemonsBattle[comenzar].getMoves().size(); i++){
            System.out.println(i + " " +  pokemonsBattle[comenzar].getMoves().get(i).getName() + " " + pokemonsBattle[comenzar].getMoves().get(i).getPower() );
        }
        int ataque;

        do {
            System.out.println("elije el ataque");
            ataque = sc.nextInt();
        }while(ataque <0 || ataque > pokemonsBattle[comenzar].getMoves().size());

        int oponente = 1 - comenzar;
        short damage = pokemonsBattle[comenzar].getMoves().get(ataque).getPower();
        short nuevoHp = (short)(pokemonsBattle[comenzar].getHp()- damage);
        pokemonsBattle[oponente].setHp(nuevoHp);
        System.out.println(pokemonsBattle[comenzar].getName() + " atacó con " + pokemonsBattle[comenzar].getMoves().get(ataque).getName() + " (" + damage + " de daño)");
    }

    public void verificationHp(Scanner sc , Trainer[] trainers) {
        Trainer trainer = new Trainer();
        if(pokemonsBattle[0].getHp() <= 0 && pokemonsBattle[1] != null) {
            trainers[0].getPokemonTeam().remove(pokemonsBattle[0]);
            if(trainers[0].getPokemonTeam().isEmpty()){
                System.out.println(trainers[1].getName() + " ha ganado la batalla ");
            }
            pokemonsBattle[0] = null;
            trainer.choosePokemon(pokemonsBattle, trainers, sc);

        }else if(pokemonsBattle[1].getHp() <= 0 && pokemonsBattle[0] != null) {
            trainers[1].getPokemonTeam().remove(pokemonsBattle[1]);
            if(trainers[1].getPokemonTeam().isEmpty()){
                System.out.println(trainers[0].getName() + " ha ganado la batalla ");
            }
            pokemonsBattle[1] = null;
            trainer.choosePokemon(pokemonsBattle, trainers, sc);
        }
    }
}
