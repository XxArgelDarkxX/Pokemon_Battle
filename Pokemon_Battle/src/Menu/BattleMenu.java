package Menu;

import Entrenador.Trainer;
import Pokemon.Pokemon;
import java.util.Scanner;


public class BattleMenu {
    Pokemon[] pokemonsBattle = new Pokemon[2];
    public static void battleMenu() throws Exception {


    }

    public void battleBegins(Scanner scanner, Trainer[] trainers) {
        Trainer trainerclass = new Trainer();
        boolean flag = true;
        do{
            if(pokemonsBattle[0] == null || pokemonsBattle[1] == null) {
                trainerclass.chooseFirstPokemon(pokemonsBattle, trainers, scanner);
            }
        }while(flag);



    }
}
