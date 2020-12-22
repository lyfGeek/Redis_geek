package com.geek;

import com.alibaba.fastjson.JSONObject;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

/**
 * @author geek
 */
public class TestTX {

    public static void main(String[] args) {

        Jedis jedis = new Jedis("192.168.142.161");

        jedis.flushAll();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("hello", "world");
        jsonObject.put("name", "geek");

        // 事务。
        Transaction multi = jedis.multi();

        String result = jsonObject.toJSONString();
        try {
            multi.set("user1", result);
            multi.set("user2", result);

//            int i = 1 / 0;

            multi.exec();// 执行事务。
        } catch (Exception e) {
            e.printStackTrace();
            multi.discard();// 放弃事务。
        } finally {
            System.out.println(jedis.get("user1"));
            System.out.println(jedis.get("user2"));
            jedis.close();// 关闭连接。
        }

        jedis.close();
    }

}
