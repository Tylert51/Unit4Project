import java.io.IOException;
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

        if (compAns.equals("2")) {   //if practice
            System.out.print("Would you like to play on your own grid dimensions(1) or default(2)? ");
            String defaultAns = s.nextLine();
            while (!(defaultAns.equals("1")) && !(defaultAns.equals("2"))) {
                System.out.print("\nInvalid input\nEnter 1 for custom dimensions and 2 for default: ");
                defaultAns = s.nextLine();
            }
            if (defaultAns.equals("1")) {    // if practice + custom dimension
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
                if (setLen.equals("1")) {     //if own seq.len. + custom dimensions
                    MemorySequence.changeSeq();
                    System.out.print("Enter your length for the sequence: ");
                    int seqLen = Integer.parseInt(s.nextLine());
                    gameCustom.setSeqLen(seqLen);

                    while (MemorySequence.gameRunning()) {

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
                    }
                    System.out.println(gameCustom.toString());

                } else {  // if default seq  +  custom dimensions
                    int counter = 1;
                    while (MemorySequence.gameRunning()) {
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
                if (setLen.equals("1")) {  // if own seq. length + default dimensions
                    MemorySequence.changeSeq();
                    System.out.print("Enter your length for the sequence: ");
                    int seqLen = Integer.parseInt(s.nextLine());
                    gameDefault.setSeqLen(seqLen);

                    while (MemorySequence.gameRunning()) {

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
                    }
                    System.out.println(gameDefault.toString());

                } else {    //if default seq + default dimensions
                    int counter = 1;
                    while (MemorySequence.gameRunning()) {
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
            System.out.println("\nHere is the layout of your grid:\n");
            System.out.println(gameComp.numBox() + "\n");
            System.out.print("Press enter when you are ready");
            s.nextLine();

            int counter = 1;
            while (MemorySequence.gameRunning()) {
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
                System.out.print(gameComp.numBox()+ "\n\n" + "Enter the box number of the first tile that lit up: ");
                answers.add(s.nextLine());
                for (int rounds = 2; rounds <= counter; rounds++) {
                    System.out.print("Next number: ");
                    answers.add(s.nextLine());
                }
                MemorySequence.setUserInputAns(answers);
                counter++;
            }
            System.out.println(gameComp.toString());
        }

    }


    public static boolean inRange(int num, int lower, int higher) {
        return (num >= lower) && (num <= higher);
    }

    public static void clear() {
        try {
            if (System.getProperty("os.name").contains("Windows"))
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            else
                Runtime.getRuntime().exec("clear");
        } catch (IOException | InterruptedException ex) {}
    }

}

