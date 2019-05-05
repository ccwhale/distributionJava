package com.xingxi.jedis;

import junit.framework.TestCase;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Pipeline;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
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
        Jedis jedis = new Jedis("127.0.0.1", 6379);
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
        System.out.println(stop - begin);
        jedis.multi();
    }

    public void testJedis() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.flushAll();
    }

    public void testInstant() {
//        Instant instant = Instant.now().plusMillis(TimeUnit.HOURS.toMillis(12));
//        System.out.println(instant.getEpochSecond());
//        System.out.println(instant.toEpochMilli());
//        System.out.println(System.currentTimeMillis());
//
//        System.out.println(LocalDate.of(1975,5,26)
//                .plus(ofDays(5))
//                .plus(ofMonths(6))
//                .plus(ofWeeks(3))
//                .toEpochDay());
//        System.out.println(LocalDateTime.of(2019,3,3,0,0,0).
//                toEpochSecond(ZoneOffset.of("+8")));
        System.out.println("yyyy-MM-dd HH:mm:ss".length());

    }

    // 2019-01-26 201704
    // 2019-04-26 201718
    //            201735
    // 获取今天的shipweek
    public void testWeek() throws ParseException {
        try {

            int weeksInWeekYear = DateUtils.toCalendar(DateUtils.parseDate("2019-01-26", "yyyy-MM-dd")).get(Calendar.WEEK_OF_YEAR);
            String year = "2017" + (weeksInWeekYear > 9 ? weeksInWeekYear : ("0" + weeksInWeekYear));
            System.out.println(NumberUtils.toInt(year));
        } catch (ParseException e) {
            //Cat.logEvent("[DateUtil]", "shippingWeekFail");
        }
    }

    public void testFormat() {
        Date date = new Date(0);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:DD hh:mm:ss");
        // 1970:01:01 08:00:00
        // 1970:01:01 08:01:00 01是月份
        // 貌似只有MM区分大小写
        System.out.println(sdf.format(date));
    }

    private static final String truncate1 = "truncate table `fake_delivery_2017%s`;";
    private static final String truncate2 = "truncate table `fake_delivery_20170%s`;";

    private static final String truncate3 = "truncate table `order_penalty_%s`;";
    private static final String truncate4 = "truncate table `order_penalty_0%s`;";



    public void testTruncate() {
        for (int i = 24; i <= 52; i++) {
            System.out.println(String.format(truncate1, i));
        }
        for (int i = 1; i <= 4; i++) {
            System.out.println(String.format(truncate2, i));
        }
        for (int i = 24; i <= 52; i++) {
            System.out.println(String.format(truncate3, i));
        }
        for (int i = 1; i <= 4; i++) {
            System.out.println(String.format(truncate4, i));
        }
    }

    public void testUpdate() {
        // 11 7374 2054 63
        System.out.println();
    }
}
