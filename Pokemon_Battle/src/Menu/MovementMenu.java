package Menu;

import Movement.Movement;
import Movement.Movement.Type;
import java.util.ArrayList;
import java.util.Scanner;

public class MovementMenu {
    public static ArrayList<Movement> movementMenu(Scanner scanner) throws Exception {
        int numMovements = 4;
        ArrayList<Movement> movements = new ArrayList<>();
        
        System.out.println("\nINGRESA TUS MOVIMIENTOS");
        for(int i=0; i<numMovements; i++){
            Movement movement = new Movement();
            System.out.print("\nINGRESA EL NOMBRE DE TU MOVIMIENTO " + (i + 1) + "\n");
            String nameMovement = scanner.nextLine();
            scanner.nextLine();
            movement.setName(nameMovement);

            System.out.println("""

                               INGRESA EL TIPO DE TU MOVIMIENTO
                               """);
            System.out.println("1. FISICO\n 2. ESPECIAL\n"); //Mostramos las opciones
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 1 -> movement.setType(Type.FISICO);
                case 2 -> movement.setType(Type.ESPECIAL);
                default -> System.out.println("Opcion no valida");
            }

            System.out.println("""

                               INGRESA EL PODER DE TU MOVIMIENTO
                               """);
            System.out.print("MOVIMIENTO " + (i + 1) + ":\t");
            int value ;
            boolean flag;
            do { 
                value = scanner.nextInt();
                if (value < 0 || value > 100) {
                    System.out.println("El valor debe estar entre 0 y 100");
                    flag = true;
                }else{
                    movement.setPower((byte)value);
                    flag = false;
                }
            } while (flag);
            movements.add(movement);
            System.out.println(movement.getName());
        }
        return movements;
    }
}
