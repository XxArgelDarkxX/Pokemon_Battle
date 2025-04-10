package Menu;

import Entrenador.Trainer;
import Pokemon.Pokemon;
import java.util.ArrayList;
import java.util.Scanner;

public class TrainerMenu {
    public static void trainerMenu(Scanner scanner, ArrayList<Pokemon> pokemons) throws Exception {

        int numTrainers = 2;
        Trainer[] trainers = new Trainer[numTrainers];

        for(int i=0; i<numTrainers; i++){
            trainers[i] = new Trainer();
            System.out.println("\nINGRESA EL NOMBRE\n");
            System.out.print("ENTRENADOR " + (i + 1) + ": ");
            String name = scanner.nextLine();
            trainers[i].setName(name);
        }
        for (int i = 0; i < numTrainers; i++) {
            int option = 0;

            while (option != 1 && option != 2) {
                System.out.println("""

                                   SELECCIONA TUS POKEMONES
                                   1. EQUIPO ALEATORIO
                                   2. CREAR TU PROPIO EQUIPO 
                                   """);
                System.out.print("ELIGE UNA OPCION " + trainers[i].getName() + ": ");

                if (scanner.hasNextInt()) {
                    option = scanner.nextInt();
                    scanner.nextLine(); // Limpiar el salto de línea
                    switch (option) {
                        case 1 -> {
                            trainers[i].setRandomPokemonTeam(pokemons);
                            System.out.println("ENTRENADOR : " + trainers[i].getName() + ", TUS POKEMONES SON: ");
                            for (int j = 0; j < 3; j++) {
                                Pokemon pokemon = trainers[i].getPokemonTeam().get(j);
                                System.out.println("\tPOKEMON: " + pokemon.getName() + ", ELEMENTO: " + pokemon.getType() + ", HP: " + pokemon.getHp());
                            }   System.out.println();
                        }
                        case 2 -> {
                            System.out.println(trainers[i].getName() + ", INGRESA TUS POKEMONES: ");
                            PokemonMenu.pokemonMenu(scanner, trainers[i]);
                        }
                        default -> System.out.println("Opción inválida. Intenta de nuevo.");
                    }
                } else {
                    System.out.println("Debes ingresar un número.");
                    scanner.nextLine(); // limpiar entrada inválida
                }
            }
        }


        BattleMenu battle = new BattleMenu();
        battle.battleBegins(scanner, trainers);


    }
}