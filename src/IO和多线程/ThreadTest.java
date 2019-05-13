package IO和多线程;

import org.junit.Test;
import 线程交互.Hreo;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;


public class ThreadTest{
    @Test
    public void tets1(){
        try {
            String test =iteration("笔记","sunao");
            System.out.println(test);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void test2(){
        int energy =3;
        while(energy==3){
            Thread t1 =new Thread(()->fabo(energy));
        }
    }

    public synchronized void  fabo(Integer energy){
        System.out.println("发第几"+energy+"波");
        energy--;

    }





    public String iteration(String path,String regx) throws IOException, InterruptedException {
        CountDownLatch cd = new CountDownLatch(2);
        ioJava(path,regx,cd);
        ReadThread.cd.await();
        return ReadThread.filesNames.toString();
    }
    /**
     * 遍历一个文件夹
     * 参数:文件夹路径 ，匹配的字符串
     * 返回：拥有该字符串的文件
     */

    public void ioJava(String realLoadPath, String regx,CountDownLatch cd) throws IOException {
            File file = new File(realLoadPath);
            Runnable rh = new ReadThread(file,regx,cd);
            if(file.exists()){
                if(file.isFile()){
                    //每个文件都可以开一线程让其运行
                    Thread ts = new Thread(rh);
                    ts.start();
                    }
                else {
                    File[] files =file.listFiles();
                    for (File iterationFile:files ) {
                        ioJava(iterationFile.getPath(),regx,cd);
                    }
                }
            }else{
                System.out.println("找不到路径");
            }}


    public void  addFiles(File file,String regx,ArrayList filesNames) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file));
        String readline=null;
        while ((readline=br.readLine())!=null){
            if(readline.contains(regx)){
                filesNames.add(file.getName());
            }
        }}



        @Test
        public void testMyHreo() throws InterruptedException {
        Hreo hreo = new Hreo();

//            首先开启充能线程，随时准备充能
             Thread t1 =new Thread(new Runnable() {
                        @Override
                        public void run() {
                            while(true){
                                if(hreo.getEnergy()==0){
                                    try {
                                        hreo.charge();
                                        //停止
                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }
                            }
                        }
                    });
                t1.start();


            for(int i=0;i<=2;i++){
               new Thread(new Runnable() {
                    @Override
                    public   void run() {
                        while(true){

                                hreo.fabo();

                        }
                    }
                }).start();
            }


               t1.join();

        }
    }


