package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class JFrameAndJDialog {
    public static  void main(String[] args){
        JFrame jf = new JFrame();
        jf.setBounds(533,284,500,500);
        jf.setVisible(true);
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jf.setLayout(new BorderLayout());
//       窗体大小不可变化
        jf.setResizable(false);
        JPanel jPanel = new JPanel();
//       流布局
        jPanel.setLayout(new FlowLayout());
        JButton jb = new JButton("打开一个模态窗口");
        jb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("11111");
                JDialog jPanel2 = new JDialog(jf);
                jPanel2.setSize(200,200);
                jPanel2.setLocation(800,400);
                jPanel2.setModal(true);
                JButton jButton = new JButton("解锁大小");
                jPanel2.add(jButton);
                jPanel2.setResizable(false);
                jButton.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                       if(jPanel2.isResizable()){
                           jPanel2.setResizable(false);
                       }else{
                           jPanel2.setResizable(true);
                       }
                    }
                });
                jPanel2.setVisible(true);
            }
        });

        jPanel.add(jb);
//       上部
        jf.add(jPanel,BorderLayout.NORTH);


//        中部
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jf.setVisible(true);


    }
}
