package obligatorio;

public class SecurityLevelManager {

    private static int levelToInt(SecurityLevel level) {
        switch (level) {
            case HIGH:
                return 2;
            case MEDIUM:
                return 1;
            case LOW:
                return 0;
            default:
                return -1;
        }
    }

    public static boolean dominates(SecurityLevel sublevel, SecurityLevel objlevel) {
        int subjectLevel = levelToInt(sublevel);
        int objectLevel = levelToInt(objlevel);
        return (subjectLevel >= objectLevel);
    }

    public static boolean canWrite(SecurityLevel sublevel, SecurityLevel objlevel) {
        int subjectLevel = levelToInt(sublevel);
        int objectLevel = levelToInt(objlevel);
        return (subjectLevel <= objectLevel);
    }
}
