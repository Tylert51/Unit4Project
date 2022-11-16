import java.util.ArrayList;

public class MemorySequence {

   private String[][] boxNumbers;
   private String[][] blank;
   private int columns;
   private int rows;
   private final String DIV_LINE = "|----";
   private final String ANSI_RESET = "\u001B[0m";
   private final String ANSI_BLUE = "\u001B[34m";
   private static ArrayList<String> sequence = new ArrayList<String>();
   private static ArrayList<String> userInputAns = new ArrayList<String>();
   private int score = 0;

   public MemorySequence(int c, int r) {
      columns = c;
      rows = r;
      String[][] boxNumbers = new String[c][r];
      int count = 1;
      for (int column = 0; column < boxNumbers.length; column++) {
         for (int row = 0; row < boxNumbers[0].length; row++) {
            if (count < 10) {
               boxNumbers[column][row] = "0" + count;
            } else {
               boxNumbers[column][row] = "" + count;
            }

            count++;
         }
      }
      this.boxNumbers = boxNumbers;

      String[][] blank = new String[columns][rows];
      for (int column = 0; column < blank.length; column++) {
         for (int row = 0; row < blank[0].length; row++) {
            blank[column][row] = "  ";
         }
      }
      this.blank = blank;
   }

      public MemorySequence() {
      columns = 4;
      rows = 4;
      String[][] boxNumbers = new String[4][4];
         int count = 1;
         for (int column = 0; column < boxNumbers.length; column++) {
            for (int row = 0; row < boxNumbers[0].length; row++) {
               if (count < 10) {
                  boxNumbers[column][row] = "0" + count;
               } else {
                  boxNumbers[column][row] = "" + count;
               }

               count++;
            }
         }
         this.boxNumbers = boxNumbers;

         String[][] blank = new String[4][4];
         for (int column = 0; column < blank.length; column++) {
            for (int row = 0; row < blank[0].length; row++) {
               blank[column][row] = "  ";
            }
         }
         this.blank = blank;
   }

   private String printBox (String[][] array) {
      String box = "";
      for (int x = 0; x < columns; x++) {
         box += DIV_LINE + "";
      }
      box += "|\n";

      for (int column = 0; column < array.length; column++) {
         for (int row = 0; row < array[0].length; row++) {
            box += "| " + array[column][row] + " ";
         }
         box += "|\n";
         for (int i = 0; i < columns; i++) {
            box += DIV_LINE + "";
         }
         box += "|\n";

      }
      return box;
   }

   public String numBox() {
      return printBox(boxNumbers);
   }

   public String emptyBox() {
      return printBox(blank);
   }

   public String lightBox() {

      String[][] blank2 = new String[columns][rows];
      for (int column = 0; column < blank.length; column++) {
         for (int row = 0; row < blank[0].length; row++) {
            blank2[column][row] = "  ";
         }
      }

      int ranCol = (int) (Math.random() * columns);
      int ranRow = (int) (Math.random() * rows);
      int boxNum = (ranCol * columns) + ranRow + 1;
      sequence.add("" + boxNum);

      blank2[ranCol][ranRow] = ANSI_BLUE + "XX" + ANSI_RESET;

      return printBox(blank2);
   }

   public static void addInput(String input) {
      if (!(input.equals("done"))) {
         int num = Integer.parseInt(input);
         userInputAns.add(num + "");
      }
   }

   public static boolean gameRunning() {
      return userInputAns.equals(sequence);
   }

   public static void setUserInputAns(ArrayList<String> userAns) {
      userInputAns = userAns;
   }

   public void setScore(int score) {
      this.score = score;
   }
   public String toString() {
      return "";
   }
}
