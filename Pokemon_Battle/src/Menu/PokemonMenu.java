package Menu;

import Data.Data;
import Entrenador.Trainer;
import Pokemon.Pokemon;
import java.util.Scanner;

public class PokemonMenu {
    public static void pokemonMenu(Scanner scanner, Trainer trainers) throws Exception {

        int numPokemons = 3;
        boolean flag;
        int option;
        Pokemon[] pokemons = new Pokemon[numPokemons];

        for (int i = 0; i < numPokemons; i++) {
            pokemons[i] = new Pokemon();

            // Nombre del pokemon
            System.out.println("\nINGRESA EL NOMBRE DEL POKEMON");
            System.out.print("POKEMON " + (i + 1) + ": ");
            String namePokemon = scanner.next();
            pokemons[i].setName(namePokemon);

            // Se pide el tipo del pokemon
            System.out.println("\nINGRESA EL ELEMENTO DEL POKEMON");
            System.out.println(" 1. FUEGO\n 2. AGUA\n 3. PLANTA\n 4. TIERRA");
            do {
                flag = false;
                try {
                    option = scanner.nextInt();
                    switch (option) {
                        case 1 -> pokemons[i].setType(Pokemon.Type.FUEGO);
                        case 2 -> pokemons[i].setType(Pokemon.Type.AGUA);
                        case 3 -> pokemons[i].setType(Pokemon.Type.PLANTA);
                        case 4 -> pokemons[i].setType(Pokemon.Type.TIERRA);
                        default -> {
                            System.out.println("Opción no válida. Intenta de nuevo.");
                            flag = true;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Entrada inválida. Debes ingresar un número.");
                    scanner.next(); // limpiar entrada
                    flag = true;
                }
            } while (flag);

            // Se elije la cantidad de puntos de vida del pokemon
            do {
                flag = false;
                try {
                    System.out.println("\nINGRESA LA VIDA DEL POKEMON (1 - 350)");
                    System.out.print("POKEMON " + (i + 1) + ": ");
                    short hp = scanner.nextShort();
                    if (hp <= 0 || hp > 350) {
                        System.out.println("La vida debe estar entre 1 y 350.");
                        flag = true;
                    } else {
                        pokemons[i].setHp(hp);
                    }
                } catch (Exception e) {
                    System.out.println("Entrada inválida. Debes ingresar un número.");
                    scanner.next(); // limpiar entrada
                    flag = true;
                }
            } while (flag);

            // Movimientos del pokemon
            System.out.println("""
                
                SELECCIONA LOS MOVIMIENTOS DE TU POKEMON
                1. MOVIMIENTO ALEATORIO
                2. CREAR MOVIMIENTOS
                """);
            do {
                flag = false;
                try {
                    option = scanner.nextInt();
                    scanner.nextLine(); // limpiar el buffer
                    switch (option) {
                        case 1 -> pokemons[i].setRandomMoves(Data.getMoves(pokemons[i].getType())); //Random
                        case 2 -> pokemons[i].setMoves(MovementMenu.movementMenu(scanner)); // Creacion manual
                        default -> {
                            System.out.println("Opción no válida. Intenta de nuevo.");
                            flag = true;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Entrada inválida. Debes ingresar un número.");
                    scanner.next(); // limpiar entrada
                    flag = true;
                }
            } while (flag);

            // Añadir al equipo del entrenador
            trainers.getPokemonTeam().add(pokemons[i]);
        }
    }
}
