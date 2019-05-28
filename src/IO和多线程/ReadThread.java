package IO和多线程;

import  java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

public class ReadThread implements Runnable {
    private File file;
    private String regx;
    public static ArrayList filesNames = new ArrayList();
    public static ArrayList threadList = new ArrayList<Thread>();
    public static CountDownLatch cd;

    ReadThread(File file, String regx, CountDownLatch cd){
        this.file =file;
        this.regx=regx;
        this.cd = cd;

    }


    @Override
    public void   run() {
        threadList.add(this);
        try {
            addFiles(file,regx,filesNames);
        } catch (IOException e) {
            e.printStackTrace();
        }
        threadList.remove(this);
        cd.countDown();

    }

    public void  addFiles(File file, String regx, ArrayList filesNames) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String readline=null;
        while ((readline=br.readLine())!=null){
            if(readline.contains(regx)){
                filesNames.add(file.getName());
            }
        }}
}

