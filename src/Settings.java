/**
 * The settings class represents the settings of the game. Setting has the attribute of whether the tiles will display a number or an x
 */
public class Settings {
    private static boolean displayNum;
    private final String ANSI_BLUE = "\u001B[34m";
    private final String ANSI_RED = "\u001B[31m";
    private final String ANSI_RESET = "\u001B[0m";

    /**
     * Constructor for the Settings class. This just instantiates and declares the object
     */
    public Settings() {
        displayNum = true;
    }

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
        String instructions = "This memory will test your ability to memorize and recall a sequence that is displayed on a grid";
        instructions += "\nYou can choose between:\n   - a competitive game mode in which there will be a default 5x5 grid and a sequence that starts with 1, and increases in length each round";
        instructions += "\n      - you will also have the ability to play again and try to beat your high score which will be displayed at the end";
        instructions += "\n   - or a practice game mode where you can customize certain things like grid dimensions or sequence length";
        instructions += "\n      - after choosing grid dimensions, you have the option if you would like to play default (sequence increases by 1 each round) or set your own sequence length that doesn't change";
        instructions += "\nWhenever you fail to complete a sequence, you will be presented with the answer to that sequence and your score (dependant on your game mode)";
        instructions += "\n\nFor the settings, you can choose if you want the actual number of the box to display on the grid or just an XX (this is more challenging btw)";
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
