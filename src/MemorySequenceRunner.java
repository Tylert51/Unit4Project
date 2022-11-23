import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class MemorySequenceRunner {
    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        ArrayList<String> answers = new ArrayList<String>();
        clear();

        System.out.print("\n\nHi, welcome to my memory game!\n\nWould you like to play competitive mode(1) or practice mode(2)?\nEnter (3) to access settings and (4) for instructions on how to play: ");
        String compAns = s.nextLine();

        while (!(compAns.equals("1")) && !(compAns.equals("2")) && !(compAns.equals("3")) && !(compAns.equals("4"))) {
            System.out.print("\nInvalid input\nEnter 1 for competitive and 2 for practice\n3 for settings and 4 for instructions ");
            compAns = s.nextLine();
        }
        Settings setting = new Settings();

        while (compAns.equals("3") || compAns.equals("4")) {   //if they keep on wanting to access settings and instructions
            if (compAns.equals("3")) {    //if settings
                clear();
                System.out.println(setting.toString());
                System.out.print("Type x if you want each box to display XX instead of its number: ");
                String challengeMode = s.nextLine();
                setting.changeDisplayChar(challengeMode);
                clear();
                System.out.println(setting.toString());
                Thread.sleep(3500);
                clear();
            } else {
                clear();
                setting.printInstructions();
                System.out.print("Press enter when you understand everything ");
                s.nextLine();
                clear();
            }

            System.out.print("Would you like to play competitive mode(1) or practice mode(2)?\nEnter (3) to access settings and (4) for instructions: ");
            compAns = s.nextLine();
            while (!(compAns.equals("1")) && !(compAns.equals("2")) && !(compAns.equals("3")) && !(compAns.equals("4"))) {
                System.out.print("\nInvalid input\nEnter 1 for competitive and 2 for practice\n3 for settings and 4 for instructions ");
                compAns = s.nextLine();
            }
        }

        if (compAns.equals("2")) {   //if practice
            System.out.print("Would you like to play on a default 5x5 grid(1) or a custom grid with your own dimensions(2)? ");
            String defaultAns = s.nextLine();
            while (!(defaultAns.equals("1")) && !(defaultAns.equals("2"))) {
                System.out.print("\nInvalid input\nEnter 1 default dimensions or 2 for custom: ");
                defaultAns = s.nextLine();
            }
            if (defaultAns.equals("2")) {    // if practice + custom dimension
                System.out.print("Enter a number for number of columns and rows (1-9): ");
                int dimensionAns = Integer.parseInt(s.nextLine());
                while (!inRange(dimensionAns,1,9)) {
                    System.out.print("Invalid input\n\nEnter a number between 1 and 9: ");
                    dimensionAns = Integer.parseInt(s.nextLine());
                }

                MemorySequence gameCustom = new MemorySequence(dimensionAns,dimensionAns);

                System.out.println("\nHere is the layout of your grid:\n");
                System.out.println(gameCustom.numBox() + "\n");
                System.out.print("Would you like to have a set length for each sequence(1) or increase it by one each round(2)? ");
                String setLen = s.nextLine();

                while (!(setLen.equals("1")) && !(setLen.equals("2"))) {
                    System.out.print("Invalid input.\nEnter 1 for set sequence and 2 for the sequence to increase by one every round ");
                    setLen = s.nextLine();

                }
                if (setLen.equals("1")) {     //if practice + custom dimensions + own sequence
                    MemorySequence.changeSeq();
                    System.out.print("Enter your length for the sequence: ");
                    int seqLen = Integer.parseInt(s.nextLine());
                    gameCustom.setSeqLen(seqLen);
                    int counter = 0;
                    clear();

                    while (MemorySequence.gameRunning()) {
                        clear();
                        MemorySequence.clearAnswerList();
                        MemorySequence.clearSeqList();
                        for (int rounds = 1; rounds <= seqLen; rounds++) {
                            System.out.println(gameCustom.lightBox());
                            Thread.sleep(2000);
                            clear();
                            System.out.println(gameCustom.emptyBox());
                            Thread.sleep(2000);
                            clear();
                        }
                        System.out.print(gameCustom.numBox()+ "\n\n" + "Enter the box number of the first tile that lit up: ");
                        answers.add(s.nextLine());
                        for(int rounds = 2; rounds <= seqLen; rounds++) {
                            System.out.print("Next number: ");
                            answers.add(s.nextLine());
                        }
                        MemorySequence.setUserInputAns(answers);
                        counter++;
                    }
                    gameCustom.updateNumTimesRan(counter);
                    System.out.println(gameCustom.toString());

                } else {  // if practice + custom dimensions + default seq
                    clear();
                    int counter = 1;
                    while (MemorySequence.gameRunning()) {
                        clear();
                        MemorySequence.clearSeqList();
                        MemorySequence.clearAnswerList();
                        for (int rounds = 1; rounds <= counter; rounds++) {
                            System.out.println(gameCustom.lightBox());
                            Thread.sleep(2000);
                            clear();
                            System.out.println(gameCustom.emptyBox());
                            Thread.sleep(2000);
                            clear();
                        }
                        System.out.print(gameCustom.numBox()+ "\n\n" + "Enter the box number of the first tile that lit up: ");
                        answers.add(s.nextLine());
                        for (int rounds = 2; rounds <= counter; rounds++) {
                            System.out.print("Next number: ");
                            answers.add(s.nextLine());
                        }
                        MemorySequence.setUserInputAns(answers);
                        counter++;
                    }
                    System.out.println(gameCustom.toString());

                }
            } else {  //if practice + default dimensions
                MemorySequence gameDefault = new MemorySequence();

                System.out.println("\nHere is the layout of your grid:\n");
                System.out.println(gameDefault.numBox() + "\n");
                System.out.print("Would you like to have a set length for each sequence(1) or increase it by one each round(2)? ");
                String setLen = s.nextLine();

                while (!(setLen.equals("1")) && !(setLen.equals("2"))) {
                    System.out.print("Invalid input.\nEnter 1 for set sequence and 2 for the sequence to increase by one every round ");
                    setLen = s.nextLine();

                }
                if (setLen.equals("1")) {  // if practice + default dimensions + own seq. length
                    MemorySequence.changeSeq();
                    System.out.print("Enter your length for the sequence: ");
                    int seqLen = Integer.parseInt(s.nextLine());
                    gameDefault.setSeqLen(seqLen);
                    int counter = 0;
                    clear();

                    while (MemorySequence.gameRunning()) {
                        clear();
                        MemorySequence.clearSeqList();
                        MemorySequence.clearAnswerList();
                        for (int rounds = 1; rounds <= seqLen; rounds++) {
                            System.out.println(gameDefault.lightBox());
                            Thread.sleep(2000);
                            clear();
                            System.out.println(gameDefault.emptyBox());
                            Thread.sleep(2000);
                            clear();
                        }
                        System.out.print(gameDefault.numBox()+ "\n\n" + "Enter the box number of the first tile that lit up: ");
                        answers.add(s.nextLine());
                        for(int rounds = 2; rounds <= seqLen; rounds++) {
                            System.out.print("Next number: ");
                            answers.add(s.nextLine());
                        }
                        MemorySequence.setUserInputAns(answers);
                        counter++;
                        gameDefault.updateNumTimesRan(counter);
                    }
                    System.out.println(gameDefault.toString());

                } else {    //if practice + default dimensions + default seq
                    clear();
                    int counter = 1;
                    while (MemorySequence.gameRunning()) {
                        clear();
                        MemorySequence.clearSeqList();
                        MemorySequence.clearAnswerList();
                        for (int rounds = 1; rounds <= counter; rounds++) {
                            System.out.println(gameDefault.lightBox());
                            Thread.sleep(2000);
                            clear();
                            System.out.println(gameDefault.emptyBox());
                            Thread.sleep(2000);
                            clear();
                        }
                        System.out.print(gameDefault.numBox()+ "\n\n" + "Enter the box number of the first tile that lit up: ");
                        answers.add(s.nextLine());
                        for (int rounds = 2; rounds <= counter; rounds++) {
                            System.out.print("Next number: ");
                            answers.add(s.nextLine());
                        }
                        MemorySequence.setUserInputAns(answers);
                        counter++;
                    }
                    System.out.println(gameDefault.toString());

                }
            }

        } else {   // if competitive
            MemorySequence gameComp = new MemorySequence();
            gameComp.gameIsComp();
            String playAgain = "y";
            while (playAgain.equals("y")) {
                clear();
                playAgain = "n";
                System.out.println("\nHere is the layout of your grid:\n");
                System.out.println(gameComp.numBox() + "\n");
                System.out.print("Press enter when you are ready");
                s.nextLine();
                clear();
                int counter = 1;
                MemorySequence.clearAnswerList();
                MemorySequence.clearSeqList();
                while (MemorySequence.gameRunning()) {
                    clear();
                    MemorySequence.clearSeqList();
                    MemorySequence.clearAnswerList();
                    for (int rounds = 1; rounds <= counter; rounds++) {
                        System.out.println(gameComp.lightBox());
                        Thread.sleep(2000);
                        clear();
                        System.out.println(gameComp.emptyBox());
                        Thread.sleep(2000);
                        clear();
                    }
                    System.out.print(gameComp.numBox() + "\n\n" + "Enter the box number of the first tile that lit up: ");
                    answers.add(s.nextLine());
                    for (int rounds = 2; rounds <= counter; rounds++) {
                        System.out.print("Next number: ");
                        answers.add(s.nextLine());
                    }
                    MemorySequence.setUserInputAns(answers);
                    counter++;
                }
                System.out.println(gameComp.toString());
                System.out.print("You have a current high score of " + gameComp.returnHighScore() + "!\n\nWould you like to play again(y): ");
                playAgain = s.nextLine();

            }

        }

    }


    /**
     * inRange method for the MemorySequenceRunner class. This method will return a boolean and just compares the number, to 2 other values and check if the number is between those 2 numbers
     * @param num an integer representing the number you want to compare
     * @param lower an integer representing the lower bound
     * @param higher an integer representing the upper bound
     * @return a boolean that tells if the number is within the lower and upper bound
     */
    public static boolean inRange(int num, int lower, int higher) {
        return (num >= lower) && (num <= higher);
    }

    /**
     * clear method for the MemorySequenceRunner class. This method will return void and clears the screen for the following text when called
     */
    public static void clear() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }
}