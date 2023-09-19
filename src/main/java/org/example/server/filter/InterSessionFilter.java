package org.example.server.filter;

import org.example.server.annotaion.WebFilter;

import java.net.Socket;

@WebFilter
public class InterSessionFilter implements Filter{

    @Override
    public void doFilter(Socket socket, String payload) {

    }
}
