package grep;

import java.util.HashMap;

public class Main {

    private final static int COUNT = 1;

    public static void main(String[] args) {

        long start,end;
        HashMap<String,Long> results = new HashMap<String, Long>();


        start = System.nanoTime();
        for (int i = 1; i <= COUNT; i++) {
            bufferedGrep.grep.main(args);
        }
        end =  System.nanoTime();
        results.put("Buffered", (long) ((end - start)/10e6/COUNT));


        start = System.nanoTime();
        for (int i = 1; i <= COUNT; i++) {
            naiveGrep.grep.main(args);
        }
        end =  System.nanoTime();
        results.put("Naive", (long) ((end - start)/10e6/COUNT));



        for (String grepName:results.keySet()){
            System.out.println(grepName + " : " + results.get(grepName));
        }


        threadsGrep.grep.main(args);
    }


}





