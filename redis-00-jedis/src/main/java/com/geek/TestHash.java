package com.geek;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * @author geek
 */
public class TestHash {

    public static void main(String[] args) {

        Jedis jedis = new Jedis("192.168.142.161", 6379);
        jedis.flushAll();
        Map<String, String> map = new HashMap<String, String>();
        map.put("key1", "value1");
        map.put("key2", "value2");
        map.put("key3", "value3");
        map.put("key4", "value4");
        // 添加名称为 hash（key）的 hash 元素。
        jedis.hmset("hash", map);
        // 向名称为 hash 的 hash 中添加 key 为 key5，value 为 value5 元素。
        jedis.hset("hash", "key5", "value5");
        System.out.println("散列 hash 的所有键值对为：" + jedis.hgetAll("hash"));// return Map<String,String>
        System.out.println("散列 hash 的所有键为：" + jedis.hkeys("hash"));// return Set<String>
        System.out.println("散列 hash 的所有值为：" + jedis.hvals("hash"));// return List<String>
        System.out.println("将 key6 保存的值加上一个整数，如果 key6 不存在则添加 key6：" + jedis.hincrBy("hash", "key6", 6));
        System.out.println("散列 hash 的所有键值对为：" + jedis.hgetAll("hash"));
        System.out.println("将 key6 保存的值加上一个整数，如果 key6 不存在则添加 key6：" + jedis.hincrBy("hash", "key6", 3));
        System.out.println("散列 hash 的所有键值对为：" + jedis.hgetAll("hash"));
        System.out.println("删除一个或者多个键值对：" + jedis.hdel("hash", "key2"));
        System.out.println("散列 hash 的所有键值对为：" + jedis.hgetAll("hash"));
        System.out.println("散列 hash 中键值对的个数：" + jedis.hlen("hash"));
        System.out.println("判断 hash 中是否存在key2：" + jedis.hexists("hash", "key2"));
        System.out.println("判断 hash 中是否存在key3：" + jedis.hexists("hash", "key3"));
        System.out.println("获取 hash 中的值：" + jedis.hmget("hash", "key3"));
        System.out.println("获取 hash 中的值：" + jedis.hmget("hash", "key3", "key4"));
    }

}
