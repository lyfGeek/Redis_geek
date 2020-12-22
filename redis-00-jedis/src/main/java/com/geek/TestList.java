package com.geek;

import redis.clients.jedis.Jedis;

/**
 * @author geek
 */
public class TestList {

    public static void main(String[] args) {

        Jedis jedis = new Jedis("192.168.142.161");

        jedis.flushAll();

        System.out.println("~ ~ ~ ~ ~ ~ ~ 添加一个 List。 ~ ~ ~ ~ ~ ~ ~");
        jedis.lpush("collections", "ArrayList", "Vector", "stack", "HashMap", "WeakHashMap", "linkedList", "HashMap");
        jedis.lpush("collections", "HashSet");
        jedis.lpush("collections", "TreeSet");
        jedis.lpush("collections", "TreeMap");
        System.out.println("Collections 的内容：" + jedis.lrange("Collections", 0, -1));// -1 代表倒数第一个。
        System.out.println("Collections 区间 0 ~ 3 的元素：" + jedis.lrange("Collections", 0, 3));

        System.out.println("～　～　～　～　～　～　～");

        // 删除列表制定的值。第二个参数为删除的个数（有重复时）。后 add 进去的值先被删，类似于出栈。
        System.out.println("删除指定个数元素。 ~ " + jedis.lrem("collections", 2, "HashMap"));
        System.out.println("Collection 的内容。 ~ " + jedis.lrange("collections", 0, -1));
        System.out.println("删除下标 0 ~ 3 之外的元素。 ~ " + jedis.ltrim("collections", 0, 3));
        System.out.println("collections 的内容。 ~ " + jedis.lrange("collections", 0, -1));
        System.out.println("collections 列表出栈（左端）。 ~ " + jedis.lpop("collections"));
        System.out.println("collections 的内容。 ~ " + jedis.lrange("collections", 0, -1));
        System.out.println("collections 从列表右端，与 lpush 相对应。 ~ " + jedis.rpush("collections", "111"));
        System.out.println("collections 的内容。 ~ " + jedis.lrange("collections", 0, -1));
        System.out.println("collections 列表出栈（右端）。 ~ " + jedis.rpop("collections"));
        System.out.println("collections 的内容。 ~ " + jedis.lrange("collections", 0, -1));
        System.out.println("修改 collections 指定下标 1 的内容。 ~ " + jedis.lset("collections", 1, "LinkedList"));
        System.out.println("collections 的内容。 ~ " + jedis.lrange("collections", 0, -1));

        System.out.println("～　～　～　～　～　～　～");

        System.out.println("collections 的长度。 ~ " + jedis.llen("collections"));
        System.out.println("获取 collections 指定下标 2 的元素。 ~ " + jedis.lindex("collections", 2));

        System.out.println("～　～　～　～　～　～　～");

        jedis.lpush("sortedList", "3", "6", "2", "0", "7", "4");
        System.out.println("sortedList 排序前。 ~ " + jedis.lrange("sortedList", 0, -1));
        System.out.println(jedis.sort("sortedList"));
        System.out.println("sortedList 排序后。 ~ " + jedis.lrange("sortedList", 0, -1));
    }

}
