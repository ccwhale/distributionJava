package com.xingxi;

import junit.framework.TestCase;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

/**
 * @author cc
 * @Date 2019-03-03 23:04:04 Sunday
 */
public class test extends TestCase {

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
}
