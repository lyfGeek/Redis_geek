package com.geek;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * @author geek
 */
public class TestKey {

    public static void main(String[] args) {

        Jedis jedis = new Jedis("192.168.142.161");

        jedis.flushAll();

        System.out.println("清空数据。 ~ " + jedis.flushAll());
        System.out.println("判断某个键是否存在。 ~ " + jedis.exists("username"));
        System.out.println("新增<'username', 'geek'>键值对。 ~ " + jedis.set("username", "geek"));
        System.out.println("新增<'password', 'password'>键值对。 ~ " + jedis.set("password", "password"));
        System.out.println("系统中所有的键。↓ ↓ ↓");
        Set<String> keys = jedis.keys("*");
        System.out.println("keys = " + keys);
        System.out.println("删除键 password。 ~ " + jedis.del("password"));
        System.out.println("判断键 password 是否存在。 ~ " + jedis.exists("password"));
        System.out.println("查看键 username 所存储的类型。" + jedis.type("username"));
        System.out.println("随机返回一个。" + jedis.randomKey());
        System.out.println("重命名 key。" + jedis.rename("username", "name"));
        System.out.println("取出改后的 name。" + jedis.get("name"));
        System.out.println("按索引查询。" + jedis.select(0));
        System.out.println("返回当前数据库中 key 的数量。" + jedis.dbSize());
        System.out.println("删除当前选择数据库中的所有 key。" + jedis.flushDB());
        System.out.println("删除所有数据库中的所有 key。" + jedis.flushAll());
    }

}
