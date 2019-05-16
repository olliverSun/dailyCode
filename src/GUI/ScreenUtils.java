package GUI;

import java.awt.*;

public class ScreenUtils {
//获取显示屏宽度
  public int getScreenWidth(){
        Dimension Screen = Toolkit.getDefaultToolkit().getScreenSize();
        return (int) Screen.getWidth();
    };
//获取显示屏高度
    public int getScreenHight(){
        Dimension Screen = Toolkit.getDefaultToolkit().getScreenSize();
        return (int) Screen.getHeight();
    };
//获取显示屏尺寸
    public int[] getScreenSize() {
        int[] z = {this.getScreenWidth(), this.getScreenHight()};
        return z;
    };
//获取显示器中心点（坐标）
    public int[] getScreenCenterPonit() {
        int[] xy ={getScreenWidth()>>1,getScreenHight()>>1};
        return xy;
    };


}
