package Hutool;


import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.TYPE;

import java.awt.Color;
import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

import org.junit.Test;

import cn.hutool.core.convert.Convert;
import cn.hutool.core.util.HexUtil;
import cn.hutool.core.util.ReflectUtil;
import cn.hutool.core.util.StrUtil;
/**
 * @Author:
 * @when
 * @description
 */
public class HutoolTool {
//    是否为16进制判断，其实就是判断字符串是否是已0x开头
    @Test
    public void testHexUtil(){
        String t1="12";
        boolean hexNumber = HexUtil.isHexNumber(t1);
        String t2="0X12";
        boolean hexNumber1 = HexUtil.isHexNumber(t2);
        System.out.println(hexNumber+":::::"+hexNumber1);
    }

//    已16进制进行编码或者解码
    @Test
    public void testHexUtil2(){
        String t1="12";
        String s1 = HexUtil.encodeHexStr(t1);
        String s2 = HexUtil.decodeHexStr("3132");
        System.out.println(s2);
    }
}

