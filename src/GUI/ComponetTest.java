package GUI;

import org.junit.Test;

import javax.swing.*;
import java.awt.*;

public class ComponetTest {

//    标签
    public static void  main(String[] args){
        JFrame F = new JFrame("标签窗口");
        JLabel label = new JLabel("全场最佳");
        JPanel jp = new JPanel();
        jp.setLayout(new BorderLayout());
        JLabel icon = new JLabel();
        ImageIcon a  = new ImageIcon("src/GUI/shana.png");

        icon.setIcon(a);
        jp.add(label,BorderLayout.WEST);
        jp.add(icon,BorderLayout.EAST);

        JLabel label1 = new JLabel("右边");
        label.setHorizontalAlignment(JLabel.CENTER);
        JLabel label2 = new JLabel("占领高地");
        label2.setHorizontalAlignment(JLabel.CENTER);
        JLabel label3 = new JLabel("左边");
        label3.setHorizontalAlignment(JLabel.CENTER);
        JLabel label4 = new JLabel("猥琐下路");
        label4.setHorizontalAlignment(JLabel.CENTER);
        F.setLayout(new BorderLayout());
        F.add(jp,BorderLayout.CENTER);
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

