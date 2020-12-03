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
            System.out.println("Reading frome file: " + filePath);
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
            printState(instr);
        } catch (BadInstruction e) {
            System.out.println("Bad Instruction");
            printCurrentState();
        }
    }

    public static ReferenceMonitor getReferenceMonitor() {
        return referenceMonitor;
    }

    public static HashMap<String, Subject> getSubjectManager() {
        return subjectMap;
    }

    private static void printState(InstructionObject instr) {
        String instruction = instr.getInstruction();
        String subj = instr.getSubject();
        String obj = instr.getObject();

        if (instruction.equalsIgnoreCase("read")) {
            String outText = subj + " reads " + obj;
            System.out.println(outText);
        }
        if (instruction.equalsIgnoreCase("write")) {
            String outText = subj + " writes value " + instr.getValue() + " to " + obj;
            System.out.println(outText);
        }
        printCurrentState();
    }

    private static void printCurrentState() {
        System.out.println("The current state is: ");
        ArrayList<Obj> objsToPrint = new ArrayList<>();
        objsToPrint.addAll(ObjectManager.getObjectManager().values());
        for (int i = 0; i < objsToPrint.size(); i++) {
            System.out.println(objsToPrint.get(i).getName() + " has value: " + objsToPrint.get(i).getValue());
        }

        ArrayList<Subject> subjectsToPrint = new ArrayList<>();
        subjectsToPrint.addAll(subjectMap.values());
        for (int i = 0; i < subjectsToPrint.size(); i++) {
            System.out.println(subjectsToPrint.get(i).getName() + " has recently read: " + subjectsToPrint.get(i).getTemp());
        }
        System.out.println("-------------------------------------------------------------");
    }

    static void passInstructionsStatic(String[] instructions) throws BadInstruction {
        for (int i = 0; i < instructions.length; i++) {
            new InstructionObject(instructions[i]);
        }
    }
}
