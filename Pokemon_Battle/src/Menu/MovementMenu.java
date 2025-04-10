package Menu;

import Movement.Movement;
import Movement.Movement.Type;
import java.util.ArrayList;
import java.util.Scanner;

//esta clase es para crear tus porpios movimientos
public class MovementMenu {
    public static ArrayList<Movement> movementMenu(Scanner scanner) {
        int numMovements = 4;
        ArrayList<Movement> movements = new ArrayList<>();

        System.out.println("\nINGRESA TUS MOVIMIENTOS");

        for (int i = 0; i < numMovements; i++) {
            Movement movement = new Movement();

            System.out.print("\nINGRESA EL NOMBRE DE TU MOVIMIENTO " + (i + 1) + ": ");
            String nameMovement = scanner.nextLine();
            movement.setName(nameMovement);

            // Validar tipo de movimiento
            boolean validType = false;
            while (!validType) {
                try {
                    System.out.println("""
                        
                        INGRESA EL TIPO DE TU MOVIMIENTO
                        1. FISICO
                        2. ESPECIAL
                        """);
                    int option = scanner.nextInt();
                    scanner.nextLine(); // limpiar el buffer

                    if (option == 1) {
                        movement.setType(Type.FISICO);
                        validType = true;
                    } else if (option == 2) {
                        movement.setType(Type.ESPECIAL);
                        validType = true;
                    } else {
                        System.out.println("Opción no válida. Intenta de nuevo.");
                    }
                } catch (Exception e) {
                    System.out.println("Entrada inválida. Debes ingresar un número.");
                    scanner.nextLine(); // limpiar el buffer en caso de error
                }
            }

            // Validar poder del movimiento
            boolean validPower = false;
            while (!validPower) {
                try {
                    System.out.print("INGRESA EL PODER DE TU MOVIMIENTO (0 - 100): ");
                    int value = scanner.nextInt();
                    scanner.nextLine(); // limpiar el buffer

                    if (value >= 0 && value <= 100) {
                        movement.setPower((byte) value);
                        validPower = true;
                    } else {
                        System.out.println("El valor debe estar entre 0 y 100.");
                    }
                } catch (Exception e) {
                    System.out.println("Entrada inválida. Debes ingresar un número.");
                    scanner.nextLine(); // limpiar el buffer
                }
            }

            movements.add(movement);
            System.out.println("Movimiento registrado: " + movement.getName() + "\n");
        }
        return movements;
    }
}
