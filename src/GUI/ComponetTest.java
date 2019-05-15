package GUI;

import org.junit.Test;

import javax.swing.*;
import java.awt.*;

public class ComponetTest {

//    标签
    public static void  main(String[] args){
        JFrame F = new JFrame("标签窗口");
        JLabel label = new JLabel("全场最佳");
        JLabel label1 = new JLabel("右边");
        label.setHorizontalAlignment(JLabel.CENTER);
        JLabel label2 = new JLabel("占领高地");
        JLabel label3 = new JLabel("左边");
        JLabel label4 = new JLabel("猥琐下路");
        F.setLayout(new BorderLayout());
        F.add(label,BorderLayout.CENTER);
        F.add(label1,BorderLayout.EAST);
        F.add(label2,BorderLayout.NORTH);
        F.add(label3,BorderLayout.WEST);
        F.add(label4,BorderLayout.SOUTH);
        F.setDefaultCloseOperation(3);
        F.setBounds(500,500,500,500);
        F.setResizable(true);
        F.setVisible(true);

    }
}

