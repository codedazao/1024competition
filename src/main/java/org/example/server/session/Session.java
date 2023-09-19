package org.example.server.session;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 存放用户session的类
 */
public class Session {
    /**
     * 用于存放用户session信息的map，涉及到可能多线程访问，所以用并发安全类
     */
    public static final ConcurrentHashMap session =  new ConcurrentHashMap();
}
