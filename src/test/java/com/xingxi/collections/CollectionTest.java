package com.xingxi.collections;

import com.xingxi.collections.entity.Apple;
import com.xingxi.collections.entity.Banana;
import com.xingxi.collections.entity.Fruit;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author cc
 * @Date 2019-03-11 23:29:29 Monday
 */
@Slf4j
public class CollectionTest extends TestCase {

    public static void show(Node<? extends Fruit> n) {
        Node<? extends Fruit> node = n;
        do {
            log.info("node的值:{}", node.value);
            node = node.next;
        } while (node != null);
    }

    public void testNode(){
        Node<Fruit> appleNode1 = new Node<>(new Fruit(),null);
        Node<Fruit> appleNode2 = new Node<>(new Fruit(),appleNode1);
        Node<Fruit> appleNode3 = new Node<>(new Fruit(),appleNode2);
        show(appleNode3);

        Node<Banana> bananaNode = new Node<>(new Banana(),null);
        // cant infer arguments
        Node<Banana> bananaNode1 = new Node<>(new Banana(),bananaNode);
        show(bananaNode1);
    }

    public void testSuper(){
        Node<Fruit> fruitNode = new Node<>(new Fruit(),null);
        // 编译出错
        // Node<Banana> node = fruitNode;
        Node<? super Banana> node = fruitNode;
        Node<? super Apple> node1 = fruitNode;
    }

    public void testDequeue(){
        Deque<Integer> stack = new LinkedList<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        log.info("弹出:{}",stack.pop());
        log.info("弹出:{}",stack.pop());
        log.info("弹出:{}",stack.pop());
    }
}
