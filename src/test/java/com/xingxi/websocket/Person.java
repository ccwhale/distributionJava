package com.xingxi.websocket;

import junit.framework.TestCase;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * @author xingxi
 * @date 2019-03-21 19:23:33 星期四
 */
@Data
@Slf4j
public class Person implements Serializable {

    private static final long serialVersionUID = -171096289253009926L;
    private String name;

//    public static void main(String[] args) throws IOException {
//        Person person = new Person();
//        person.setName("cc");
//        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(new File("D:\\xingxi")));
//        oo.writeObject(person);
//        oo.close();
//    }

}
