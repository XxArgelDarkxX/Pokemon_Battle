import java.util.Scanner;

import javax.swing.JOptionPane;

import Entrenador.Trainer;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Trainer trainer1 = new Trainer();
        Trainer trainer2 = new Trainer();

        System.out.println("INGRESA EL NOMBRE");
        System.out.print("\n" + "ENTRENADOR 1: ");
        String name1 = scanner.nextLine();
        trainer1.setName(name1);

        System.out.print("\n" + "ENTRENADOR 2: ");
        String name2 = scanner.nextLine();
        trainer2.setName(name2);

        int option1;
        do {
            System.out.println("\n" + "SELECCIONA TUS POKEMONES" + "\n" + " 1. EQUIPO ALEATORIO" + "\n" + "2. CREAR TU PROPIO EQUIPO ");
            System.out.println("\n" + "ELIGE UNA OPCION " + trainer1.getName() + ": ");
            option1 = scanner.nextInt();
            scanner.nextLine(); 

            if (option1 == 1) {
                System.out.println("TUS POKEMONES SON: ");
            } else if (option1 == 2) {
                System.out.println("INGRESA TUS POKEMONES: ");
            } else {
                JOptionPane.showMessageDialog(null, "Opcion no valida", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } while (option1 != 1 && option1 != 2); 

        int option2;
        do {
            System.out.println("\n" + "SELECCIONA TUS POKEMONES" + "\n" + " 1. EQUIPO ALEATORIO" + "\n" + "2. CREAR TU PROPIO EQUIPO ");
            System.out.println("\n" + "ELIGE UNA OPCION " + trainer2.getName() + ": ");
            option2 = scanner.nextInt();
            scanner.nextLine(); 

            if (option2 == 1) {
                System.out.println("TUS POKEMONES SON: ");
            } else if (option2 == 2) {
                System.out.println("INGRESA TUS POKEMONES: ");
            } else {
                JOptionPane.showMessageDialog(null, "Opcion no valida", "Advertencia", JOptionPane.WARNING_MESSAGE);
            }
        } while (option2 != 1 && option2 != 2); 

        scanner.close();

    }
}
