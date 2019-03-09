package com.xingxi.websocket.channel;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

/**
 * @author xingxi
 * @date 2019-03-09 15:31:33 星期六
 */
@Slf4j
public class SelectChannelTest extends TestCase {

    public void testSocketChannel() throws IOException {
        // ServerSocketChannel抽象类,不能直接new
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 配置非阻塞状态 直接socketChannel的close会有空指针异常
//        serverSocketChannel.configureBlocking(false);
        // serverSocket是从channel里面出来的
//        ServerSocket serverSocket = serverSocketChannel.socket();
//        serverSocket.bind(new InetSocketAddress("localhost",8888));
        serverSocketChannel.bind(new InetSocketAddress("localhost", 8888));
        log.info("server阻塞开始={}", System.currentTimeMillis());
//        Socket socket = serverSocket.accept();
        SocketChannel socketChannel = serverSocketChannel.accept();
        log.info("server阻塞结束={}", System.currentTimeMillis());

//        InputStream inputStream = socket.getInputStream();

//        InputStreamReader reader = new InputStreamReader(inputStream);
//        char[] charArray = new char[1024];
//        int readLength = reader.read(charArray);
//        while (readLength!=-1){
//            String newString = new String(charArray,0,readLength);
//            log.info("读取的字符串:{}",newString);
//            readLength = reader.read(charArray);
//        }
//        reader.close();
//        inputStream.close();
//        serverSocket.close();
        // 在非阻塞模式下,accept()方法在没有客户端连接时,返回null值,直接close会有NPE
        ByteBuffer byteBuffer = ByteBuffer.allocate(2);
        int readLength = socketChannel.read(byteBuffer);
        while (readLength != -1) {
            String newString = new String(byteBuffer.array());
            log.info("newString:{}", newString);
            byteBuffer.flip();
            readLength = socketChannel.read(byteBuffer);
        }

        socketChannel.close();
        serverSocketChannel.close();
    }

    public void testClient() {
        try {
            Socket socket = new Socket("localhost", 8888);
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write("zzz".getBytes());
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
