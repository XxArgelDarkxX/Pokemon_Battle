package Menu;

import Pokemon.Pokemon;
import java.util.Scanner;

public class PokemonMenu {

    public static void pokemonMenu() throws Exception {

        Scanner scanner = new Scanner(System.in);
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
            System.out.println("1. FUEGO\n 2. AGUA\n 3. PLANTA\n 4. TIERRA\n"); //Mostramos las opciones
            
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
                    short hp = 0;
                    System.out.println("\nINGRESA LA VIDA DEL POKEMON\n");
                    System.out.print("POKEMON " + (i + 1) + ":\t");
                    hp = scanner.nextShort();
                    if(hp>350){
                        flag = true;
                    }else{
                        pokemons[i].setHp(hp);
                        flag = false;
                    }
                }catch(Exception e){
                    System.out.println("engrese un valor menor o igaul a 350 de vida pendejo");
                    flag = true;
                    scanner.next();

                }
            } while (flag);

            //ingresamos los movimientos
            System.out.println("\nINGRESA LOS MOVIMIENTOS DE TU POKEMON\n");
            MovementMenu.movementkMenu();










            //pokemons[i].setMoves(movement.setMove());




        }




        scanner.close();
    }
}
