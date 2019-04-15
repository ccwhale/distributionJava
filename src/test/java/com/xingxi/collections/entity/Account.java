package com.xingxi.collections.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

/**
 * @author cc
 * @Date 2019-03-13 00:32:32 Wednesday
 */
@Data
@ToString
@AllArgsConstructor
public class Account implements Comparable<Account> {

    private Long id;

    private String name;

    private String number;

    private int balance;

    @Override
    public int compareTo(Account o) {
        return this.balance - o.getBalance();
    }

}
