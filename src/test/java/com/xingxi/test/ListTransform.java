package com.xingxi.test;

import com.google.common.collect.Lists;
import com.xingxi.collections.entity.Account;
import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.core.util.JsonUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xingxi
 * @date 2019-04-15 16:55:59 星期一
 */
@Slf4j
public class ListTransform extends TestCase {

    public void testList2Map() {
        Account account1 = new Account(1L, "1", "1", 111);
        Account account2 = new Account(2L, "2", "2", 222);
        Account account3 = new Account(3L, "3", "3", 333);
        Account account4 = new Account(3L, "4", "4", 444);
        List<Account> accounts = Lists.newArrayList(account1, account2, account3, account4);
        Map<Long, Account> map = accounts.stream().collect(
                // key value 如果主键冲突,保留哪个
                Collectors.toMap(Account::getId, account -> account, (oldKey, newKey) -> oldKey)
        );
        log.info("输出Map:{}", map.toString());
    }

    public void testGetListInfo(){
        Account account1 = new Account(1L, "1", "1", 111);
        Account account2 = new Account(2L, "2", "2", 222);
        Account account3 = new Account(3L, "3", "3", 333);
        Account account4 = new Account(3L, "4", "4", 444);
        List<Account> accounts = Lists.newArrayList(account1, account2, account3, account4);
        List<String> names = Lists.transform(accounts,account -> account.getName());
        for(String str :names){
            log.info("获取集合中某个字段:{}", str);
        }
    }
}
