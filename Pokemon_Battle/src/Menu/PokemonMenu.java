package Menu;

import Data.Data;
import Entrenador.Trainer;
import Pokemon.Pokemon;
import java.util.Scanner;

public class PokemonMenu {
    public static void pokemonMenu(Scanner scanner, Trainer trainers) throws Exception {

        //definir la cantidad
        int numPokemons = 3;
        
        boolean flag;
        Pokemon[] pokemons = new Pokemon[numPokemons];
        int option ;
        for(int i=0; i<numPokemons; i++){
            //Ingresar el nombre
            pokemons[i] = new Pokemon();
            System.out.println("\nINGRESA EL NOMBRE DEL POKEMON\n");
            System.out.print("POKEMON " + (i + 1) + ":\t");
            String namePokemon = scanner.next();
            pokemons[i].setName(namePokemon);
            //Ingresar el tipo
            System.out.println("\nINGRESE EL ELEMENTO DEL POKEMON ");
            System.out.println(" 1. FUEGO\n 2. AGUA\n 3. PLANTA\n 4. TIERRA\n"); //Mostramos las opciones
            
            //legimos el tipo de pokemon
            do{
                flag = false;
                    option = scanner.nextInt();
                    switch (option) {
                        case 1 -> pokemons[i].setType(Pokemon.Type.FUEGO);
                        case 2 -> pokemons[i].setType(Pokemon.Type.AGUA);
                        case 3 -> pokemons[i].setType(Pokemon.Type.PLANTA);
                        case 4 -> pokemons[i].setType(Pokemon.Type.TIERRA);
                        default -> {System.out.println("Opcion no valida");
                            flag = true;}
                    }
            }while(flag);

            //ingresamos el hp
            do {
                
                try{
                    short hp;
                    System.out.println("\nINGRESA LA VIDA DEL POKEMON\n");
                    System.out.print("POKEMON " + (i + 1) + ":\t");
                    hp = scanner.nextShort();
                    if(hp<=0 || hp>350){
                        flag = true;
                    }else{
                        pokemons[i].setHp(hp);
                        flag = false;
                    }
                }catch(Exception e){
                    System.out.println("ingrese un valor entre 1 y 350 de vida");
                    flag = true;
                    scanner.next();

                }
            } while (flag);
            System.out.println("""

                               Selecciona los movimientos de tu Pokemon
                               1. MOVIMIENTO ALEATORIO
                               2. CREAR MOVIMIENTOS
                               """);
            do{
                flag = false;
                option = scanner.nextInt();
                switch (option) {
                    case 1 -> pokemons[i].setRandomMoves(Data.getMoves(pokemons[i].getType()));
                    case 2 -> pokemons[i].setMoves(MovementMenu.movementMenu(scanner));
                    default -> {System.out.println("Opcion no valida");
                        flag = true;}
                }
            }while(flag);
            trainers.getPokemonTeam().add(pokemons[i]);
        }
    }
}
