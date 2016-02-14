

public class Main {

    private final static int COUNT = 10;

    public static void main(String[] args) {


        long start = System.nanoTime();
        for (int i = 1; i <= COUNT; i++) {
            naiveGrep.grep.main(args);
        }
        long end =  System.nanoTime();

        System.out.print((end - start)/10e6/COUNT + "\r\n");

        threadsGrep.grep.main(args);
    }


}





