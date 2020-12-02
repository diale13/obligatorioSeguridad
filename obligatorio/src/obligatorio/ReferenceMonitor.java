package obligatorio;

public class ReferenceMonitor {

    private ObjectManager obManager;

    public ReferenceMonitor() {
        this.obManager = new ObjectManager();
    }

    public void createNewObject(String name, SecurityLevel level) {
        Obj o = new Obj(name, level);
        obManager.addObject(o);
    }

    public ObjectManager getObManager() {
        return obManager;
    }

    static void executeWrite(InstructionObject instr) {
        String instructionSubject = instr.getSubject();
        String instructionObj = instr.getObject();

        Subject subject = SecureSystem.getSubjectManager().get(instructionSubject);
        Obj obj = ObjectManager.getObjectManager().get(instructionObj);

        if (SecurityLevelManager.canWrite(subject.getLevel(), obj.getLevel())) {
            ObjectManager.write(instr);
        }
    }

    static void executeRead(InstructionObject instr) {
        String instructionSubject = instr.getSubject();
        String instructionObj = instr.getObject();

        Subject subject = SecureSystem.getSubjectManager().get(instructionSubject);
        Obj obj = ObjectManager.getObjectManager().get(instructionObj);

        if (SecurityLevelManager.dominates(subject.getLevel(), obj.getLevel())) {
            ObjectManager.read(instr);
        } else {
            ObjectManager.bad(instr);
        }
    }

}
