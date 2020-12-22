package com.geek;

import redis.clients.jedis.Jedis;

/**
 * @author geek
 */
public class TestSet {

    public static void main(String[] args) {

        Jedis jedis = new Jedis("192.168.142.161", 6379);
        jedis.flushDB();
        System.out.println("~ ~ ~ ~ ~ ~ ~ 向集合中添加元素（不重复）~ ~ ~ ~ ~ ~ ~");
        System.out.println(jedis.sadd("eleSet", "e1", "e2", "e4", "e3", "e0", "e8", "e7", "e5"));
        System.out.println(jedis.sadd("eleSet", "e6"));
        System.out.println(jedis.sadd("eleSet", "e6"));
        System.out.println("eleSet 的所有元素为：" + jedis.smembers("eleSet"));
        System.out.println("删除一个元素 e0：" + jedis.srem("eleSet", "e0"));
        System.out.println("eleSet 的所有元素为：" + jedis.smembers("eleSet"));
        System.out.println("删除两个元素 e7 和 e6：" + jedis.srem("eleSet", "e7", "e6"));
        System.out.println("eleSet 的所有元素为：" + jedis.smembers("eleSet"));
        System.out.println("随机的移除集合中的一个元素：" + jedis.spop("eleSet"));
        System.out.println("随机的移除集合中的一个元素：" + jedis.spop("eleSet"));
        System.out.println("eleSet 的所有元素为：" + jedis.smembers("eleSet"));
        System.out.println("eleSet 中包含元素的个数：" + jedis.scard("eleSet"));
        System.out.println("e3 是否在 eleSet 中：" + jedis.sismember("eleSet", "e3"));
        System.out.println("e1 是否在 eleSet 中：" + jedis.sismember("eleSet", "e1"));
        System.out.println("e1 是否在 eleSet 中：" + jedis.sismember("eleSet", "e5"));

        System.out.println("～　～　～　～　～　～　～");

        System.out.println(jedis.sadd("eleSet1", "e1", "e2", "e4", "e3", "e0", "e8", "e7", "e5"));
        System.out.println(jedis.sadd("eleSet2", "e1", "e2", "e4", "e3", "e0", "e8"));
        System.out.println("将 eleSet1 中删除 e1 并存入 eleSet3 中：" + jedis.smove("eleSet1", "eleSet3", "e1"));// 移到集合元素。
        System.out.println("将 eleSet1 中删除 e2 并存入 eleSet3 中：" + jedis.smove("eleSet1", "eleSet3", "e2"));
        System.out.println("eleSet1 中的元素：" + jedis.smembers("eleSet1"));
        System.out.println("eleSet3 中的元素：" + jedis.smembers("eleSet3"));
        System.out.println("~ ~ ~ ~ ~ ~ ~ 集合运算。~ ~ ~ ~ ~ ~ ~");
        System.out.println("eleSet1 中的元素：" + jedis.smembers("eleSet1"));
        System.out.println("eleSet2 中的元素：" + jedis.smembers("eleSet2"));
        System.out.println("eleSet1 和 eleSet2 的交集：" + jedis.sinter("eleSet1", "eleSet2"));
        System.out.println("eleSet1 和 eleSet2 的并集：" + jedis.sunion("eleSet1", "eleSet2"));
        System.out.println("eleSet1 和 eleSet2 的差集：" + jedis.sdiff("eleSet1", "eleSet2"));// eleSet1 中有，eleSet2 中没有。
        jedis.sinterstore("eleSet4", "eleSet1", "eleSet2");// 求交集并将交集保存到 dstkey 的集合。
        System.out.println("eleSet4 中的元素：" + jedis.smembers("eleSet4"));
    }

}
