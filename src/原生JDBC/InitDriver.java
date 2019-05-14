package 原生JDBC;

import java.io.*;
import java.sql.*;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

//初始化数据库驱动
public class InitDriver {
//  存放数据库配置的集合
    HashMap driverConfig = new HashMap();


    public InitDriver(String path) throws IOException {
//        FileReader fr = new FileReader(new File(path));
        if(path.endsWith(".properties")){
            realinit(path);
            String driver= (String) driverConfig.get("driver");
            try {
                Class.forName(driver);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public Connection getConnection() {
        try {
          return DriverManager.getConnection((String)driverConfig.get("url"),
                  (String)driverConfig.get("username"),(String)driverConfig.get("password"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }


    public void realinit(String path) throws IOException {
        Properties config = new Properties();
        config.load(new FileInputStream(new File(path)));
        Enumeration enumeration = config.propertyNames();
        while(enumeration.hasMoreElements()){
            String key = (String) enumeration.nextElement();
            String value = config.getProperty(key);
            compareToDo(key,value);
        }
    }


//判断启动器，将所有数据配置放入driverConfig中
    public void compareToDo(String key,String value){
        if(key.toLowerCase().contains("driver")){
            driverConfig.put("driver",value);
        };
        if(key.toLowerCase().contains("url")){
            driverConfig.put("url",value);
        };
        if(key.toLowerCase().contains("username")){
            driverConfig.put("username",value);
        };
        if(key.toLowerCase().contains("password")){
            driverConfig.put("password",value);
        };
    }


}
