package Menu;

import Entrenador.Trainer;
import Pokemon.Pokemon;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

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

                switch (option) {
                    case 1 -> {
                        trainers[i].setRandomPokemonTeam(pokemons);
                        System.out.println("ENTRENADOR : " + trainers[i].getName() + ", TUS POKEMONES SON: ");
                        for (int j = 0; j < 3; j++) {
                            System.out.println("\t" + "POKEMON: " + trainers[i].getPokemonTeam().get(j).getName() + ", ELEMENTO: " + trainers[i].getPokemonTeam().get(j).getType()
                                    + ", HP: " + trainers[i].getPokemonTeam().get(j).getHp());
                        }
                        System.out.println("\n");
                    }
                    case 2 -> {
                        System.out.println(trainers[i].getName() + ", INGRESA TUS POKEMONES: ");
                        PokemonMenu.pokemonMenu(scanner, trainers[i]);
                    }
                    default -> JOptionPane.showMessageDialog(null, "Opcion no valida", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            } while (option != 1 && option != 2);


        }


        BattleMenu battle = new BattleMenu();
        battle.battleBegins(scanner, trainers);


    }
}