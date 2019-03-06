package com.xingxi.jedis;

import junit.framework.TestCase;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

import static java.time.Period.ofDays;
import static java.time.Period.ofMonths;
import static java.time.Period.ofWeeks;

/**
 * @author cc
 * @Date 2019-03-05 00:35:35 Tuesday
 */
public class JedisTest extends TestCase {

    public void testPineline() throws InterruptedException {
        Jedis jedis = new Jedis("127.0.0.1",6379);
        long start = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            jedis.set(String.valueOf(i), String.valueOf(i));
        }
        long end = System.currentTimeMillis();
        System.out.print("the jedis total time is:" + (end - start));

        Pipeline pipe = jedis.pipelined(); // 先创建一个pipeline的链接对象
        long start_pipe = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            pipe.set(String.valueOf(i), String.valueOf(i));
            pipe.del(String.valueOf(1));
        }
        //pipe. // 获取所有的response
        long end_pipe = System.currentTimeMillis();
        System.out.print("the pipe total time is:" + (end_pipe - start_pipe));

        BlockingQueue<String> logQueue = new LinkedBlockingQueue<>();
        long begin = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            logQueue.put("i=" + i);
        }
        long stop = System.currentTimeMillis();
        System.out.println(stop-begin);
        jedis.multi();
    }

    public void testJedis(){
        Jedis jedis = new Jedis("127.0.0.1",6379);
        jedis.flushAll();
    }

    public void testInstant(){
        Instant instant = Instant.now().plusMillis(TimeUnit.HOURS.toMillis(12));
        System.out.println(instant.getEpochSecond());
        System.out.println(instant.toEpochMilli());
        System.out.println(System.currentTimeMillis());

        System.out.println(LocalDate.of(1975,5,26)
                .plus(ofDays(5))
                .plus(ofMonths(6))
                .plus(ofWeeks(3))
                .toEpochDay());
        System.out.println(LocalDateTime.of(2019,3,3,0,0,0).
                toEpochSecond(ZoneOffset.of("+8")));

    }



}
