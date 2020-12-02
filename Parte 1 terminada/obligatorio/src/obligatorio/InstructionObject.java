package obligatorio;

public class InstructionObject {

    private String instruction;
    private String subject;
    private String object;
    private int value;

    InstructionObject(String line) throws BadInstruction {
        manageInstruction(line);
    }

    public void manageInstruction(String line) throws BadInstruction {
        String command = line;
        String[] splited = command.split(" ");
        if (!validateCommand(splited)) {
            throw new BadInstruction("The command " + line + " is not valid");
        }
        manageExecute(splited);
    }

    private boolean validateCommand(String[] splited) {
        boolean isValid = isLengthValid(splited) && sintaxAndParticipantsOk(splited);
        return isValid;
    }

    private boolean isLengthValid(String[] splited) {
        return (splited.length <= 4 && splited.length > 2);
    }

    private boolean sintaxAndParticipantsOk(String[] splited) {
        String firstCommand = splited[0].toLowerCase();
        boolean isValid = true;
        switch (firstCommand) {
            case "write":
                isValid = manageWriteSintax(splited) && objectAndSubjectExist(splited[1], splited[2]);
                break;
            case "read":
                isValid = manageReadSintax(splited) && objectAndSubjectExist(splited[1], splited[2]);
                break;
            default:
                isValid = false;
                break;
        }
        return isValid;
    }

    private boolean manageWriteSintax(String[] splited) {
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

    private boolean manageReadSintax(String[] splited) {
        return (splited.length == 3);
    }

    private boolean objectAndSubjectExist(String subjectName, String objectName) {
        boolean subjectExists = SecureSystem.getSubjectManager().containsKey(subjectName);
        boolean objectExists = ObjectManager.getObjectManager().containsKey(objectName);
        return subjectExists && objectExists;
    }

    private void manageExecute(String[] splited) throws BadInstruction {
        String firstCommand = splited[0].toLowerCase();
        this.subject = splited[1];
        this.object = splited[2];

        switch (firstCommand) {
            case "write":
                this.instruction = "write";
                this.value = Integer.parseInt(splited[3]);
                ReferenceMonitor.executeWrite(this);
                break;
            case "read":
                this.instruction = "read";
                ReferenceMonitor.executeRead(this);
                break;
            default:
                //Si llegaste a este punto donde un comando valido no cae en write o read, peñarol
                //no es el cuadro mas grande de uru. Tambien los cerdos vuelan. -Franggi 2020
                throw new BadInstruction("");
        }
    }

    public String getInstruction() {
        return this.instruction;
    }

    public String getSubject() {
        return this.subject;
    }

    public String getObject() {
        return this.object;
    }

    public int getValue() {
        return this.value;
    }

}
