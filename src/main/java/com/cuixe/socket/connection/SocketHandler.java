package com.cuixe.socket.connection;

import com.cuixe.socket.vo;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class SocketHandler implements Runnable {

    private OutputStream outputStream;
    private InputStream inputStream;
    private Socket socket;

    public SocketHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        while (true) {
            try {
                outputStream = socket.getOutputStream();
                inputStream = socket.getInputStream();
                vo.PingRequest request = vo.PingRequest.parseDelimitedFrom(inputStream);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

    }
}
