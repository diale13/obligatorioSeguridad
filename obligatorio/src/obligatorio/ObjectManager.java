package obligatorio;

import java.util.HashMap;

public class ObjectManager {
    
    static HashMap<String, Obj> objectMap = new HashMap<String, Obj>();
    
    public static HashMap<String, Obj> getObjectManager() {
        return objectMap;
    }
    
    public static void addObject(Obj obj) {
        objectMap.put(obj.getName(), obj);
    }
    
    static void read(InstructionObject instr) {
        String subj = instr.getSubject();
        String obj = instr.getObject();
        
        Subject subjectThatCanRead = SecureSystem.getSubjectManager().get(subj);
        subjectThatCanRead.setTemp(objectMap.get(obj).getValue());
    }
    
    static void write(InstructionObject instr) {
        int val = instr.getValue();
        String obj = instr.getObject();
        objectMap.get(obj).setValue(val);
    }
    
    static void bad(InstructionObject instr) {
        String subj = instr.getSubject();
        Subject subjectThatShouldNotRead = SecureSystem.getSubjectManager().get(subj);
        subjectThatShouldNotRead.setTemp(0);
    }
    
}
