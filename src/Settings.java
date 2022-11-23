/**
 * The settings class represents the settings of the game. Setting has the attribute of whether the tiles will display a number or an x
 */
public class Settings {
    private static boolean displayNum = true;
    private final String ANSI_BLUE = "\u001B[34m";
    private final String ANSI_RED = "\u001B[31m";
    private final String ANSI_RESET = "\u001B[0m";

    /**
     * Constructor for the Settings class. This just instantiates and declares the object
     */
    public Settings() {}

    /**
     * changeDisplayChar method for the Settings class. This methods will return void and set displayNum either to true or false depending on the input
     * @param dChar represents the user input; if the user wants to have XX's display, they will input an x turning displayNum false
     */
    public void changeDisplayChar(String dChar) {
        if (dChar.equals("x")) {
            displayNum = false;
        } else {
            displayNum = true;
        }
    }

    /**
     * returnStatus method for the Settings class. This method will return a boolean showing the status of displayNum (true or false)
     * @return returns a boolean that represents displayNum
     */
    public static boolean returnStatus() {
        return displayNum;
    }

    /**
     * printInstructions method for the Settings class. This method will return a string showing the instructions of the game
     * @return a String that has all the instructions stored in it
     */
    public String printInstructions() {
        String instructions = "";
        return instructions;
    }

    /**
     * toString method for the Settings class. This method will return a string showing the user if they have the setting toggled on or off for display num
     * @return a String that says a short description of the setting and whether it is true or not
     */
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
