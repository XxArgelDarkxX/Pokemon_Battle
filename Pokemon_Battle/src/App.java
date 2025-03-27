import Menu.TrainerMenu;
import Data.Data;
import Pokemon.Pokemon;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Data.initializeData();
        ArrayList<Pokemon> pokemonList = Data.getPokemons();

        Scanner scanner = new Scanner(System.in);
        TrainerMenu.trainerMenu(scanner, pokemonList);
        scanner.close();
    }
}
