package obligatorio;

public class Startup {

    public static void main(String[] args) {
        SecureSystem sys = new SecureSystem();

        SecurityLevel low = SecurityLevel.LOW;
        SecurityLevel medium = SecurityLevel.MEDIUM;
        SecurityLevel high = SecurityLevel.HIGH;

        sys.createSubject("lyle", low);
        sys.createSubject("moe", medium);
        sys.createSubject("hal", high);
        
        sys.handleCommands();
    }
}
