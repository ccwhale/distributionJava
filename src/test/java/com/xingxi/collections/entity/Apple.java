package com.xingxi.collections.entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * @author cc
 * @Date 2019-03-11 23:27:27 Monday
 */
public class Apple extends Fruit {

    public Apple(int price, int weight) {
        super(price, weight);
    }

    public Apple() {
    }

    @Override
    public String toString() {
        return "Apple";
    }
}
