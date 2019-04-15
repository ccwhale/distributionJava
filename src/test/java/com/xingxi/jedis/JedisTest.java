package com.xingxi.jedis;

import junit.framework.TestCase;
import org.apache.commons.lang3.math.NumberUtils;
import org.apache.commons.lang3.time.DateUtils;
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

    // 获取今天的shipweek
    public void testWeek() throws ParseException {
        try {
            int weeksInWeekYear = DateUtils.toCalendar(DateUtils.parseDate("2019-01-27","yyyy-MM-dd")).get(Calendar.WEEK_OF_YEAR);
            String year = "2017" + (weeksInWeekYear>9 ? weeksInWeekYear : ("0" + weeksInWeekYear));
            System.out.println(NumberUtils.toInt(year));
        } catch (ParseException e) {
            //Cat.logEvent("[DateUtil]", "shippingWeekFail");
        }
    }

    public void testFormat(){
        Date date =new Date(0);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy:MM:DD hh:mm:ss");
        // 1970:01:01 08:00:00
        // 1970:01:01 08:01:00 01是月份
        // 貌似只有MM区分大小写
        System.out.println(sdf.format(date));
    }

    private static final String update1 = "ALTER TABLE `express_penalty`.`fake_summary_express_20170%s`" +
            "  ADD  UNIQUE INDEX `uk_goods_id_mall_id_shipping_time_goods_type` (`goods_id`, `mall_id`, `shipping_time`);";
    private static final String update2 = "ALTER TABLE `express_penalty`.`fake_summary_express_2017%s`" +
            "  ADD  UNIQUE INDEX `uk_goods_id_mall_id_shipping_time_goods_type` (`goods_id`, `mall_id`, `shipping_time`);";
    private static final String drop1 = "ALTER TABLE `express_penalty`.`fake_summary_express_20170%s`" +
            "  DROP INDEX `uk_goods_id_mall_id_shipping_time_goods_type`;";
    private static final String drop2 = "ALTER TABLE `express_penalty`.`fake_summary_express_2017%s`" +
            "  DROP INDEX `uk_goods_id_mall_id_shipping_time_goods_type`;";

    public void testUpdate(){
        // 28842748
       int count = 3089986+2861389+2746005+2491774+2512941+2216151+2289589 +1965408+1882814+1386854+1082822+889296+788064+696410+577175+433504+359862+183937+100057+110006+63717+70704+44283+3205638 ;
       int count1 = 3151705+3035104+2775507+2620697+2475302+2427749+2320286 +2165857 +1900933 +1854966 +1318051 +1092583 +907216 +805279 +698683 +592224 +394724 +360107 +169726+114543 +108759 +79419 +54537 +37816+13610;
       int count2 = 3205638 +3124960 +2939810 +2732747 +2519160 +2492125 +2443816 +2202058 +1970912 +1812302 +1368721 +1072726 +954849 +828056 +730985 +602905 +404546 +358880 +205524 +120747 +85131 +79347 +57906 +30326;
        System.out.println(count);
       System.out.println(count1);
        System.out.println(count2);
    }

    //-- 7923	   134895	10583	32824113	7988	NULL	1774
    //-- 33019086	NULL	38585	32	        NULL	NULL	38573
    public void testMinus(){
        // System.out.println(4020571093L-3144458443L);
        // 被修改的数据
        System.out.println(7923+134895+10583+32824113+7988+1774);
        // 第一天的数据
        System.out.println(33019086+38585+32+38573);

        //109000
        System.out.println(33096276-32987276);

        // 17923	134895	10583	32824113	7988	NULL	1774
        System.out.println(17923+134895+10583+32824113+7988+1774);
    }


}
