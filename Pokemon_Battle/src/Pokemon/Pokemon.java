package Pokemon;
import java.util.ArrayList;

import Movement.Movement;
public class Pokemon {
    private String name;
    private enum Type {
        FUEGO, AGUA, PLANTA, TIERRA,
    }
    private Type type;
    private short hp;
    private ArrayList<Movement> moves;

    // Constructor de la clase Pokemon.
    public Pokemon(String name, String type, short hp, ArrayList<Movement> moves) {
        this.name = name;
        this.type = Type.valueOf(type);
        this.hp = hp;
        this.moves = moves;
    }

    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public Type getType() {
        return type;
    }
    
    public void setType(Type type) {
        this.type = type;
    }
    
    public short getHp() {
        return hp;
    }
    
    public void setHp(short hp) {
        this.hp = hp;
    }
    
    public ArrayList<Movement> getMoves() {
        return moves;
    }
    
    public void setMoves(ArrayList<Movement> moves) {
        this.moves = moves;
    }
    
    // Este método permite a un Pokemon atacar a otro Pokemon.
    public void movement(Pokemon target, int moveIndex) {
        Movement move = (Movement) moves.get(moveIndex);
        double effectiveness = moveEffectiveness(this.type, target.getType());
        target.setHp((short) (target.getHp() - (move.getPower() * effectiveness))); // Se resta la vida del Pokemon objetivo.
        System.out.println(this.name + " ha usado" + move.getName() + "!");
    }

    // Este método calcula la efectividad de un movimiento de un tipo de Pokemon sobre otro tipo de Pokemon.
    // El metodo es privado porque solo va a ser usado por la clase Pokemon.
    private double moveEffectiveness(Type attacker, Type defender) {
    if (attacker == Type.FUEGO && defender == Type.PLANTA) {
        return 1.3;
    } else if (attacker == Type.AGUA && (defender == Type.FUEGO || defender == Type.TIERRA)) {
        return 1.3;
    } else if (attacker == Type.PLANTA && (defender == Type.AGUA || defender == Type.TIERRA)) {
        return 1.3;
    } else if (attacker == Type.TIERRA && defender == Type.FUEGO) {
        return 1.3;
    } else {
        return 1.0;
    }
    }
}

