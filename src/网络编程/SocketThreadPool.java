package 网络编程;

import 网络编程.ListStack;
import 网络编程.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class SocketThreadPool {
    int countConsumer=10;
    public Stack stack = new ListStack();




    SocketThreadPool(int countConsumer){
        this.countConsumer=countConsumer;
    }

    public void enging(){
        for (int i = 0; i <countConsumer ; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true){
                        if(stack.Size()>0){
                            String adress = (String) stack.poll();
                            try {
                                runtimeSocket(adress);

                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        }
                    }

            }).start();

        }
    }
    public void runtimeSocket(String adress) throws IOException {
        Process exec = Runtime.getRuntime().exec("ping" + " 192.168.12."+adress);
        InputStream inputStream = exec.getInputStream();
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream,"GBK"));
        System.out.println();
        String line;
        StringBuilder a = new StringBuilder();
        while((line=br.readLine())!=null){
            a.append(line);
        }
        if(a.toString().contains("0%")){
            System.out.println("192.168.12."+adress+"可用");
        }else{
            System.out.println("192.168.12."+adress+"不可用或有丢包");
        }
    }




}
