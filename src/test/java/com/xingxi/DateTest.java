package com.xingxi;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/**
 * @author xingxi
 * @date 2019-04-29 17:30:19 星期一
 *
 * https://www.cnblogs.com/wihainan/p/5999771.html 脑阔有点疼,留着学习
 */
@Slf4j
public class DateTest extends TestCase {

    public static String format(Date date, String format) {
        if (date == null || StringUtils.isBlank(format)) {
            return StringUtils.EMPTY;
        }
        // joda创建时间
        return new DateTime(date).toString(format, Locale.SIMPLIFIED_CHINESE);
    }

    public static String getTimeDaysBefore(int offset, String format) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DAY_OF_MONTH, offset);
        return format(c.getTime(), format);
    }


    public void testDate() {
        // 使用jdk自带的
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, Calendar.JANUARY, 1, 0, 0, 0);

        // jdk的方式向某一个瞬间加上90天
        SimpleDateFormat sdf = new SimpleDateFormat("E MM/dd/yyyy HH:mm:ss.SSS");
        calendar.add(Calendar.DAY_OF_MONTH, 90);
        log.info("jdk输出结果:{}", sdf.format(calendar.getTime()));

        // 使用joda创建2000年1月1日0时0分
        DateTime dateTime = new DateTime(2000, 1, 1, 0, 0, 0, 0);
        log.info("joda输出结果:{}", dateTime.plusDays(90).toString("E MM/dd/yyyy HH:mm:ss.SSS"));
    }

    public void testJoda() {
        // jdk的时间转化为joda的时间
        DateTime dateTime = new DateTime(new Date().getTime());
        DateTime dateTime1 = new DateTime(new Date());
    }

    public void testLength(){
        System.out.println("190105-038378210450155".length());
    }


}
