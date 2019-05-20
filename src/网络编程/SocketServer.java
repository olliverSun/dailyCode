package 网络编程;

import java.io.IOException;
import java.net.ServerSocket;

public class SocketServer {
//    打开8080端口监听


    public static void mian(String[] args) throws IOException {
        ServerSocket sScoket = new ServerSocket(8080);
        sScoket.accept();

    }
}
