package com.xingxi.websocket.select;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Set;

/**
 * @author xingxi
 * @date 2019-03-09 17:27:00 星期六
 */
@Slf4j
public class SelectTest extends TestCase {

    public void testSelect() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        //serverSocketChannel.bind(new InetSocketAddress("localhost",8888));
        // 创建selector必须将channel改成非阻塞的.
        serverSocketChannel.configureBlocking(false);

        // 创建ServerSocket实例
        ServerSocket serverSocket = serverSocketChannel.socket();
        serverSocket.bind(new InetSocketAddress("localhost",8888));

        // 获得selector实例
        Selector selector = Selector.open();
        log.info("A isRegistered="+serverSocketChannel.isRegistered());
        // 向给定的选择器注册
        SelectionKey selectionKey = serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
        // serverSocketChannel调用registry方法后是true
        log.info("A isRegistered="+serverSocketChannel.isRegistered());
        log.info("selector:{}",selector);
        log.info("key={}",selectionKey);
        boolean isRun = true;
        while (isRun == true){
            int keyCount = selector.select();
            Set<SelectionKey> set1 = selector.keys();
            Set<SelectionKey> set2 = selector.selectedKeys();
            log.info("keyCount={}",keyCount);
            log.info("set1 size={}",set1.size());
            log.info("set2 size={}",set2.size());
        }
        serverSocketChannel.close();
    }

    public void testSelectClient() throws IOException {
        Socket socket = new Socket("localhost",8888);
        socket.close();
    }
}
