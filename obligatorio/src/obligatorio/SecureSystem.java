package obligatorio;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class SecureSystem {

    private Scanner scan = new Scanner(System.in);
    private InstructionObject instructionObject = new InstructionObject();
    private ArrayList<Subject> subjects = new ArrayList<Subject>();
    private ReferenceMonitor referenceMonitor = new ReferenceMonitor();

    void createSubject(String name, SecurityLevel level) {
        Subject subjectToCreate = new Subject(name, level);
        subjects.add(subjectToCreate);
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
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public ReferenceMonitor getReferenceMonitor() {
        return referenceMonitor;
    }

    private void manageLine(String line) {
        try {
            instructionObject.manageInstruction(line);
            instructionObject.validateSubjectAndObjects(line, subjects);
        } catch (BadInstruction e) {
            System.out.println("Invalid command " + e.getMessage());
        }
    }

}
