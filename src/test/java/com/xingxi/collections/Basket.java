package com.xingxi.collections;

import com.xingxi.collections.entity.Apple;
import com.xingxi.collections.entity.Fruit;

import java.util.Comparator;

/**
 * @author cc
 * @Date 2019-03-12 23:35:35 Tuesday
 */
public class Basket<T> {

    public T[] things;

    public Basket(T... things) {
        this.things = things;
    }

    //    public void sort(Comparator<T> comparator){
//
//    }
    public void sort(Comparator<? super T> comparator) {

    }

    public static void main(String[] args) {
        //此时只需要一个比较器
//        Comparator<Fruit> comparator = (fruit1,fruit2) -> fruit1.getPrice() -fruit2.getPrice();
        Comparator<Fruit> comparator = Comparator.comparing(Fruit::getPrice);

        Basket<Apple> appleBasket = new Basket<>(new Apple(200, 100), new Apple(200, 100));
        appleBasket.sort(comparator);
    }
}
