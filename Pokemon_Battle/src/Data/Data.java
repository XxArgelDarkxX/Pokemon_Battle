package Data;

import Movement.Movement;
import Pokemon.Pokemon;
import java.util.ArrayList;

public class Data {
    private static final ArrayList<Movement> fireMoves = new ArrayList<>();
    private static final ArrayList<Movement> waterMoves = new ArrayList<>();
    private static final ArrayList<Movement> grassMoves = new ArrayList<>();
    private static final ArrayList<Movement> groundMoves = new ArrayList<>();
    private static final ArrayList<Pokemon> pokemons = new ArrayList<>();

    //data de los movimientos
    public static void initializeMoves() {
        // Movimientos tipo Fuego
        // Movimientos tipo Fuego
        fireMoves.clear();
        fireMoves.add(new Movement("Lanzallamas", "FISICO", (byte)90));
        fireMoves.add(new Movement("Llamarada", "ESPECIAL", (byte)85));
        fireMoves.add(new Movement("Puño Fuego", "FISICO", (byte)75));
        fireMoves.add(new Movement("Giro Fuego", "ESPECIAL", (byte)70));
        fireMoves.add(new Movement("Nitrocarga", "FISICO", (byte)65));

        // Movimientos tipo Agua
        waterMoves.clear();
        waterMoves.add(new Movement("Hidrobomba", "ESPECIAL", (byte)95));
        waterMoves.add(new Movement("Surf", "ESPECIAL", (byte)85));
        waterMoves.add(new Movement("Acua Cola", "FISICO", (byte)80));
        waterMoves.add(new Movement("Pistola Agua", "ESPECIAL", (byte)65));
        waterMoves.add(new Movement("Cascada", "FISICO", (byte)75));

        // Movimientos tipo Planta
        grassMoves.clear();
        grassMoves.add(new Movement("Rayo Solar", "ESPECIAL", (byte)95));
        grassMoves.add(new Movement("Hoja Afilada", "FISICO", (byte)85));
        grassMoves.add(new Movement("Latigazo", "FISICO", (byte)80));
        grassMoves.add(new Movement("Bomba Germen", "ESPECIAL", (byte)75));
        grassMoves.add(new Movement("Drenadoras", "ESPECIAL", (byte)70));

        // Movimientos tipo Tierra
        groundMoves.clear();
        groundMoves.add(new Movement("Terremoto", "FISICO", (byte)95));
        groundMoves.add(new Movement("Excavar", "FISICO", (byte)85));
        groundMoves.add(new Movement("Tierra Viva", "ESPECIAL", (byte)80));
        groundMoves.add(new Movement("Bofetón Lodo", "ESPECIAL", (byte)75));
        groundMoves.add(new Movement("Avalancha", "FISICO", (byte)70));
    }

    //
    public static void initializePokemons() {
        // Pokémon tipo Fuego
        ArrayList<Movement> charmanderMoves = new ArrayList<>(fireMoves.subList(0, 4));
        ArrayList<Movement> flareonMoves = new ArrayList<>(fireMoves.subList(1, 5));
        pokemons.add(new Pokemon("Charizard", "FUEGO", (short)282, charmanderMoves));
        pokemons.add(new Pokemon("Flareon", "FUEGO", (short)198, flareonMoves));

        // Pokémon tipo Agua
        ArrayList<Movement> squirtleMoves = new ArrayList<>(waterMoves.subList(0, 4));
        ArrayList<Movement> vaporeonMoves = new ArrayList<>(waterMoves.subList(1, 5));
        pokemons.add(new Pokemon("Blastoise", "AGUA", (short)292, squirtleMoves));
        pokemons.add(new Pokemon("Vaporeon", "AGUA", (short)214, vaporeonMoves));

        // Pokémon tipo Planta
        ArrayList<Movement> bulbasaurMoves = new ArrayList<>(grassMoves.subList(0, 4));
        ArrayList<Movement> leafeonMoves = new ArrayList<>(grassMoves.subList(1, 5));
        pokemons.add(new Pokemon("Venasaur", "PLANTA", (short)271, bulbasaurMoves));
        pokemons.add(new Pokemon("Leafeon", "PLANTA", (short)194, leafeonMoves));

        // Pokémon tipo Tierra
        ArrayList<Movement> sandslashMoves = new ArrayList<>(groundMoves.subList(0, 4));
        ArrayList<Movement> nidokingMoves = new ArrayList<>(groundMoves.subList(1, 5));
        ArrayList<Movement> hippowdonMoves = new ArrayList<>(groundMoves.subList(0, 4));
        ArrayList<Movement> rhyperiorMoves = new ArrayList<>(groundMoves.subList(1, 5));
        pokemons.add(new Pokemon("Sandslash", "TIERRA", (short)324, sandslashMoves));
        pokemons.add(new Pokemon("Nidoking", "TIERRA", (short)344, nidokingMoves));
        pokemons.add(new Pokemon("Hippowdon", "TIERRA", (short)350, hippowdonMoves));
        pokemons.add(new Pokemon("Rhyperior", "TIERRA", (short)350, rhyperiorMoves));
    }
    public static void initializeData() {
        initializeMoves();
        initializePokemons();
    }
    public static ArrayList<Pokemon> getPokemons() {
        return pokemons;
    }
    public static ArrayList<Movement> getMoves(Pokemon.Type type) {
        initializeMoves();
        switch (type) {
            case FUEGO -> {
                return fireMoves;
            }
            case AGUA -> {
                return waterMoves;
            }
            case PLANTA -> {
                return grassMoves;
            }
            case TIERRA -> {
                return groundMoves;
            }
            default -> throw new IllegalArgumentException("Tipo de Pokemon Desconocido: " + type);
        }
    }
}