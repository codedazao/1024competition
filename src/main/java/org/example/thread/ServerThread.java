package org.example.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerThread {
    public static final ExecutorService threadPool = Executors.newFixedThreadPool(20);
}
