public class MemorySequenceRunner {
    public static void main(String[] args) {
        MemorySequence game = new MemorySequence();
        MemorySequence game2 = new MemorySequence(4,4);
        System.out.print(game.emptyBox());
        System.out.print(game.printBox());
    }
}
