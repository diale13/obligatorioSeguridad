package obligatorio;

public class Subject {

    private String name;
    private int temp;
    private SecurityLevel level;

    public Subject(String name, SecurityLevel level) {
        this.name = name;
        this.level = level;
        this.temp = 0;
    }

    public String getName() {
        return name;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

}
