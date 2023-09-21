package org.example.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Logger;

public class ServerBoot {
    //引导服务端启动的方法
    public void bootServer(){
        Logger logger = Logger.getLogger(ServerBoot.class.getName());
        //记得要进行多线程处理,用一个currentHashMap存入session
        while (true){
            //这个端口后面会写成配置文件
            try (ServerSocket serverSocket = new ServerSocket(8081);) {
                String htmlLine;
                StringBuilder html= new StringBuilder();
                logger.info("服务器启动");
                Socket accept = serverSocket.accept();
                InputStream inputStream = accept.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                while (bufferedReader.ready()){
                    System.out.println(bufferedReader.readLine());
                }
                //获取文件
                FileReader fileReader =
                        new FileReader("/Users/pan/IdeaProjects/1024competition/src/main/resources/html/index.html");
                BufferedReader fileBufferReader = new BufferedReader(fileReader);
                while ((htmlLine=fileBufferReader.readLine()) != null){
                    html.append(htmlLine);
                }
                //响应头
                String responseHeader = "HTTP/1.1 200 OK\r\n"
                        + "Content-Type: text/html\r\n"
                        + "Content-Length: " + html.length() + "\r\n"
                        + "\r\n";
                OutputStream outputStream = accept.getOutputStream();
                outputStream.write(responseHeader.getBytes());
                outputStream.write(html.toString().getBytes());
                outputStream.flush();
                accept.close();
            }  catch (IOException e) {
                logger.warning(e.getMessage());
            }
        }
    }
}
