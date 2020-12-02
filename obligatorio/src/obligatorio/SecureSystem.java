package obligatorio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SecureSystem {

    static Scanner scan = new Scanner(System.in);
    static ReferenceMonitor referenceMonitor = new ReferenceMonitor();
    static HashMap<String, Subject> subjectMap = new HashMap<String, Subject>();

    void createSubject(String name, SecurityLevel level) {
        Subject subjectToCreate = new Subject(name, level);
        subjectMap.put(name, subjectToCreate);
    }

    public void handleCommands() {
        try {
            String filePath = scan.nextLine();
            BufferedReader in = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = in.readLine()) != null) {
                manageLine(line);
            }
            in.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void manageLine(String line) {
        try {
            InstructionObject instr = new InstructionObject(line);
        } catch (BadInstruction e) {
            System.out.println("BAD INSTRUCTION");
        }
    }

    public static ReferenceMonitor getReferenceMonitor() {
        return referenceMonitor;
    }

    public static HashMap<String, Subject> getSubjectManager() {
        return subjectMap;
    }

}
