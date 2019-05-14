package 原生JDBC.线程池;

import org.junit.Test;
import 原生JDBC.InitDriver;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Currency;
import java.util.Date;
//测试连接池与手动开辟连接之间的效率差别
public class TestPool {

    @Test
    public void testPool() throws IOException, InterruptedException, SQLException {
        ConnectionPool pool = new ConnectionPool(10);
        long startmills = System.currentTimeMillis();
        for (int i = 0; i <100 ; i++) {
            Connection connection = pool.getConnection();
            insert(connection);
            pool.closeConnection(connection);
        }
        long overmills = System.currentTimeMillis();
        long finallymills = overmills-startmills;
        System.out.println("线程池历时"+finallymills);

        testThread();
    }

    public void testThread() throws IOException, SQLException {
        InitDriver a = new InitDriver("src/原生JDBC/properties.properties");
        long startmills = System.currentTimeMillis();
        for (int i = 0; i <100 ; i++) {
            Connection connection = a.getConnection();
            insert(connection);
            connection.close();
        }
        long overmills = System.currentTimeMillis();
        long finallymills = overmills-startmills;
        System.out.println("手动开辟连接历时"+finallymills);
    }

    public void insert(Connection connection) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("insert into " +
                "skill(name,type,damage,treatment) values('haha',1,1000,0)");
        preparedStatement.executeUpdate();
        preparedStatement.close();
    }

}
