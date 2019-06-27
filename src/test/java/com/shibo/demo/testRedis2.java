package com.shibo.demo;

import com.shibo.demo.jpaTest.entity.Student;
import com.shibo.demo.jpaTest.repository.StuRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.support.atomic.RedisAtomicLong;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;

@RunWith(SpringRunner.class)
@SpringBootTest
public class testRedis2 {
    @Autowired
    RedisTemplate<String,String> redisTemplate;
    @Autowired
    StuRepo stuRepo;
    @Autowired
    JedisConnectionFactory jedisConnectionFactory;
    @Test
    public void test1() {
        System.out.println(this.redisTemplate.opsForValue().multiGet(new ArrayList(){{
            add("hello");
            add("hello1");
        }}));
        Student stu=this.stuRepo.findByName("111");
        System.out.println(stu);
        this.redisTemplate.opsForHash().put("store","stu",stu);
        System.out.println(this.redisTemplate.getHashValueSerializer());
        System.out.println(this.redisTemplate.opsForHash().get("store","stu"));
    }

    @Test
    public void test2(){
        //原子计数器
        String counter="counter";
        RedisAtomicLong redisAtomicLong=new RedisAtomicLong("counter",jedisConnectionFactory,0);
        System.out.println(redisAtomicLong.addAndGet(1));
    }

    @Test
    public void test3(){
        //获取原子计数器
        RedisAtomicLong redisAtomicLong=new RedisAtomicLong("counter",jedisConnectionFactory);
        System.out.println(redisAtomicLong);
    }
    /**
     * redisTemplate.opsForValue()
     * redisTemplate.opsForList()
     * ...
     * redisTemplate.opsForSet()
     * redsiTemplate.opsForZSet()//操作有序set
     */
    @Test
    public void test4(){
        System.out.println(this.stuRepo.findByName("111"));
        System.out.println(this.stuRepo.findByName("helloworld!"));
    }
}
