package obligatorio;

import java.io.IOException;
import java.util.HashMap;

public class ReferenceMonitor {

    private ObjectManager obManager;
    static String resultLine;

    static HashMap<String, String> runManager = new HashMap<String, String>();

    public ReferenceMonitor() {
        this.obManager = new ObjectManager();
        runManager.put("hal", "temp");
        runManager.put("lyle", "temp");
    }

    public static HashMap<String, String> getRunManager() {
        return runManager;
    }

    public void createNewObject(String name, SecurityLevel level) {
        Obj o = new Obj(name, level);
        obManager.addObject(o);
    }

    public ObjectManager getObManager() {
        return obManager;
    }

    public static String getResultLine() {
        return resultLine;
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

    static void executeDestroy(InstructionObject instr) {
        String instructionSubject = instr.getSubject();
        String instructionObj = instr.getObject();

        Subject subject = SecureSystem.getSubjectManager().get(instructionSubject);
        Obj obj = ObjectManager.getObjectManager().get(instructionObj);

        if (SecurityLevelManager.canWrite(subject.getLevel(), obj.getLevel())) {
            ObjectManager.destroy(instr);
        } else {
            System.out.println("Invalid destroy instruction");
        }
    }

    void executeCreate(InstructionObject instr) {
        String subj = instr.getSubject();
        Subject subject = SecureSystem.getSubjectManager().get(subj);
        Obj o = new Obj(instr.getObject(), subject.getLevel());
        getObManager().addObject(o);
    }

    static void executeRun(InstructionObject instr) throws IOException {
        String subj = instr.getSubject();
        Subject subject = SecureSystem.getSubjectManager().get(subj);
        int temp = subject.getTemp();

        String curBit = runManager.get(subj);

        // If first bit for the byte
        if (curBit.equals("temp")) {
            if (temp != 0) {
                curBit = "1";
                runManager.put(instr.getSubject(), curBit);
            } else {
                curBit = "0";
                runManager.put(instr.getSubject(), curBit);
            }
        } // Otherwise, make sure less than 8 bits
        else if (curBit.length() < 8) {
            if (temp != 0) {
                curBit = curBit.concat("1");
                runManager.put(instr.getSubject(), curBit);
            } else {
                curBit = curBit.concat("0");
                runManager.put(instr.getSubject(), curBit);
            }
        }

        // If 8 bits, we have a byte so make that the result string
        if (curBit.length() == 8) {
            resultLine = curBit;
            int charTemp = Integer.parseInt(resultLine, 2);
            resultLine = new Character((char) charTemp).toString();
        }

    }

}
