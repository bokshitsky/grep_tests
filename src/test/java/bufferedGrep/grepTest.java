package bufferedGrep;

import org.junit.Test;

import java.io.File;

import java.util.Arrays;
import java.util.stream.Stream;


public class grepTest {

    @Test
    public void testMain() throws Exception {
        int COUNT = 5;
        String[] a =  {"Iron Throne"};

        Arrays.stream(new File("./test_data").list()).map(s -> "test_data/"+s).toString();

        String[] args = Stream.concat(
                Arrays.stream(a), Arrays.stream(new File("./test_data").list()).map(s -> "test_data/"+s))
                .toArray(String[]::new);

        long start = System.nanoTime();
        for (int i = 1; i <= COUNT; i++) {
            bufferedGrep.grep.main(args);
        }
        long end =  System.nanoTime();
        System.out.println("Buffered : " + (long) ((end - start)/10e6/COUNT));
    }
}