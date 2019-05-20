package 网络编程;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class FristSocket {
    public static  void main(String[] args) throws IOException {
       FristSocket a = new FristSocket();
       a.testCanUseAdress();
    }

    @Test
    public void testCanUseAdress() throws IOException {
        SocketThreadPool pool = new SocketThreadPool(10);
        pool.enging();

        for (int i = 0; i <255 ; i++) {

                pool.stack.put(String.valueOf(i));


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
