package com.xingxi.test;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author xingxi
 * @date 2019-03-11 21:31:58 星期一
 */
@Slf4j
public class collections extends TestCase {

    public void testFailFast(){
        List masterList = new ArrayList();
        masterList.add("one");
        masterList.add("two");
        masterList.add("three");
        masterList.add("four");
        List branchList = masterList.subList(0,3);
        // masterList.remove(0);
        masterList.add("five");
        masterList.clear();

        // java.util.ConcurrentModificationException
        branchList.clear();
        branchList.add("six");
        branchList.add("seven");
        branchList.remove(0);
    }

    public void testForEach(){
        List<String> masterList = new ArrayList();
        masterList.add("one");
        masterList.add("two");
        masterList.add("three");
        masterList.add("four");
        for(String s: masterList){
                masterList.remove(s);
        }
    }

    public void testCopyOnWriteArrayList(){
        // 这个集合适用于读多写极少的场景 cow是fail-safe机制,
        // fail-safe
        List<Long> copy = new CopyOnWriteArrayList<>();
        long start = System.nanoTime();
        for(int i=0;i<20*1000;i++){
            copy.add(System.nanoTime());
        }

    }

    public void testString(){
        String str = "12345";
        SoftReference<String>  softReference = new SoftReference<>(str);
        WeakReference<String> weakReference = new WeakReference<>(str);
        PhantomReference<String> phantomReference = new PhantomReference<>(str,null);

    }

    /**
     * [[Ljava.lang.String;@10dba097
     * [Ljava.lang.String;@1786f9d5
     * [Ljava.lang.String;@1786f9d5
     */
    public void testLength(){
        String[][] excelData = new String[8][];
        excelData[0] = new String[10];
        excelData[1] = new String[7];
        System.out.println(excelData);
        System.out.println(excelData[0]);
        System.out.println(excelData[1]);
        log.info("{}",excelData.length);
        log.info("{}",excelData[0].length);
        //log.info("{}",excelData[0][0]);
    }

    public void testAA(){
        System.out.println(Integer.parseInt("10dba097",16));
        System.out.println(Integer.parseInt("1786f9d5",16)-Integer.parseInt("10dba097",16));
        System.out.println(Integer.parseInt("1786f9d5",16)-Integer.parseInt("1786f9d5",16));
    }
}
