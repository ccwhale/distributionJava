package com.xingxi.websocket;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * @author xingxi
 * @date 2019-03-09 09:24:01 星期六
 */
@Slf4j
public class NetworkInterfaceTest extends TestCase {

    // 设备管理器 网络适配器
    // MTU 开启的设备的MTU是1500 未开启的是-1
    public void testNetworkInterface() throws SocketException {
        Enumeration<NetworkInterface> networkInterfaceEnumeration = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaceEnumeration.hasMoreElements()){
            NetworkInterface networkInterface = networkInterfaceEnumeration.nextElement();
            log.info("getName获得网络设备名称:{}",networkInterface.getName());
            log.info("getDisplayName获得网络设备显示名称:{}",networkInterface.getDisplayName());
            log.info("getIndex获得网络接口的索引:{}",networkInterface.getIndex());
            log.info("isUp是否开启并运行:{}",networkInterface.isUp());
            log.info("isLoopback是否为回调接口:{}",networkInterface.isLoopback());
            log.info("getMTU获得最大传输单元:{}",networkInterface.getMTU());
            log.info("getHardwareAddress获得网卡的物理地址:{}",networkInterface.getHardwareAddress());
            System.out.println();
        }
    }

    public void testAddress() throws SocketException {
        Enumeration<NetworkInterface> networkInterfaceEnumeration = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaceEnumeration.hasMoreElements()){
            NetworkInterface networkInterface = networkInterfaceEnumeration.nextElement();
            log.info("getName获得网络设备名称:{}",networkInterface.getName());
            log.info("getDisplayName获得网络设备显示名称:{}",networkInterface.getDisplayName());
            Enumeration<InetAddress> inetAddressEnumeration = networkInterface.getInetAddresses();
            while (inetAddressEnumeration.hasMoreElements()){
                InetAddress inetAddress = inetAddressEnumeration.nextElement();
                log.info("getCanonicalHostName获取此IP的完全限定域名:{}",inetAddress.getCanonicalHostName());
                log.info("getHostAddress获取次IP地址的主机名:{}",inetAddress.getHostName());
                log.info("getHostAddress获取IP地址字符串:{}",inetAddress.getHostAddress());
                System.out.println("getAddress返回次InetAddress对象的原始IP地址");
                byte[] addressByte = inetAddress.getAddress();
                for(int i=0;i<addressByte.length;i++){
                    System.out.print(addressByte[i]+" ");
                }
                System.out.println();
            }
            System.out.println();
        }

    }
}
