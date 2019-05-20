
package 注解;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
@Target(ElementType.TYPE)

public @interface ToTable {
    String tablename();
}
