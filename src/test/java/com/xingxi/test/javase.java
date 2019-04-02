package com.xingxi.test;

//import entity.Person;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author xingxi
 * @date 2019-03-01 20:25:06 星期五
 */
@Slf4j
public class javase extends TestCase {


//    public void testApp() {
//        List<Person> list;
//        Person p1 = new Person("a", 12, "aaa");
//        Person p2 = new Person("b", 11, "bbb");
//        Person p3 = new Person("c", 11, "ccc");
//        Person p4 = new Person("d x x", 15, "ddd");
//        list = Arrays.asList(p1, p2, p3, p4);
//
//        List<Person> temp = list.stream().filter(person -> (person.getAge() > 11 && "d".equals(person.getName())))
//                .collect(Collectors.toList());
//        System.out.println(temp);
//        System.out.println(list);
//
//        //获取person的名字
//        List<String> collect = list.stream().map(person -> person.getName())
//                .collect(Collectors.toList());
//        System.out.println(collect);
//
//        //flatMap测试 [a, b, c, d, x, x]
//        List<String> flatMap = list.stream().
//                flatMap(person -> Arrays.stream(person.getName().split(" "))).
//                collect(Collectors.toList());
//        System.out.println(flatMap);
//
//        Integer reduce = Stream.of(1, 2, 3, 4).reduce(10, (count, item) -> {
//            System.out.println("count:" + count);
//            System.out.println("item:" + item);
//            return count+item;
//        });
//        System.out.println(reduce);
//
//        Integer reduce1 = Stream.of(1, 2, 3, 4).reduce(1, (x, y) -> {
//            return x+y;
//        });
//        System.out.println(reduce1);
//
//        //collect()里面可以是toList() toSet() Collectors.joining()
//        //Collect()
//    }

    public void testLog(){
        Random random = new Random();
        log.info("nextLong:{}",random.nextLong());
        log.info("nextLong:{}",random.nextLong());
        log.info("nextLong:{}",random.nextLong());
        log.info("nextLong:{}",random.nextLong());
        log.info("nextInt:{}",random.nextInt());
        log.info("nextInt:{}",random.nextInt());
        log.info("nextInt:{}",random.nextInt());
        log.info("nextInt:{}",random.nextInt(200));
    }
}
