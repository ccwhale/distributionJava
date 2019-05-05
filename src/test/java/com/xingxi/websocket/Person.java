package com.xingxi.websocket;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import java.io.Serializable;

/**
 * @author xingxi
 * @date 2019-03-21 19:23:33 星期四
 */
@Data
@Slf4j
@AllArgsConstructor
public class Person implements Serializable {

    private static final long serialVersionUID = -171096289253009926L;
    private String name;
    private int age;
    private String remark;

//    public static void main(String[] args) throws IOException {
//        Person person = new Person();
//        person.setName("cc");
//        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(new File("D:\\xingxi")));
//        oo.writeObject(person);
//        oo.close();
//    }

}
