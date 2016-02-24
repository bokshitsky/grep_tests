package bufferedGrep;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;


public class grep {

    public static void main(String[] args){
        String Pattern = args[0];

        for (int i = 1; i < args.length ; i++) {
            String Filename = args[i];


            try {
                BufferedReader Reader = new BufferedReader(
                        new InputStreamReader(new FileInputStream(Filename))
                        ,Integer.MAX_VALUE/100
                );

                String  line;
                int StrIndex;
                while ((line = Reader.readLine()) != null) {
                    if ((StrIndex = line.indexOf(Pattern)) != -1) {
                        System.out.println(Filename + ":" + line);
                    }
                }

            } catch (IOException e) {
                System.err.println("IO Exception occured for file " + Filename);
            }
        }
    }
}





