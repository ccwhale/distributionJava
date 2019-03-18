package com.xingxi.thread;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

/**
 * @author cc
 * @Date 2019-03-18 23:36:36 Monday
 */
@Slf4j
public class SoftReferenceHouse extends TestCase {

    public static void main(String[] args) {
        //List<House> housesStrong = new ArrayList<>();
        List<SoftReference> houses = new ArrayList<SoftReference>();

        int i = 0;
        while (true) {
            SoftReference<House> buyer2 = new SoftReference<House>(new House());
            houses.add(buyer2);
            //housesStrong.add(new House());
            log.info("i={}", (++i));
        }
    }
}

class House {
    private static final Integer DOOR_NUMBER = 2000;
    public Door[] doors = new Door[DOOR_NUMBER];

    class Door {
    }
}

