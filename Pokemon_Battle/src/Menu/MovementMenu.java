package Menu;

import Movement.Movement;
import Movement.Movement.Type;
import java.util.Random;
import java.util.Scanner;

public class MovementMenu {


    Random random = new Random();
    Movement movement = new Movement();

    public static void movementkMenu() throws Exception {

        Scanner scanner = new Scanner(System.in);
        int numMovements = 4;
        Movement[] movements = new Movement[numMovements];
        

        for(int i=0; i<numMovements; i++){
            movements[i] = new Movement();
            System.out.println("\n" + "INGRESA LOS MOVIMIENTOS DE TU POKEMON" + "\n");
            System.out.print("INGRESA EL NOMBRE DE TU MOVIMIENTO " + (i + 1) + "\n");
            String nameMovement = scanner.nextLine();
            scanner.nextLine();
            movements[i].setName(nameMovement);

            System.out.println("\n" + "INGRESA EL TIPO DE TU MOVIMIENTO" + "\n");
            System.out.println("1. FISICO\n 2. ESPECIAL\n"); //Mostramos las opciones
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1:
                    movements[i].setType(Type.FISICO);
                    break;
                case 2:
                    movements[i].setType(Type.ESPECIAL);
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }

            System.out.println("\n" + "INGRESA EL PODER DE TU MOVIMIENTO" + "\n");
            System.out.print("MOVIMIENTO " + (i + 1) + ":\t");
            int value ;
            boolean flag;
            do { 
                value = scanner.nextInt();
                if (value < 0 || value > 350) {
                    System.out.println("El valor debe estar entre 0 y 100");
                    flag = true;
                }else{
                    movements[i].setPower(value);
                    flag = false;
                }
            } while (flag);
            


        }

    
    }

    
}
