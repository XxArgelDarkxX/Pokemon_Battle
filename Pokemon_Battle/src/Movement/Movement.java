package Movement;

import java.util.Random;

public class Movement {
    Random random = new Random();

    public enum Type {
        FISICO, ESPECIAL
    };
    private String name;
    private Type type;
    private int power;

    public Movement(){}

    public Movement(String name, Type type, int power) {
        this.name = name;
        this.type = type;
        this.power = power;
    }

    /*
     *
    
    public String setMove(){
        return getType().values()[random.nextInt(1, 2)].name();
    }
    */

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
    public int getPower() {
        return power;
    }
    public void setPower(int power) {
        this.power = power;
    }

    
}
