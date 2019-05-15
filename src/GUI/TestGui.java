package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class TestGui {
    public static void main(String[] args){

        JFrame f = new JFrame("lol");
//      选项框大小
        f.setSize(400,500);
        f.setLocation(533,284);
        f.setLayout(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon i = new ImageIcon("src/GUI/shana.png");
        JLabel lab = new JLabel();
        lab.setIcon(i);
        lab.setBounds(50,50,i.getIconWidth(),i.getIconHeight());
        JButton button = new JButton("隐藏图片");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    if(lab.isVisible()){
                        lab.setVisible(false);
                    }else {
                        lab.setVisible(true);
                    }
                    f.requestFocus();

            }
        });

        f.addKeyListener(new KeyListener() {
            @Override

            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if(e.getKeyCode() == KeyEvent.VK_RIGHT)
                    lab.setBounds(lab.getX()+10,lab.getY(),lab.getWidth(),lab.getHeight());
                if(e.getKeyCode() == KeyEvent.VK_LEFT)
                    lab.setBounds(lab.getX()-10,lab.getY(),lab.getWidth(),lab.getHeight());
                if(e.getKeyCode() == KeyEvent.VK_DOWN)
                    lab.setBounds(lab.getX(),lab.getY()+10,lab.getWidth(),lab.getHeight());
                if(e.getKeyCode() == KeyEvent.VK_UP)
                    lab.setBounds(lab.getX(),lab.getY()-10,lab.getWidth(),lab.getHeight());
            }
//           释放键
            @Override
            public void keyReleased(KeyEvent e) {

            }
        });

        lab.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                lab.setVisible(false);
                f.requestFocus();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lab.setVisible(true);
                f.requestFocus();
            }
        });
        button.setBounds(150,400,100,50);
        f.add(button);
        f.add(lab);
        f.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        f.setVisible(true);
    }


}
