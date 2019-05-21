package 注解;

import java.lang.annotation.Annotation;

/**
 * @Author:RC
 * @when 2019-05-21
 * @description 测试Class类的getAnnotation
 */
public class ClassTest {

    public static void main(String[] args) {
        Annotation[] annotations = Hero.class.getAnnotations();
//      获取注解的类型
        for (Annotation annotation:annotations){
            System.out.println(annotation.annotationType().getName());

//            System.out.println(annotation.getClass().getSimpleName());
        }
    }
}
