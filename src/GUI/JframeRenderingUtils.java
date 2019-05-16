package GUI;

import javax.swing.*;
import java.awt.*;

//Jframe的框架渲染器
public class JframeRenderingUtils {
/**
 * 简单的渲染
 *
  */
    public void JframeStandard(JFrame jf){
      setCenterPosition(jf);
      setVisibleAndCloseWhenClickX(jf,true);
    }

    /**
     * 居中
     */
    private void setCenterPosition(JFrame jf){
        ScreenUtils su = new ScreenUtils();
        int[] centerPoint = su.getScreenCenterPonit();
        int width =su.getScreenWidth()*3/4;
        int hight =su.getScreenHight()*3/4;
        int xPosition =centerPoint[0]-(width>>1);
        int yPosition =centerPoint[1]-(hight>>1);
        jf.setBounds(xPosition,yPosition,width,hight);

    }

    /**
     * 显示，点击叉掉就关闭
     */

    private void setVisibleAndCloseWhenClickX(JFrame jf,boolean isTelescopic){
        jf.setResizable(isTelescopic);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);

    }
}
