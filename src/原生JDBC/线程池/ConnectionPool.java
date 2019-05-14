package 原生JDBC.线程池;

import 原生JDBC.InitDriver;

import java.io.IOException;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

    List<Connection> pool = new ArrayList<Connection>();

    private int quantity=10;

    ConnectionPool(int quantityOfconnection) throws IOException {
        this.quantity=quantityOfconnection;
        InitDriver initDriver=new InitDriver("src/原生JDBC/properties.properties");
        for(int i=0;i<this.quantity;i++){
            pool.add(initDriver.getConnection());
        }
    };

    ConnectionPool() throws IOException {
        InitDriver initDriver=new InitDriver("src/原生JDBC/properties.properties");
        for(int i=0;i<this.quantity;i++){
            pool.add(initDriver.getConnection());
        }
    }

    public synchronized  Connection getConnection() throws InterruptedException {
            while(true){
                if(pool.size()>0){
                    return pool.remove(0);
                }
                this.wait();
            }
    }

    public synchronized  void closeConnection(Connection connection){
            pool.add(connection);
            this.notify();
    }

}
