public class Settings {
    private static boolean displayNum = true;
    private final String ANSI_BLUE = "\u001B[34m";
    private final String ANSI_RED = "\u001B[31m";
    private final String ANSI_RESET = "\u001B[0m";

    public Settings() {}

    public void changeDisplayChar(String dChar) {
        if (dChar.equals("x")) {
            displayNum = false;
        } else {
            displayNum = true;
        }
    }

    public static boolean returnStatus() {
        return displayNum;
    }

    public static String printInstructions() {
        String instruct = "";
        return instruct;
    }

    public String toString() {
        String settings = "Display Numbers instead of X's: ";
        String status = displayNum + "";

        if (displayNum) {
            status = (ANSI_BLUE + status + ANSI_RESET);
        } else {
            status = (ANSI_RED + status + ANSI_RESET);
        }
        return settings + status;
    }
}
