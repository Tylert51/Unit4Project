public class MemorySequence {

   private String[][] boxNumbers;
   private String[][] blank;
   private final String DIV_LINE = "|----|----|----|----|";

   public MemorySequence(int c, int r) {
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
   }

   public MemorySequence() {
      String[][] blank = new String[4][4];
      for (int column = 0; column < blank.length; column++) {
         for (int row = 0; row < blank[0].length; row++) {
            blank[column][row] = "  ";
         }
      }
      this.blank = blank;
   }

   private String printArrayBox (String[][] array) {
      String box = DIV_LINE + "\n";

      for (int column = 0; column < array.length; column++) {
         for (int row = 0; row < array[0].length; row++) {
            box += "| " + array[column][row] + " ";
         }
         box += "|\n" + DIV_LINE + "\n";
      }
      return box;
   }

   public String printBox() {
      return printArrayBox(boxNumbers);
   }

   public String emptyBox() {
      return printArrayBox(blank);
   }


}
