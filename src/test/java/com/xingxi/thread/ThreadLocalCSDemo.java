package com.xingxi.thread;

import java.util.concurrent.ThreadLocalRandom;

/**
 * @author xingxi
 * @date 2019-04-16 21:58:12 星期二
 */
public class ThreadLocalCSDemo {
    private static final Integer BULLET_NUMBER = 1500;
    private static final Integer KILLED_NUMBER = 0;
    private static final Integer LIFE_NUMBER = 10;
    private static final Integer TOTAL_PLEYERS = 10;

    private static final ThreadLocalRandom RANDOM = ThreadLocalRandom.current();

    private static final ThreadLocal<Integer> BULLET_NUMBER_THREADLOCAL =
            new ThreadLocal<Integer>() {
                @Override
                protected Integer initialValue() {
                    return BULLET_NUMBER;
                }
            };
    private static final ThreadLocal<Integer> KILLED_NUMBER_THREADLOCAL = ThreadLocal.withInitial(() -> KILLED_NUMBER);
    private static final ThreadLocal<Integer> LIFE_NUMBER_THREADLOCAL = ThreadLocal.withInitial(() -> LIFE_NUMBER);

    private static final ThreadLocal<Integer> BULLET_NUMBER_THREADLOCAL1 = ThreadLocal.withInitial(() -> BULLET_NUMBER);

    private static class Player extends Thread {
        @Override
        public void run() {
            Integer bullets = BULLET_NUMBER_THREADLOCAL.get() - RANDOM.nextInt(BULLET_NUMBER);
            Integer killedEnemies = KILLED_NUMBER_THREADLOCAL.get() - RANDOM.nextInt(TOTAL_PLEYERS / 2);
            Integer lifeValue = LIFE_NUMBER_THREADLOCAL.get() - RANDOM.nextInt(LIFE_NUMBER);
            System.out.println(getName() + ",BULLET_NUMBER is " + bullets);
            System.out.println(getName() + ",KILLED_NUMBER is " + killedEnemies);
            System.out.println(getName() + ",LIFE_NUMBER is " + lifeValue);
            BULLET_NUMBER_THREADLOCAL.remove();
            KILLED_NUMBER_THREADLOCAL.remove();
            LIFE_NUMBER_THREADLOCAL.remove();
        }
    }

    // 测试结果,每个线程的都是一样的输出
    public static void main(String[] args) {
        for (int i = 0; i < TOTAL_PLEYERS; i++) {
            new Player().start();
        }
    }


}
