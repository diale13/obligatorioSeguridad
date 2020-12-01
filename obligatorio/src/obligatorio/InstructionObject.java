package obligatorio;

import java.util.ArrayList;

public class InstructionObject {

    public void manageInstruction(String line) throws BadInstruction {
        String command = line;
        String[] splited = command.split(" ");
        if (!ValidateCommand(splited)) {
            throw new BadInstruction(line);
        }
    }

    private boolean ValidateCommand(String[] splited) {
        boolean isValid = true;
        isValid = isValid && IsLengthValid(splited) && IsSintaxCorrect(splited);
        return isValid;
    }

    private boolean IsLengthValid(String[] splited) {
        return (splited.length <= 4 && splited.length > 2);
    }

    private boolean IsSintaxCorrect(String[] splited) {
        String firstCommand = splited[0];
        boolean isValid = true;
        switch (firstCommand) {
            case "write":
                ManageWrite(splited);
                break;
            case "read":
                ManageRead(splited);
                break;
            default:
                isValid = false;
        }
        return isValid;
    }

    private boolean ManageWrite(String[] splited) {
        try {
            if (splited.length != 4) {
                return false;
            }
            Integer.parseInt(splited[3]);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private boolean ManageRead(String[] splited) {
        return (splited.length == 3);
    }

    public boolean validateSubjectAndObjects(String line, ArrayList<Subject> subjects) {
        //Todo Validate 
        return false;
    }

}
