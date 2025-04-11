package Menu;

import Entrenador.Trainer;
import Pokemon.Pokemon;
import java.util.ArrayList;
import java.util.Scanner;

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
            int option = 0;
            do {
                System.out.println("""

                                   SELECCIONA TUS POKEMONES
                                   1. EQUIPO ALEATORIO
                                   2. CREAR TU PROPIO EQUIPO 
                                   """);
                System.out.print("ELIGE UNA OPCION " + trainers[i].getName() + ": ");

                if (scanner.hasNextInt()) {
                    option = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el salto de línea
                //Se elije entre la creacion aleatorio del equipo y la creacion manual 
                switch (option) {
                    case 1 -> { 
                        //Pokemones random
                        trainers[i].setRandomPokemonTeam(pokemons);
                        System.out.println("ENTRENADOR : " + trainers[i].getName() + ", TUS POKEMONES SON: ");
                        for (int j = 0; j < 3; j++) {
                            Pokemon pokemon = trainers[i].getPokemonTeam().get(j);
                            System.out.println("\tPOKEMON: " + pokemon.getName() + ", ELEMENTO: " + pokemon.getType() + ", HP: " + pokemon.getHp());
                        }
                        System.out.println("\n");
                    }
                    case 2 -> { 
                        //Creacion Manual
                        System.out.println(trainers[i].getName() + ", INGRESA TUS POKEMONES: ");
                        PokemonMenu.pokemonMenu(scanner, trainers[i]);
                    }
                    default -> {
                        System.out.println("Opción inválida. Intenta de nuevo.");
                    }
                }
                } else {
                    System.out.println("Debes ingresar un número.");
                    scanner.nextLine(); // limpiar entrada inválida
                }
            } while (option != 1 && option != 2);
        }

        // depues de que cada entrenador tenga sus pokemones vamos a comezar la batalla
        BattleMenu battle = new BattleMenu();
        battle.battleBegins(scanner, trainers);


    }
}