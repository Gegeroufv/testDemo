package com.shibo.demo;


import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import redis.clients.jedis.Jedis;

//单线程
public class testRedis {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.21.35", 6379);
        jedis.set("hello", "world!");
        System.out.println(jedis.get("hello"));
    }
}
