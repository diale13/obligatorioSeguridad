package obligatorio;

import java.util.ArrayList;

public class ObjectManager {

    private ArrayList<Obj> objects;

    public ArrayList<Obj> getObjects() {
        return objects;
    }

    public void addObject(Obj obj) {
        this.objects.add(obj);
    }
}
