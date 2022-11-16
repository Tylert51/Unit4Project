import java.util.Scanner;
import java.util.ArrayList;

public class MemorySequenceRunner {
    public static void main(String[] args) throws InterruptedException {
        Scanner s = new Scanner(System.in);
        ArrayList<String> answers = new ArrayList<String>();

        System.out.print("Hi, welcome to my memory game!\n\nWould you like to play competitive mode(1) or practice mode(2)? ");
        String compAns = s.nextLine();

        while (!(compAns.equals("1")) && !(compAns.equals("2"))) {
            System.out.print("\nInvalid input\nEnter 1 for competitive and 2 for practice ");
            compAns = s.nextLine();
        }

        if (compAns.equals("2")) {
            System.out.print("Would you like to play on your own grid dimensions(1) or default(2)? ");
            String defaultAns = s.nextLine();
            while (!(defaultAns.equals("1")) && !(defaultAns.equals("2"))) {
                System.out.print("\nInvalid input\nEnter 1 for custom dimensions and 2 for default: ");
                defaultAns = s.nextLine();
            }
            if (defaultAns.equals("1")) {
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
                if (setLen.equals("1")) {
                    System.out.print("Enter your length for the sequence: ");
                    int seqLen = Integer.parseInt(s.nextLine());

                    int score = 0;
                    while (MemorySequence.gameRunning()) {

                        for (int rounds = 1; rounds <= seqLen; rounds++) {
                            System.out.println(gameCustom.lightBox());
                            Thread.sleep(2000);
                            System.out.println("\n\n\n\n\n" + gameCustom.emptyBox());
                            Thread.sleep(2000);
                        }
                        System.out.print("Enter the box number of the first tile that lit up: ");
                        answers.add(s.nextLine());
                        for(int rounds = 2; rounds <= seqLen; rounds++) {
                            System.out.print("Next number: ");
                            answers.add(s.nextLine());
                        }
                        MemorySequence.setUserInputAns(answers);
                        score++;
                    }
                    gameCustom.setScore(score-1);
                }



            } else {
                MemorySequence gameDefault = new MemorySequence();
            }

        } else {
            MemorySequence gameDefault = new MemorySequence();
        }

    }


    public static boolean inRange(int num, int lower, int higher) {
        return (num >= lower) && (num <= higher);
    }

}

