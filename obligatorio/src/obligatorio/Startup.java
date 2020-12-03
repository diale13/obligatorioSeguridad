package obligatorio;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static obligatorio.SecureSystem.scan;

public class Startup {

    static long numOfBits = 0;

    public static void main(String[] args) throws FileNotFoundException, IOException {
        SecureSystem sys = new SecureSystem();

        SecurityLevel low = SecurityLevel.LOW;
        SecurityLevel medium = SecurityLevel.MEDIUM;
        SecurityLevel high = SecurityLevel.HIGH;

        sys.createSubject("lyle", low);
        sys.createSubject("moe", medium);
        sys.createSubject("hal", high);

        try {
            String filePath = scan.nextLine();
            System.out.println("Reading frome file: " + filePath);
            Path path = Paths.get(filePath);
            File infile = path.toFile();
            Scanner sc = new Scanner(infile);
            String fileName = infile.getName() + ".out";
            String title = "log.txt";
            byte[] newLine = System.getProperty("line.separator").getBytes();
            FileOutputStream outfile = new FileOutputStream(fileName);
            FileOutputStream logOut = new FileOutputStream(title);

            while (sc.hasNextLine()) {
                String curLine = sc.nextLine();
                byte[] buf = curLine.getBytes();

                ByteArrayInputStream input = new ByteArrayInputStream(buf);
                int numOfBytes = input.available();

                // While there are still bytes in the file to be parsed
                while (numOfBytes > 0) {
                    int inputByte = input.read();
                    String inputBit = Integer.toBinaryString(inputByte);
                    int inputLength = inputBit.length();
                    numOfBits += 8;
                    // Make all bytes length 8 by appending any needed 0's
                    if (inputLength != 8) {
                        while (inputLength != 8) {
                            String zero = "0";
                            inputBit = zero.concat(inputBit);
                            inputLength = inputBit.length();
                        }
                    }
                    String[] send0 = {"run hal", "create hal obj"};
                    String[] send1 = {"run hal"};
                    String log = "";
                    // Based on bit being 0 or 1, run appropriate instructions
                    for (int i = 0; i < inputLength; i++) {
                        if (inputBit.charAt(i) == '0') {
                            SecureSystem.passInstructionsStatic(send0);
                            log += Arrays.toString(send0);
                        } // bit is 1
                        else {
                            SecureSystem.passInstructionsStatic(send1);
                            log += Arrays.toString(send1);
                        }
                        byte[] logResult = log.getBytes();
                        logOut.write(logResult);
                        logOut.write(newLine);
                    }
                    // Write byte to out file, then reset the run manager for the next byte
                    numOfBytes--;
                    String result = ReferenceMonitor.getResultLine();
                    byte[] resultArray = result.getBytes();
                    outfile.write(resultArray);
                    ReferenceMonitor.getRunManager().put("LYLE", "temp");
                }
                outfile.write(newLine);
            }

        } catch (Exception ex) {
            System.out.println("File not found or bad instruction");
        }

        //sys.handleCommands(); part 1
    }
}
