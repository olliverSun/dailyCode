package 原生JDBC.JDBC事务;

import org.junit.Test;
import 原生JDBC.InitDriver;

import java.io.IOException;
import java.sql.*;

public class Transaction {
    @Test
    public void test() throws IOException, SQLException {
        InitDriver driver = new InitDriver("src\\原生JDBC\\properties.properties");
        Connection connection = driver.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("insert into skill(name,type,damage,treatment) values" +
                "(?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
//        preparedStatement.setInt(1,3);
        preparedStatement.setString(1,"变羊");
        preparedStatement.setInt(2,1);
        preparedStatement.setInt(3,0);
        preparedStatement.setInt(4,0);
        preparedStatement.executeUpdate();
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
        while(generatedKeys.next()){
            connection.setAutoCommit(false);
            try {
                int id  = generatedKeys.getInt(1);
                PreparedStatement preparedStatement1 = connection.prepareStatement(
                        "update skill set name=\"死亡一指\" where skill_id=?"
                );
                preparedStatement1.setInt(1,id);
                preparedStatement1.executeUpdate();
                int error =1/0;
                PreparedStatement preparedStatement3 = connection.prepareStatement("update skill set name" +
                        "=\"死亡一指（阿哈利姆神杖）\" where skill_id=id");
                preparedStatement3.executeUpdate();
                connection.commit();
            }catch (Exception e){
                connection.rollback();
            }


        }




    }
}
