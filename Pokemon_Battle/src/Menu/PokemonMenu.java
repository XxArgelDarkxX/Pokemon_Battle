package Menu;

import Pokemon.Pokemon;
import java.util.Scanner;

public class PokemonMenu {
    Scanner scanner;
    private Pokemon[] pokemons;
    private int numPokemons = 3;

    public PokemonMenu(Scanner scanner) {
        this.scanner = scanner;
        this.numPokemons = 3;
        this.pokemons = new Pokemon[numPokemons];
    }

    //menu de pokemon 
    public void pokemonMenu(Scanner scanner) throws Exception {

        boolean flag;
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
            System.out.println("1. FUEGO\n2. AGUA\n3. PLANTA\n4. TIERRA\n"); //Mostramos las opciones
            
            //elegimos el tipo de pokemon
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
                    System.out.println("Ingrese un valor menor o igual a 350 de vida pendejo");
                    flag = true;
                    scanner.next();

                }
            } while (flag);

            //ingresamos los movimientos
            System.out.println("\nINGRESA LOS MOVIMIENTOS DE TU POKEMON");
            //llama al menu de movimientos para crearlos
            MovementMenu.movementMenu(scanner);
        }
        
    }
        //Mostrar los pokemons
        public void mostrarPokemon(){
            for (int i = 0; i < numPokemons; i++) {
                System.out.println(pokemons[i].getName());
            }
        }
}