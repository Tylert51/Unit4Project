public class MemorySequenceRunner {
    public static void main(String[] args) {
        MemorySequence customize = new MemorySequence(5,5);
        MemorySequence defaultBox = new MemorySequence();


        System.out.print(customize.numBox());
        System.out.println("\n\n\n\n");
        System.out.print(customize.emptyBox());
        System.out.println("\n\n\n\n");

        System.out.println(customize.lightBox());
        System.out.println("\n\n\n\n");
        System.out.println(customize.emptyBox());
        System.out.println("\n\n\n\n");
        System.out.println(customize.lightBox());
    }
}
