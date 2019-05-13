package 原生JDBC;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class pagination {
    public static void main(String[] args) throws IOException, SQLException {
        InitDriver initDriver = new InitDriver("src\\原生JDBC\\properties.properties");
        Connection connection = initDriver.getConnection();
//      分页查询 每x条一页，共count/x页(需要知道当前页数，以及每页显示条数)
        String sql ="select * from hero limit ?,?";
        int nowpage=1;
        int pagecount=3;
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setInt(1,(nowpage-1)*pagecount);
        preparedStatement.setInt(2,pagecount);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Hero> Heros = new ArrayList<Hero>();
        while(resultSet.next()){
            Hero Iterator = new Hero();
            setHero(Iterator,resultSet);
            Heros.add(Iterator);
        }

        for(Hero hero:Heros){
            System.out.println(hero.toString());
        }

    }


    public static void setHero(Hero hero,ResultSet resultSet) throws SQLException {
        hero.setHero_id(Integer.valueOf(resultSet.getString(1)));
        hero.setName(resultSet.getString(2));
        hero.setSkills(resultSet.getString(3));
        hero.setRace(resultSet.getString(4));
        hero.setHp(Long.parseLong(resultSet.getString(5)));
        hero.setMp(Long.parseLong(resultSet.getString(6)));
    }
}
