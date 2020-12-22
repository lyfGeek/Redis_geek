package com.geek;

import redis.clients.jedis.Jedis;

import java.util.concurrent.TimeUnit;

/**
 * @author geek
 */
public class TestString {

    public static void main(String[] args) {

        Jedis jedis = new Jedis("192.168.142.161");

        jedis.flushAll();

        System.out.println("~ ~ ~ ~ ~ ~ ~ 添加数据。 ~ ~ ~ ~ ~ ~ ~");
        System.out.println(jedis.set("key1", "value1"));
        System.out.println(jedis.set("key2", "value2"));
        System.out.println(jedis.set("key3", "value3"));
        System.out.println("删除键 key2。 ~ " + jedis.del("key2"));
        System.out.println("获取键 key2。 ~ " + jedis.get("key2"));
        System.out.println("修改 key1。 ~ " + jedis.set("key1", "value1Changed"));
        System.out.println("获取键 key1。 ~ " + jedis.get("key1"));
        System.out.println("在 key3 后面加入值。 ~ " + jedis.append("key3", "End"));
        System.out.println("key3 的值。 ~ " + jedis.get("key3"));
        System.out.println("添加多个键值对。 ~ " + jedis.mset("key01", "value01", "key02", "value02", "key03", "value03"));
        System.out.println("获取多个键值对。 ~ " + jedis.mget("key01", "key02", "key03"));
        System.out.println("获取多个键值对。 ~ " + jedis.mget("key01", "key02", "key03", "key04"));
        System.out.println("删除多个键值对。 ~ " + jedis.del("key01", "key02"));
        System.out.println("获取多个键值对。 ~ " + jedis.mget("key01", "key02", "key03"));

        jedis.flushAll();

        System.out.println("~ ~ ~ ~ ~ ~ ~ 新增键值对防止覆盖原先数据。 ~ ~ ~ ~ ~ ~ ~");
        System.out.println(jedis.setnx("key1", "value1"));
        System.out.println(jedis.setnx("key2", "value2"));
        System.out.println(jedis.setnx("key2", "value2-new"));
        System.out.println(jedis.get("key1"));
        System.out.println(jedis.get("key2"));

        System.out.println("~ ~ ~ ~ ~ ~ ~ 新增键值对并设置有效时间。 ~ ~ ~ ~ ~ ~ ~");
        System.out.println(jedis.setex("key3", 2, "value3"));
        System.out.println(jedis.get("key3"));
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(jedis.get("key3"));

        System.out.println("~ ~ ~ ~ ~ ~ ~ 获取原值并更新为新值。 ~ ~ ~ ~ ~ ~ ~");
        System.out.println(jedis.getSet("key2", "key2GetSet"));
        System.out.println(jedis.get("key2"));

        System.out.println("获得 key2 的值的子串。 ~ " + jedis.getrange("key2", 2, 4));
    }

}
