package Menu;

import java.util.Scanner;
import javax.swing.JOptionPane;
import Entrenador.Trainer;

public class TrainerMenu {

    public static void trainerMenu() throws Exception {
        
        Scanner scanner = new Scanner(System.in);
        int numTrainers = 2;
        Trainer[] trainers = new Trainer[numTrainers];

        for(int i=0; i<numTrainers; i++){
            trainers[i] = new Trainer();
            System.out.println("\n" + "INGRESA EL NOMBRE" + "\n");
            System.out.print("ENTRENADOR " + (i + 1) + ": ");
            String name = scanner.nextLine();
            trainers[i].setName(name);
        }

        for(int i=0; i<numTrainers; i++){
            int option;
            do {
                System.out.println("\n" + "SELECCIONA TUS POKEMONES" + "\n" + "1. EQUIPO ALEATORIO" + "\n" + "2. CREAR TU PROPIO EQUIPO " + "\n");
                System.out.print("ELIGE UNA OPCION " + trainers[i].getName() + ": " );
                option = scanner.nextInt();
                scanner.nextLine(); 
    
                if (option == 1) {
                    System.out.println(trainers[i].getName() + ", TUS POKEMONES SON: ");
                } else if (option == 2) {
                    System.out.println(trainers[i].getName() + ", INGRESA TUS POKEMONES: ");
                } else {
                    JOptionPane.showMessageDialog(null, "Opcion no valida", "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            } while (option != 1 && option != 2); 
        }

        scanner.close();
       
    }
}
