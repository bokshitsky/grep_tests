package naiveGrep;

import java.io.*;


public class grep {


    public static void main(String[] args){
        String Pattern = args[0];
        System.out.println(Pattern);
        for (int i = 1; i < args.length ; i++) {
            String Filename = args[i];
            File file = new File(Filename);


            try {
                FileInputStream FileIS = new FileInputStream(file);

                BufferedReader Reader = new BufferedReader(new InputStreamReader(FileIS));

                String  line;
                int StrIndex;
                while ((line = Reader.readLine()) != null) {
                    if ((StrIndex = line.indexOf(Pattern)) != -1) {
                        System.out.println(Filename + ":" + line);
                    }
                }
                Reader.close();


            } catch (IOException e) {
                System.err.println("IO Exception occured for file " + Filename);
            }



        }
    }

}





