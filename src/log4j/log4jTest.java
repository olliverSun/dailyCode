package log4j;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;




/**
 * @Author:
 * @when
 * @description
 */

public class log4jTest {
    public static Logger logger = Logger.getLogger(log4jTest.class);
    public static void main(String[] args) {
        PropertyConfigurator.configure("src/log4j.properties");
        logger.trace("跟踪信息");
        logger.debug("调试信息");
        logger.info("输出信息");
        logger.warn("警告信息");
        logger.error("错误信息");
        logger.fatal("致命信息");

    }
}
