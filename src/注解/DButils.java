package 注解;

import java.sql.*;

public class DButils {
    private static String url="jdbc:mysql://127.0.0.1:3306/test?useUnicode=true&characterEncoding=utf8";
    private static String username="root";
    private static String password="root";
    private static String driver="com.mysql.jdbc.Driver";
    static{
        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws SQLException {
        DButils db = new DButils();
        Connection connection = DriverManager.getConnection(url, username, password);
        PreparedStatement psq = connection.prepareStatement("select * from hero");
        ResultSet resultSet = psq.executeQuery();
        while(resultSet.next()){
            System.out.println(resultSet.getInt(1));
        }
    }



}
