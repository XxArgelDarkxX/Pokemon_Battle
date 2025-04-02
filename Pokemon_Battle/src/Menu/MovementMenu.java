package Menu;

import Movement.Movement;
import Movement.Movement.Type;
import java.util.Random;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class MovementMenu {
    Scanner scanner;
    Movement movement = new Movement();
    Random random = new Random();
    
    //metodo para usar scanner
    public MovementMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public static void movementMenu(Scanner scanner) throws Exception {
        int numMovements = 4;
        Movement[] movements = new Movement[numMovements];        

        //Pedir informacion por consola
        for(int i=0; i<numMovements; i++){
            movements[i] = new Movement();
            System.out.print("\nINGRESA EL NOMBRE DE TU MOVIMIENTO " + (i + 1) + ": ");
            String nameMovement = scanner.nextLine();
            scanner.nextLine();
            movements[i].setName(nameMovement);

            do{
            System.out.println("\nINGRESA EL TIPO DE TU MOVIMIENTO\n");
            System.out.println("1. FISICO\n2. ESPECIAL\n"); //Mostramos las opciones
            int option = scanner.nextInt();
            scanner.nextLine();
            //Resive las opciones y verifica que sea valida
                if (option == 1) {
                    movements[i].setType(Type.FISICO);
                    break; // Sale del bucle si la opción es válida
                } else if (option == 2) {
                    movements[i].setType(Type.ESPECIAL);
                    break; // Sale del bucle si la opción es válida
                } else {
                    JOptionPane.showMessageDialog(null, "Opcion no valida, vuelve a ingresar", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }while(true);

        System.out.println("\nINGRESA EL PODER DE TU MOVIMIENTO\n");
        System.out.print("MOVIMIENTO " + (i + 1) + ":\t");

        int value;
        boolean flag = true;  // Inicializar flag en true

        do {
            try {
                value = scanner.nextInt();
                
                if (value < 0 || value > 100) {
                    System.out.println("El valor debe estar entre 0 y 100"); //imprime un mensaje si la informacion ingresada es erronea
                } else {
                    movements[i].setPower((byte) value);
                    flag = false;  // Salir del bucle si el valor es válido
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Debes ingresar un número.");
                scanner.next();  // Limpiar la entrada incorrecta para evitar bucles infinitos
            }
        } while (flag);

        }
    }

    
}