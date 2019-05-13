package 原生JDBC;

import java.io.IOException;
import java.sql.*;

public class FristDao {

    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        InitDriver initDriver = new InitDriver("src\\原生JDBC\\properties.properties");
        Connection connection=initDriver.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement("select * from hero a where a.hero_id=?");
        preparedStatement.setInt(1,1);
        ResultSet resultSet = preparedStatement.executeQuery();
        Hero a = new Hero();
        while(resultSet.next()){
            a.setHero_id(Integer.valueOf(resultSet.getString(1)));
            a.setName(resultSet.getString(2));
            a.setSkills(resultSet.getString(3));
            a.setRace(resultSet.getString(4));
            a.setHp(Long.parseLong(resultSet.getString(5)));
            a.setMp(Long.parseLong(resultSet.getString(6)));
        }

        System.out.println(a.toString());

    }
}
