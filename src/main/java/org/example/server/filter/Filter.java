package org.example.server.filter;


import java.net.Socket;


/**
 * 提供给服务器的顶级接口
 * 到时候会创建一个过滤器链
 */
public interface Filter {
    /**
     * 过滤器方法
     * @param socket 用户链接的上下文
     */
    void doFilter(Socket socket,String payload);
}
