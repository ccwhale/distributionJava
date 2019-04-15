package com.xingxi.test.guava;

import com.google.common.base.Function;
import com.google.common.collect.Iterators;
import com.google.common.collect.Lists;
import junit.framework.TestCase;

import java.util.Iterator;
import java.util.List;

/**
 * @author xingxi
 * @date 2019-04-15 15:44:23 星期一
 */
public class GuavaTest extends TestCase {

    public void testGuava() {
        List<String> list = Lists.newArrayList("Apple", "Pear", "Peach", "Banana");
        Iterator<Integer> countIterator = Iterators.transform(list.iterator(), new Function<String, Integer>() {
            @Override
            public Integer apply(String input) {
                return input.length();
            }
        });
        System.out.println(countIterator);
        while (countIterator.hasNext()) {
            // countIterator是实时计算的 如果list中保存的值改变 会随着改变
            System.out.println(countIterator.next());
        }

        Iterator<Integer> countIterator1 = Iterators.transform(list.iterator(), (input) -> input.length());

        Iterator<Integer> countIterator2 = Iterators.transform(list.iterator(), input -> input.length());

        // 什么时候用方法引用 method reference
        Iterator<Integer> countIterator3 = Iterators.transform(list.iterator(), String::length);


    }
}
