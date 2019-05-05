package com.xingxi.experience;

import junit.framework.TestCase;

/**
 * @author xingxi
 * @date 2019-04-23 18:54:05 星期二
 * 列出可能报出空指针异常的情况
 */
public class NPETest extends TestCase {


    // dubbo接口返回布尔类型,程序直接if(str)会有NPE
    public void testBool(){
        Boolean str = null;
        if(str){
            System.out.println(str);
        }
    }

}
