package 原生JDBC.ORM映射;

import com.mysql.jdbc.ConnectionImpl;
import 原生JDBC.Hero;
import 原生JDBC.InitDriver;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrmMapping {


    public void test() throws IOException, SQLException {
//        根据id查询一个英雄对象
        String sql ="select * from hero a ";
        InitDriver initDriver = new InitDriver("src/原生JDBC/properties.properties");
        Connection connection = initDriver.getConnection();
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Hero> ourHeros = new ArrayList<Hero>();
        while (resultSet.next()){
            Hero a = new Hero();
            a.setHero_id(resultSet.getInt(1));
            a.setName(resultSet.getString(2));
            a.setSkills(resultSet.getString(3));
            a.setRace(resultSet.getString(4));
            a.setHp(resultSet.getInt(5));
            a.setMp(resultSet.getInt(5));
            ourHeros.add(a);
        }
    }



}
