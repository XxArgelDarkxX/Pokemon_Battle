package Menu;

import Entrenador.Trainer;
import Pokemon.Pokemon;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class TrainerMenu {
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";
    public static void trainerMenu(Scanner scanner, ArrayList<Pokemon> pokemons) throws Exception {

        int numTrainers = 2;
        Trainer[] trainers = new Trainer[numTrainers];

        //esta pidiendo los nombres de los entrenadores
        for(int i=0; i<numTrainers; i++){
            trainers[i] = new Trainer();
            System.out.println("\nINGRESA EL NOMBRE\n");
            System.out.print("ENTRENADOR " + (i + 1) + ": ");
            String name = scanner.nextLine();
            trainers[i].setName(name);
        }

        //elejir si como quiere elejir el equipo pokemon
        for(int i=0; i<numTrainers; i++){
            int option;
            do {
                System.out.println("""

                                   SELECCIONA TUS POKEMONES
                                   1. EQUIPO ALEATORIO
                                   2. CREAR TU PROPIO EQUIPO 
                                   """);
                System.out.print("ELIGE UNA OPCION " + trainers[i].getName() + ": " );
                option = scanner.nextInt();
                scanner.nextLine();

                //el switch para mirar ver que tipo de pokemon
                switch (option) {
                    case 1 -> { //pokemones random
                        trainers[i].setRandomPokemonTeam(pokemons);
                        System.out.println("ENTRENADOR : " + trainers[i].getName() + ", TUS POKEMONES SON: ");
                        for (int j = 0; j < 3; j++) {
                            System.out.println("\t" + "POKEMON: " + trainers[i].getPokemonTeam().get(j).getName() + ", ELEMENTO: " + trainers[i].getPokemonTeam().get(j).getType()
                                    + ", HP: " + trainers[i].getPokemonTeam().get(j).getHp());
                        }
                        System.out.println("\n");
                    }
                    case 2 -> { //tiene que crear los pokemones
                        System.out.println(trainers[i].getName() + ", INGRESA TUS POKEMONES: ");
                        PokemonMenu.pokemonMenu(scanner, trainers[i]);
                    }
                    default -> JOptionPane.showMessageDialog(null, "Opcion no valida", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            } while (option != 1 && option != 2);


        }

        // depues de que cada entrenador tenga sus pokemones vamos a comezar la batalla
        BattleMenu battle = new BattleMenu();
        battle.battleBegins(scanner, trainers);


    }
}
