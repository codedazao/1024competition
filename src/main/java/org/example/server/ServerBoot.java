package org.example.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerBoot {
    //引导服务端启动的方法
    public void bootServer(){
        try (ServerSocket serverSocket = new ServerSocket(8081)){
            while (true){
                Socket socket =serverSocket.accept();
                BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String input = "";
                while((input = br.readLine()) != null && !input.equals("")) {
                    System.out.println(input);
                }

                PrintWriter printWriter = new PrintWriter(socket.getOutputStream(),true);
                printWriter.write("http/1.1 200 Accepted\n"+"\n\n");

                printWriter.close();
                br.close();
                socket.close();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    private String readHtml(File file){
        try {

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
