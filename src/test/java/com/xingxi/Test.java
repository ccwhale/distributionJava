package com.xingxi;

import com.xingxi.websocket.Person;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @author cc
 * @Date 2019-03-03 23:04:04 Sunday
 */
@Slf4j
public class Test extends TestCase {

    private Optional<String> getNickName(String name){
        Map<String,String> nicknames = new HashMap<>();
        nicknames.put("xiejq","hahha");
        nicknames.put("xingxi","hahha");
        nicknames.put("baobao","hahha");
        return Optional.ofNullable(nicknames.get(name));

    }

    public void testNullable(){
        Optional<String> nickName = getNickName("hhh");
        if(nickName.isPresent()){
            System.out.print(getNickName("hhh").get());

        }
       System.out.print(getNickName("hhh").orElse("默认值"));
    }

    public void testDate(){
        LocalTime localTime = LocalTime.of(0,0,0);
        LocalDate localDate = LocalDate.of(1975,4,1);
        ZonedDateTime zonedDateTime = ZonedDateTime.of(localDate,localTime, ZoneId.of("Asia/Taipei"));

        System.out.print(zonedDateTime);
        System.out.print(zonedDateTime.toEpochSecond());
        System.out.print(zonedDateTime.toInstant().toEpochMilli());

    }

    public void testReverse() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("D:\\xingxi")));
        Person person = (Person)ois.readObject();
        log.info("读取的数据:{}",person.getName());
    }

    //"startId":3116007443,"endId":3955749226,"steps":2000}
    // 839741783
    // 419870 要执行41万次
    public void testMinus(){
        System.out.println(3118493443L-3116007443L);
    }

    public void testQPS(){
        // 1111
        System.out.println(4000000/(60*60));
        // 单纯更新 一分钟处理三万条数据
    }

    public void testEmptyList(){
        List<String> list = Collections.emptyList();
        List<String> list1 = new ArrayList<>();
        list1.add("123445");
        list1.add("123445");
        list1.add("123445");
        list1.add("123445");
        list = list1;
        list.forEach((key)->System.out.println(key));
    }


}
