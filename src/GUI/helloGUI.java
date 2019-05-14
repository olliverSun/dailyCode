package GUI;

import javax.swing.*;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class helloGUI implements  Runnable{

    JFrame jf;

    public void run() {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(new File("src/GUI/lcation.txt")));
        } catch (IOException e) {
            e.printStackTrace();
        }
        while(jf.isActive()){
            try {
                bw.write("x="+jf.getX());
                bw.newLine();
                bw.write("y="+jf.getY());
                bw.newLine();
                bw.flush();
                Thread.sleep(100);
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        try {
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
//        主窗体
        JFrame fristJF = new JFrame();
//        1366*768屏幕中心点为533,142
        fristJF.setSize(300,200);
        fristJF.setLocation(533,284);
        JButton jButton=new JButton("do something really bad");
        jButton.setBounds(50,50,200,50);
        fristJF.add(jButton);
        fristJF.setLayout(null);
        fristJF.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fristJF.setVisible(true);
        helloGUI a  = new helloGUI();
        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        a.setJf(fristJF);
        new Thread(a).start();
    }




    public JFrame getJf() {
        return jf;
    }

    public void setJf(JFrame jf) {
        this.jf = jf;
    }


}
