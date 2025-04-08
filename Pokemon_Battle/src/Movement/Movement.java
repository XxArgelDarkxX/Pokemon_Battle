package Movement;

public class Movement {
    public enum Type {
        FISICO, ESPECIAL
    };
    private String name;
    public Type type;
    private byte power;

    public Movement(){}

    public Movement(String name, String type, byte power) {
        this.name = name;
        this.type = Type.valueOf(type.toUpperCase());
        this.power = power;
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
    public byte getPower() {
        return power;
    }
    public void setPower(byte power) {
        this.power = power;
    }

    
}
