package com.tangjianghua.redis.rediscluster;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.redis.connection.RedisClusterConnection;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.List;

@SpringBootApplication
public class RedisClusterApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(RedisClusterApplication.class, args);
        StringRedisTemplate stringRedisTemplate = context.getBean(StringRedisTemplate.class);
  /*      stringRedisTemplate.watch("k1");
        stringRedisTemplate.multi();
        ValueOperations<String, String> stringStringValueOperations = stringRedisTemplate.opsForValue();
        stringStringValueOperations.set("k1","adsfs");
        System.out.println(stringStringValueOperations.get("k1"));
        List<Object> exec = stringRedisTemplate.exec();
        System.out.println(exec.toArray());*/

        RedisConnection connection = stringRedisTemplate.getConnectionFactory().getClusterConnection();
//        connection.watch("k1".getBytes());
//        connection.multi();
        connection.set("k1".getBytes(),"adsfs".getBytes());
        connection.set("k2".getBytes(),"adsfs".getBytes());
        connection.set("k3".getBytes(),"adsfs".getBytes());
        System.out.println(new String(connection.get("k1".getBytes())));
//        List<Object> exec1 = connection.exec();
//        System.out.println(exec1.toArray());
    }

}
