import java.util.Scanner;

public class MemorySequenceRunner {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Hi, welcome to my memory game!\n\nWould you like to play competitive mode(1) or practice mode(2)? ");
        String compAns = s.nextLine();

        while (!(compAns.equals("1")) && !(compAns.equals("2"))) {
            System.out.print("\nInvalid input\nEnter 1 for competitive and 2 for practice ");
            compAns = s.nextLine();
        }

        if (compAns.equals("1")) {
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

