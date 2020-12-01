package obligatorio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class SecureSystem {

    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException, IOException {
        InstructionObject instructionObject = new InstructionObject();

        try {
            String filePath = scan.nextLine();
            BufferedReader in = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = in.readLine()) != null) {
                System.out.println("Reading command:" + line);
                instructionObject.DoMagic(line);
            }
            in.close();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

}
