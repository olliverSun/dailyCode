package 注解;

import 原生JDBC.线程池.ConnectionPool;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.sql.Connection;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface MysqlDBconfig {
        String url();
        String driver();
        String username();
        String password();
        String encoding() default "utf-8";
        String classfropool() default "null";
}
