package 注解;

import java.lang.annotation.*;

@Target({ElementType.TYPE,ElementType.PACKAGE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited //可以被继承的
@Documented //加入Doc
public @interface Entity {
}
