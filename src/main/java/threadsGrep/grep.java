package threadsGrep;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


class grepThread extends Thread{

    final private String filename;
    final private String pattern;

    public grepThread(String filename, String pattern){
        this.filename = filename;
        this.pattern = pattern;
    }


    @Override
    public void run(){

        try {
            FileInputStream FileIS = new FileInputStream(filename);

            BufferedReader Reader = new BufferedReader(new InputStreamReader(FileIS));

            String  line;
            int StrIndex;
            while ((line = Reader.readLine()) != null) {
                if ((StrIndex = line.indexOf(pattern)) != -1) {
                    synchronized (System.out) {
                        System.out.println(filename + ":" + line);
                    }
                }
            }
            Reader.close();

        } catch (IOException e) {
            System.err.println("IO Exception occured for file " + filename);
        }
    }
}



public class grep{

    public static void main(String[] args) {

        ArrayList<Callable<Object>> callables = new ArrayList<>();

        String Pattern = args[0];
        ExecutorService service =  Executors.newWorkStealingPool();
        for (int i = 1; i < args.length; i++) {
            String Filename = args[i];
            callables.add(Executors.callable(new grepThread(Filename,Pattern)));
        }

        try {
            service.invokeAll(callables);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }



}





