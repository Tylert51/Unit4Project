public class MemorySequence {

   private String[][] boxNumbers;
   private String[][] blank;
   private final String DIV_LINE = "|----|----|----|----|";

   public MemorySequence() {
      String[][] boxNumbers = new String[4][4];
      int count = 1;
      for (int row = 0; row < boxNumbers.length; row++) {
         for (int column = 0; column < boxNumbers[0].length; column++) {
            if (count < 10) {
               boxNumbers[row][column] = "0" + count;
            } else {
               boxNumbers[row][column] = "" + count;
            }

            count++;
         }
      }
      this.boxNumbers = boxNumbers;

      String[][] blank = new String[4][4];
      for (int row = 0; row < blank.length; row++) {
         for (int column = 0; column < blank[0].length; column++) {
            blank[row][column] = "  ";
         }
      }
      this.blank = blank;
   }

   private String printArrayBox (String[][] array) {
      String box = DIV_LINE + "\n";

      for (int row = 0; row < array.length; row++) {
         for (int column = 0; column < array[0].length; column++) {
            box += "| " + array[row][column] + " ";
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
