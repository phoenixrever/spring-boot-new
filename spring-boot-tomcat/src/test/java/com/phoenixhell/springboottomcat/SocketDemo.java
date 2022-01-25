package com.phoenixhell.springboottomcat;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.net.*;
import java.util.UUID;

/**
 *  还可以一个accept 死循环读取 read 是阻塞的 server 一直都  cilent一直写
 *  就不写例子了 真正用到再来学
 */


public class SocketDemo {

    //client
    @Test
    public void client(){
        try
        {
            System.out.println("连接到主机：localhost 端口号：8989");
            Socket client = new Socket("localhost", 8989);
            System.out.println("远程主机地址：" + client.getRemoteSocketAddress());
            OutputStream outToServer = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outToServer);
            out.writeUTF("Hello from " + client.getLocalSocketAddress());

            InputStream inFromServer = client.getInputStream();
            DataInputStream in = new DataInputStream(inFromServer);
            System.out.println("服务器响应： " + in.readUTF());
            client.close();
        }catch(IOException e)
        {
            e.printStackTrace();
        }
        //udp
       // DatagramSocket datagramSocket = new DatagramSocket();
    }

    @Test
    public void server() throws IOException {
            /**
             * 在没有指定IP的情况下   服务器会把此端口绑定到0.0.0.0上面，即在所有IP上面都绑定，即能在每个ip上面收到请求
             *
             *  backlog  存放还没有来得及处理的客户端Socke
             * 队列已经被客户端socket占满了，如果还有新的连接过来，那么ServerSocket会拒绝新的连接。
             * 也就是说backlog提供了容量限制功能，避免太多的客户端socket占用太多服务器资源。
             */

            ServerSocket serverSocket = new ServerSocket(8989,10);
            serverSocket.setSoTimeout(100000);
            //特定ip需要构造SocketAddress
            //InetSocketAddress localhost = new InetSocketAddress("localhost", 8989);
            //serverSocket.bind(localhost);

            while(true){
                try {
                    System.out.println("等待远程连接，端口号为：" + serverSocket.getLocalPort() + "...");
                    //每一个accept接收到消息都会关闭  必须新建一个必须在true里面
                    Socket server = serverSocket.accept();
                    System.out.println("远程主机地址：" + server.getRemoteSocketAddress());
                    DataInputStream in = new DataInputStream(server.getInputStream());
                    System.out.println("接收到的消息"+in.readUTF());

                    DataOutputStream out = new DataOutputStream(server.getOutputStream());
                    out.writeUTF("谢谢连接我：" + server.getLocalSocketAddress() + "\nGoodbye!");
                    //每一个accept接收到消息都要关闭
                    server.close();
                } catch(SocketTimeoutException s)
                {
                    System.out.println("Socket timed out!");
                    break;
                }catch(IOException e)
                {
                    e.printStackTrace();
                    break;
                }

               /* Socket accept = serverSocket.accept();
                InputStream inputStream = accept.getInputStream();
                byte[] bytes = new byte[1024];
                int n = inputStream.read(bytes, 0, bytes.length);
                if(n>-1){
                    System.out.println(new String(bytes,0,n));
                }*/
            }
            //阻塞线程 (使用等待用户输入阻塞)
            //System.in.read();
    }
}
