package com.xingxi.base;

import junit.framework.TestCase;

/**
 * @author cc
 * @Date 2019-04-23 00:19:19 Tuesday
 */
public class JavaBaseTest extends TestCase {

    /**
     * jdk1.0-1.4 数据类型接受 byte short int char
     * jdk1.5 byte short int char enum
     * jdk1.7 byte short int char enum String
     */
    public void testSwitch() {
        String str = "str";
        // 变量或表达式
        switch (str) {
            case "str":
                System.out.println();
                break;
        }
    }

    // 1 3 4 都能满足条件 选哪个选1
    // Java中没有真的if..else if 语法,是省略{}加上程序代码排版后的结果
    public void testIfElse(){
        String str1 = "1";
        String str2 = "2";
        String strE = new String("1");
        if(str1.equals(strE)){
            System.out.println("1");
        }else if(str1.equals(str2)){
            System.out.println("2");
        }else if(1==1){
            System.out.println("3");
        }else if(1==1){
            System.out.println("4");
        }else{
            System.out.println("5");
        }

        if(str1.equals(strE)){
            System.out.println("1");
        }else{
            if(str1.equals(str2)){
                System.out.println("2");
            }else{
                if(1==1){
                    System.out.println("3");
                }else{
                    if(1==1){
                        System.out.println("4");
                    }else{
                        System.out.println("5");
                    }
                }
            }
        }
    }

    public void testWhileLoop(){
        while(true){
            break;
        }

        do{

        }while (true);
    }
}
