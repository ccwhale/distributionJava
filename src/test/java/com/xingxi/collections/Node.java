package com.xingxi.collections;

import lombok.AllArgsConstructor;

/**
 * @author cc
 * @Date 2019-03-11 23:33:33 Monday
 */
@AllArgsConstructor
public class Node<T> {

    public T value;

    public Node<T> next;
}
