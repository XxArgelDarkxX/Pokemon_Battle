import Data.Data;
import Menu.TrainerMenu;
import Pokemon.Pokemon;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Data.initializeData();
        ArrayList<Pokemon> pokemonList = Data.getPokemons();

        try (Scanner scanner = new Scanner(System.in)) {
            TrainerMenu.trainerMenu(scanner, pokemonList);
        }
    }
}