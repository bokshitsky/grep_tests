package bufferedGrep;

import java.io.*;



public class grep{


    public static void main(String[] args){
        String Pattern = args[0];
        System.out.println(Pattern);
        for (int i = 1; i < args.length ; i++) {
            String Filename = args[i];
            File file = new File(Filename);

            //NOTE: no control of maximum allowable file size is performed.
            byte[] a = new byte[(int) file.length()];

            try {
                FileInputStream FileIS = new FileInputStream(file);

                FileIS.read(a);

                ByteArrayInputStream ByteIS = new ByteArrayInputStream(a);
                BufferedReader Reader = new BufferedReader(new InputStreamReader(ByteIS));

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





