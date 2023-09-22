package org.example.server;

import org.example.thread.ServerThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class ServerBoot {
    //引导服务端启动的方法
    public void bootServer(){
        //服务器端口可以在配置文件中配置
        try (ServerSocket serverSocket = new ServerSocket(8081)){
            while (true){
                Socket socket =serverSocket.accept();
                //接受完请求交给线程池处理
                ServerThread.threadPool.submit(new ServerHandler(socket));
//                while((input = br.readLine()) != null && !input.equals("")) {
//                    System.out.println(input);
//                }
//                PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
//                printWriter.write("http/1.1 200 Accepted\n"+
//                        "ContentType:text/html;charset=utf-8"
//                        +"\n\n");
//                String resolveHtml = HtmlUtils.resolveHtml(
//                        new File("C:\\JavaProject\\One thousand and twenty four\\src\\main\\resources\\html\\index.html")
//                );
//                if (resolveHtml != null) {
//                    printWriter.write(resolveHtml);
//                }
//                printWriter.close();
//                br.close();
//                socket.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
class ServerHandler implements Runnable{
    Socket socket;
    Logger logger = Logger.getLogger(ServerHandler.class.getName());
    ServerHandler(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
            //TODO 解析请求头，封装request，并交给过滤器进行过滤
            System.out.println(br.readLine());
            br.close();
            this.socket.close();
        } catch (IOException e) {
           logger.warning("客户端链接断开");
        }
    }
}
