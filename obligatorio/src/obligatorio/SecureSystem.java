package obligatorio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SecureSystem {

    private static Scanner scan = new Scanner(System.in);
    private static InstructionObject instructionObject = new InstructionObject();

    public static void main(String[] args) throws FileNotFoundException, IOException {

        try {
            String filePath = scan.nextLine();
            BufferedReader in = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = in.readLine()) != null) {
                ManageCommands(line);
            }
            in.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void ManageCommands(String line) {
        try {
            instructionObject.ManageInstruction(line);
        } catch (BadInstruction e) {
            System.out.println("Invalid command " + e.getMessage());
        }
    }

}
