package com.xingxi.websocket.communication;

import jdk.internal.util.xml.impl.Input;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author xingxi
 * @date 2019-03-09 10:35:02 星期六
 */
@Slf4j
public class Server extends TestCase {

    // ServerSocket实验证明serverSocket是阻塞的,是单线程的例子:有一个客户端连接上程序关闭
    public void testServer(){
        try {
            ServerSocket socket = new ServerSocket(8088);
            log.info("server阻塞开始={}",System.currentTimeMillis());
            socket.accept();
            log.info("server阻塞结束={}",System.currentTimeMillis());
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testClient(){
        log.info("client准备链接={}",System.currentTimeMillis());
        try {
            // localhost是ip地址 在host文件中有对应的映射
            Socket socket = new Socket("localhost",8088);
            log.info("client准备结束={}",System.currentTimeMillis());
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testServerBlock(){
        byte[] byteArray = new byte[1024];
        try {
            ServerSocket serverSocket = new ServerSocket(8088);
            log.info("server阻塞开始={}",System.currentTimeMillis());
            Socket socket = serverSocket.accept();
            log.info("server阻塞结束={}",System.currentTimeMillis());

            // read()方法阻塞的原因是客户端为发送数据到服务端，服务端一直尝试读取从客户端传递过来的数据
            InputStream inputStream = socket.getInputStream();
            log.info("read Begin={}",System.currentTimeMillis());
            int readLength = inputStream.read(byteArray);
            log.info("read End={}",System.currentTimeMillis());
            socket.close();
            serverSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void testClientBlock(){
        log.info("server 开始={}",System.currentTimeMillis());
        try {
            Socket socket = new Socket("localhost",8088);
            log.info("server 结束={}",System.currentTimeMillis());
            Thread.sleep(Integer.MAX_VALUE);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    // multi thread

    // 绑定到指定
    public void testBind(){
        try {
            ServerSocket serverSocket = new ServerSocket();
            // backlog
            serverSocket.bind(new InetSocketAddress(8888),50);
            Thread.sleep(8000);
            for(int i=0;i<100;i++){
                log.info("server begin accept"+i);
                // 侦听并接受此套接字的连接 监听客户端的socket实例
                Socket socket = serverSocket.accept();
                log.info("server end accept");
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.info("server 结束={}",System.currentTimeMillis());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void testClientBind(){
        try {
            for(int i=0;i<100;i++){
                log.info("client request begin accept"+i);
                Socket socket = new Socket("localhost",8888);
                log.info("client request end accept");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
