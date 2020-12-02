package obligatorio;

import java.util.HashMap;

public class ObjectManager {

    static HashMap<String, Obj> objectMap = new HashMap<String, Obj>();

    public static HashMap<String, Obj> getObjectMap() {
        return objectMap;
    }
}
