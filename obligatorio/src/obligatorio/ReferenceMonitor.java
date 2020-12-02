package obligatorio;

public class ReferenceMonitor {

    private ObjectManager obManager;

    public ReferenceMonitor() {
        this.obManager = new ObjectManager();
    }

    public void createObject(String name, SecurityLevel level) {
        Obj o = new Obj(name, level);
        obManager.addObject(o);
    }

    public ObjectManager getObManager() {
        return obManager;
    }

    static void executeWrite(InstructionObject aThis) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    static void executeRead(InstructionObject aThis) {
        //validate security level, if is invalid read should read 0
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
