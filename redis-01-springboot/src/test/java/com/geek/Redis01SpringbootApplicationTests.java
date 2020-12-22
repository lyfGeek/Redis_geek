package com.geek;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Redis01SpringbootApplicationTests {

    @Autowired
    private RedisTemplate redisTemplate;

    @Test
    public void contextLoads() {
        // 操作字符串。类似 String。
//        redisTemplate.opsForValue()

        // 操作 list。
//        redisTemplate.opsForList()
//
//        redisTemplate.opsForSet()
//        redisTemplate.opsForZSet()
//        redisTemplate.opsForHash()
//        redisTemplate.opsForGeo()
//        redisTemplate.opsForHyperLogLog()

        RedisConnection connection = redisTemplate.getConnectionFactory().getConnection();
        connection.flushAll();
        connection.flushDb();

        redisTemplate.opsForValue().set("mykey", "geek 李");
        System.out.println(redisTemplate.opsForValue().get("mykey"));

    }

    @Test
    public void test() {

    }

}
