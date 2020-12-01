package obligatorio;

public class Obj {

    private String name;
    private int value;
    private SecurityLevel level;

    public Obj(String name, SecurityLevel level) {
        this.name = name;
        this.level = level;
        this.value = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
