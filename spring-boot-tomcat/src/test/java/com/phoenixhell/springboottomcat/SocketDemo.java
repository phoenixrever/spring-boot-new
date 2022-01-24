package com.phoenixhell.springboottomcat;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

/**
 *
 */


public class SocketDemo {

    //client
    @Test
    public void client(){
        //TCP
        try {
            Socket socket = new Socket("localhost", 8989);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(("socket test"+ UUID.randomUUID().toString().substring(0,6)).getBytes());

            outputStream.flush();
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //udp
//        DatagramSocket datagramSocket = new DatagramSocket();
    }

    @Test
    public void server(){
        try {
            ServerSocket serverSocket = new ServerSocket();
            InetSocketAddress localhost = new InetSocketAddress("localhost", 8989);
            serverSocket.bind(localhost);
            Socket accept = serverSocket.accept();
            InputStream inputStream = accept.getInputStream();

            byte[] bytes = new byte[1024];
            inputStream.read(bytes,0,bytes.length);
            System.out.println(new String(bytes));

            //阻塞线程
            System.in.read();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
