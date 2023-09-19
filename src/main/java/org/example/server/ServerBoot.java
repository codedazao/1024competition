package org.example.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerBoot {
    //引导服务端启动的方法
    public void bootServer(){
        //记得要进行多线程处理,用一个currentHashMap存入session
        while (true){
            //这个端口后面会写成配置文件
            try (ServerSocket serverSocket = new ServerSocket(8081)) {
                Socket accept = serverSocket.accept();
                InputStream inputStream = accept.getInputStream();
                byte[] bytes = inputStream.readAllBytes();
                String message = new String(bytes);

            }  catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
