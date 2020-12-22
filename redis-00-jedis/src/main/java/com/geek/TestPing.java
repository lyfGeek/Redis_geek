package com.geek;

import redis.clients.jedis.Jedis;

public class TestPing {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.142.161", 6379);
        String ping = jedis.ping();
        System.out.println("ping = " + ping);
        // ping = PONG

        // Exception in thread "main" redis.clients.jedis.exceptions.JedisDataException: DENIED Redis is running in protected mode because protected mode is enabled, no bind address was specified, no authentication password is requested to clients. In this mode connections are only accepted from the loopback interface. If you want to connect from external computers to Redis you may adopt one of the following solutions: 1) Just disable protected mode sending the command 'CONFIG SET protected-mode no' from the loopback interface by connecting to Redis from the same host the server is running, however MAKE SURE Redis is not publicly accessible from internet if you do so. Use CONFIG REWRITE to make this change permanent. 2) Alternatively you can just disable the protected mode by editing the Redis configuration file, and setting the protected mode option to 'no', and then restarting the server. 3) If you started the server manually just for testing, restart it with the '--protected-mode no' option. 4) Setup a bind address or an authentication password. NOTE: You only need to do one of the above things in order for the server to start accepting connections from the outside.
        //	at redis.clients.jedis.Protocol.processError(Protocol.java:127)
        //	at redis.clients.jedis.Protocol.process(Protocol.java:161)
        //	at redis.clients.jedis.Protocol.read(Protocol.java:215)
        //	at redis.clients.jedis.Connection.readProtocolWithCheckingBroken(Connection.java:340)
        //	at redis.clients.jedis.Connection.getStatusCodeReply(Connection.java:239)
        //	at redis.clients.jedis.BinaryJedis.ping(BinaryJedis.java:196)
        //	at com.geek.TestPing.main(TestPing.java:9)
    }

}
