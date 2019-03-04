package com.xingxi;

import junit.framework.TestCase;

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
}
