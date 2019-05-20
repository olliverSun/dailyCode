package 注解;

import 原生JDBC.线程池.ConnectionPool;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 工厂模式创建链接
 */
@MysqlDBconfig(driver = "com.mysql.jdbc.Driver",password = "root",username = "root",
        url = "jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8")
public class DBfactory {

    public static void main(String[] args) throws SQLException, InterruptedException, ClassNotFoundException, NoSuchMethodException {
        DBfactory ndb = new DBfactory();
        Connection connection = ndb.getConnection();
    }

    public Connection getConnection() throws SQLException, InterruptedException, ClassNotFoundException, NoSuchMethodException {
        Class<? extends DBfactory> aClass = DBfactory.class;
        MysqlDBconfig annotation = aClass.getAnnotation(MysqlDBconfig.class);
        String driver = annotation.driver();
        String url = annotation.url();
        String password = annotation.password();
        String username = annotation.username();
        String connectionpool=annotation.classfropool();
        return realConnection(username,password,driver,url,connectionpool);
    }

    private Connection realConnection(String username,String password,String driver,String url
    ,String connectionPool) throws SQLException, InterruptedException, ClassNotFoundException, NoSuchMethodException {
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (connectionPool.contains("null")){
            return DriverManager.getConnection(url,username,password);
        }else{

            return getPoolConnection(connectionPool);
        }
    }

    private  Connection getPoolConnection(String connectionPool) throws ClassNotFoundException, NoSuchMethodException {
        Class aClass = Class.forName(connectionPool);
        Constructor constructor = aClass.getConstructor();

        Method getConnectionMethod = aClass.getMethod("getConnection");
//        Object o =getConnectionMethod.invoke();
        return  null;
  }
}
