package 反射;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Reflection {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Hero hero = new Hero();
        hero.setSkill("战争践踏");
        Class aClass = Class.forName("反射.Hero");
        Method[] methods = aClass.getMethods();
        for (Method method:
             methods) {
            if(method.getName()=="castSkill"){
                method.invoke(hero);
            }

        }


    }
}
