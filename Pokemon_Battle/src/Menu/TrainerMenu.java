package Menu;

import Entrenador.Trainer;
import Pokemon.Pokemon;

import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class TrainerMenu {
    Scanner scanner;
    

    public TrainerMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public static void trainerMenu(Scanner scanner, ArrayList<Pokemon> pokemons) throws Exception {
        
        int numTrainers = 2;
        Trainer[] trainers = new Trainer[numTrainers];

        //bucle para solicitar el nombre del entrenador
        for(int i=0; i<numTrainers; i++){
            trainers[i] = new Trainer();
            System.out.println("\nINGRESA EL NOMBRE\n");
            System.out.print("ENTRENADOR " + (i + 1) + ": ");
            String name = scanner.nextLine();
            trainers[i].setName(name);
        }

        //bucle para seleccionar tu equipo de pokemon
        for(int i=0; i<numTrainers; i++){
            int option;
            do {
                System.out.println("\nSELECCIONA TUS POKEMON\n"+
                "1. EQUIPO ALEATORIO\n"+
                "2. CREAR TU PROPIO EQUIPO \n");
                System.out.print("ELIGE UNA OPCION " + trainers[i].getName() + ": " );
                option = scanner.nextInt();
                scanner.nextLine();

                //resive la opcion elegida y la valida
                switch (option) {
                    case 1:
                    //le da al usuario los pokemones aleatorios 
                        trainers[i].setRandomPokemonTeam(pokemons);
                        System.out.println(trainers[i].getName() + ", TUS POKEMON SON: ");
                        for (int j = 0; j < 3; j++) {
                            System.out.println(trainers[i].getPokemonTeam().get(j).getName());
                        }
                        break;
                    case 2:
                        System.out.println(trainers[i].getName() + ", INGRESA TUS POKEMON: ");
                        PokemonMenu pokemonMenu = new PokemonMenu(scanner);
                        //llama al mennu pokemon para pedir los datos de estos
                        pokemonMenu.pokemonMenu(scanner);
                        System.out.println(trainers[i].getName() + ", TUS POKEMON SON: ");
                        //muestra los pokemon creados por el usuario
                        pokemonMenu.mostrarPokemon();
                        break;
                    default:
                    //muestra un mensaje de advertencia 
                        JOptionPane.showMessageDialog(null, "Opcion no valida", "Advertencia", JOptionPane.WARNING_MESSAGE);
                        break;
                }
            } while (option != 1 && option != 2);
        }
    }
}