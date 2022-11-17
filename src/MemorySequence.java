import java.util.ArrayList;

public class MemorySequence {

   private String[][] boxNumbers;
   private String[][] blank;
   private int columns;
   private int rows;
   private final String DIV_LINE = "|----";
   private final String ANSI_RESET = "\u001B[0m";
   private final String ANSI_BLUE = "\u001B[34m";
   private final String ANSI_RED = "\u001B[31m";
   private final String ANSI_YELLOW = "\u001B[33m";
   private final String ANSI_CYAN = "\u001B[36m";
   private final String ANSI_PURPLE = "\u001B[35m";
   private static ArrayList<String> sequence = new ArrayList<String>();
   private static ArrayList<String> userInputAns = new ArrayList<String>();
   private static int score;
   private static boolean defaultSeq = true;
   private static int seqLen;

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
      columns = 5;
      rows = 5;
      String[][] boxNumbers = new String[columns][rows];
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

      blank2[ranCol][ranRow] = ANSI_CYAN + "XX" + ANSI_RESET;

      return printBox(blank2);
   }

   public static boolean gameRunning() {
      return userInputAns.equals(sequence);
   }

   public static void setUserInputAns(ArrayList<String> userAns) {
      userInputAns = userAns;
   }

   private static void calcScore() {
      if (userInputAns.size() == 0) {
         score = 0;
      } else {
         if (defaultSeq) {
            score = userInputAns.size() - 1;
         } else {
            score = (userInputAns.size() - 1) / seqLen;
         }
      }
   }

   public void setSeqLen(int len) {
      seqLen = len;
   }

   public static void clearSeqList() {
      sequence.clear();
   }

   public static void clearAnswerList() {
      userInputAns.clear();
   }

   public static void changeSeq() {
      defaultSeq = false;
   }
   public String toString() {
      calcScore();
      String response = "\not quite the sequence, nice try though.\n\n";
      if(defaultSeq) {
         return response + "\n\nNice job, you completed sequences up to the length of " + score + "!" + "\n\n";
      } else {
         return response + "\n\nNice job, you had a practice session of " + score + " games with the sequence length of " + seqLen + "!" + "\n\n";
      }
   }
}
