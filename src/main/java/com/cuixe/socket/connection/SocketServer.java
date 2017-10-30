package com.cuixe.socket.connection;

import java.io.IOException;
import java.net.ServerSocket;

public class SocketServer {

    private ServerSocket socketServer;
    private Thread runner = null;

    public SocketServer(int puerto) throws IOException {
        this( new ServerSocket(puerto));
    }

    public SocketServer(ServerSocket socketServer) {
        this.socketServer = socketServer;
    }

    public void startServer() {
        runner = new Thread(() -> {
            while (true) {
                try {
                    Thread client = new Thread(new SocketHandler(socketServer.accept()));
                    client.start();
                }catch (Exception ex) {
                    System.out.println(ex.getMessage());
                }
            }
        });
        runner.start();
    }

}
