package com.xingxi.test;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author xingxi
 * @date 2019-04-15 10:12:25 星期一
 * https://mp.weixin.qq.com/s?__biz=MzU3MDc3OTI1NA==&mid=2247483780&idx=2&sn=ef71b549ab802fd57721147a734a6f65&chksm=fceb729dcb9cfb8bd92146fa8dd2d4b1d20d22302de25c008022017df37aa2ede7c02839f1ee&mpshare=1&scene=24&srcid=&key=71c3a279be58f2287e1cfe8a9d940e1bcf28c126e23ed879721c1d6979cdfb1671f4c34eda05bacc4cc53593b4e2555d8310a69a6ce4123613f40cc43326df96833945174e456dfedc965be3483da037&ascene=14&uin=MTI1MjAzNjAwNA%3D%3D&devicetype=Windows+10&version=62060739&lang=zh_CN&pass_ticket=Z0pwYCwitD66MyAUQx2LGYSX77RO0hmvE2wTPwJJ4tY5IJxzGb8a17CRYvAxH5gz
 *
 */
@Slf4j
public class FastFailTest {
    private static List<Integer> list = new ArrayList<>();

    private static class TheadOne extends Thread{
        @Override
        public void run() {
            Iterator<Integer> iterator = list.iterator();
            while (iterator.hasNext()){
                int i = iterator.next();
                log.info("thread one 遍历:{}",i);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class TheadTwo extends Thread{
        @Override
        public void run() {
            Iterator<Integer> iterator = list.iterator();
            int i=0;
            while (i<6){
                log.info("thread two 遍历:{}",i);
                if(i==3){
                    list.remove(i);
                }
                i++;
            }
        }
    }

    public static void main(String[] args) {
        for(int i=0;i<10;i++){
            list.add(i);
        }
        new TheadOne().start();
        new TheadTwo().start();
    }

}
