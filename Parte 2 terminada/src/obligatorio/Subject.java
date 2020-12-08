package obligatorio;

import java.io.IOException;

public class Subject {

    private String name;
    private int temp;
    private SecurityLevel level;

    private int mark = 0;
    private int B = 0;

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

    public SecurityLevel getLevel() {
        return level;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }

    public String run() throws IOException {
        return "";
        //DEPRECATED
    }

}
