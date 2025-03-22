import java.util.ArrayList;

public class Pokemon {
    private String name;
    private enum Type {
        FIRE, WATER, GRASS, GROUND,
    }
    private Type type;
    private short hp;
    private ArrayList moves;

    
    public Pokemon(String name, Pokemon.Type type, short hp, ArrayList moves) {
        this.name = name;
        this.type = type;
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
    
    public ArrayList getMoves() {
        return moves;
    }
    
    public void setMoves(ArrayList moves) {
        this.moves = moves;
    }
    
    public void attack(Pokemon target, int moveIndex) {
        Move move = (Move) moves.get(moveIndex);
        double effectiveness = moveEffectiveness(this.type, target.getType());
        target.setHp((short) (target.getHp() - (move.getPower() * effectiveness)));
    }

    private double moveEffectiveness(Type attacker, Type defender) {
    if (attacker == Type.FIRE && defender == Type.GRASS) {
        return 1.3;
    } else if (attacker == Type.WATER && (defender == Type.FIRE || defender == Type.GROUND)) {
        return 1.3;
    } else if (attacker == Type.GRASS && (defender == Type.WATER || defender == Type.GROUND)) {
        return 1.3;
    } else if (attacker == Type.GROUND && defender == Type.FIRE) {
        return 1.3;
    } else {
        return 1.0;
    }
    }
}

