package org.example.server;

import com.sun.net.httpserver.HttpServer;
import org.example.handler.CalculatorHandler;
import org.example.handler.GreetingHandler;

import java.io.IOException;
import java.net.InetSocketAddress;

public class Server {
    public static void main(String[] args) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

        server.createContext("/greeting", new GreetingHandler());
        server.createContext("/calculator", new CalculatorHandler());

        server.start();
    }
}