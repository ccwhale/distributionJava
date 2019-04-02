package com.xingxi.map;

import com.xingxi.collections.entity.Apple;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cc
 * @Date 2019-03-12 23:57:57 Tuesday
 */
@Slf4j
public class MapTest extends TestCase {

    static void forEach(Iterable<Map.Entry<String,String>> iterable){
        for(Map.Entry<String,String> entry : iterable){
            log.info("键:{},值:{}",entry.getKey(),entry.getValue());
        }
    }

    public void testKey(){
        Map<String,String> map = new HashMap<>();
        map.put("one","1");
        map.put("two","2");
        map.put("three","3");
        map.keySet().forEach(key->System.out.println(key));
        Map<String, Apple> appleHashMap = new HashMap<>();
        appleHashMap.put("one",new Apple(100,200));
        appleHashMap.put("two",new Apple(100,200));
        appleHashMap.put("three",new Apple(100,200));
        //appleHashMap.keySet().forEach();
        appleHashMap.values().forEach(apple -> {
            // 处理apple的数据
        });
        // 想同时获得key和value
        forEach(map.entrySet());
        for(Map.Entry<String,String> entry :map.entrySet()){
            // 获得key
            entry.getKey();
            // 获得value
            entry.getValue();
        }
        // 返回Set<String>
        for(String key : map.keySet()){

        }
        //返回 Collection<String>
        for(String value : map.values()){

        }

        // 语句lambda 可以 表达式lambda
        map.forEach((key,value)-> {
            log.info("键:{},值:{}",key,value);
        });

        //
        map.forEach((key,value)-> log.info("键:{},值:{}",key,value));
    }

    public void testComparator(){
        List numbers = Arrays.asList(10,1,3,5,7,9,4);
        Collections.sort(numbers);
        log.info("排序之后:{}",numbers);
    }

    // List<T> list 限定传入的是一个集合
    // <T extends Comparable<? super T>> 限制T继承Comparable T或者T的父类操作了Comparable的意思么
    public static <T extends Comparable<? super T>> void sort(List<T> list) {
        list.sort(null);
    }

    // 在java规范中,与顺序有关的行为,通常要不对象本身是Comparable
    // 要不就是另行指定Comparator对象告知排序
    // 本身是Comparable无法修改的时候可以使用Comparator
    public void testString(){
        List<String> words = Arrays.asList("b","A","c","D");
        Collections.sort(words);
        log.info("sort:{}",words);
        Collections.sort(words,(s1,s2)->{
            return -s1.compareTo(s2);
        });
        log.info("sort:{}",words);
    }


}
