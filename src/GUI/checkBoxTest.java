package GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class checkBoxTest {

    public static void main(String[] agrs){
        JFrame jf = new JFrame("复选框");
        jf.setLayout(new BorderLayout());
//        添加复选框面板
        JCheckBox cbox = new JCheckBox("DOTA");
        JCheckBox cbox2= new JCheckBox("LOL");
        JPanel boxCont = new JPanel();
        boxCont.setLayout(new GridLayout(3,3));
        boxCont.add(cbox);
        boxCont.add(cbox2);
        jf.add(boxCont,BorderLayout.WEST);
//      添加单选框面板
        JRadioButton radio1 = new JRadioButton("男");
        JRadioButton radio2 = new JRadioButton("女");
        ButtonGroup br = new ButtonGroup();
        br.add(radio1);
        br.add(radio2);
        JPanel rPanel = new JPanel();
        rPanel.setLayout(new GridLayout(3,3));
        rPanel.add(radio1);
        rPanel.add(radio2);
        jf.add(rPanel,BorderLayout.EAST);
//       添加下拉框面板
        String[] CheckString = {"斧王","剑圣"};
        JComboBox jcb = new JComboBox(CheckString);
        JPanel jcbPanle = new JPanel();
        jcbPanle.setLayout(new GridLayout(3,3));
        jcbPanle.add(jcb);
        jf.add(jcbPanle);
//       添加下拉框选中事件
        jcb.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                if(jcb.getSelectedItem().equals("剑圣")){
                    JOptionPane.showConfirmDialog(jf,"选剑圣？");
                    String anser = JOptionPane.showInputDialog(jf, "真的要选剑圣吗?(输入Y/N)");
                    if(anser.equals("Y")){
                        JOptionPane.showMessageDialog(jf,"已选择英雄");
                    }
                }
            }
        });
//        文本输入框
        JPanel textPlane = new JPanel();
        JTextField text1=  new JTextField();
        JTextField text2= new JTextField();
        text1.setText("请输入账号");
        text2.setText("请输入密码");
        text1.setPreferredSize(new Dimension(80,30));
        text2.setPreferredSize(new Dimension(80,30));
        JLabel usernameLable = new JLabel("账号：");
        JLabel passwordLable = new JLabel("密码：");
        textPlane.add(usernameLable);
        textPlane.add(text1);
        textPlane.add(passwordLable);
        textPlane.add(text2);
        jf.add(textPlane,BorderLayout.SOUTH);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(500,500);
        jf.setResizable(true);
        jf.setVisible(true);
        cbox.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                if(cbox.isSelected()){
                    System.out.println(cbox.getText());
                }
            }
        });

    }
}
