package com.xingxi.thread;

import junit.framework.TestCase;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author xingxi
 * @date 2019-03-18 13:30:43 星期一
 */
public class ThreadLocalTest extends TestCase {

    public void testThread() {
        // 线程池的创建有7个参数
        ThreadPoolExecutor executor = new ThreadPoolExecutor(
                10,
                15,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy()
        );
        Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(5);

    }

}
