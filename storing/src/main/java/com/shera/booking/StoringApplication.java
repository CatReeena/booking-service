package com.shera.booking;

import com.shera.booking.entity.Seat;
import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.sql.SQLException;

@SpringBootApplication
@EnableCaching
public class StoringApplication {

    public static void main(String[] args) {

        SpringApplication.run(StoringApplication.class, args);
    }

//    @Bean
//    JedisConnectionFactory jedisConnectionFactory(){
//        return new JedisConnectionFactory();
//    }
//
//    @Bean
//    RedisTemplate<String, BookingRequest> redisTemplate(){
//        RedisTemplate<String, BookingRequest> redisTemplate = new RedisTemplate<>();
//        redisTemplate.setConnectionFactory(jedisConnectionFactory());
//        return redisTemplate;
//    }
//
//    @Bean
//    public RedisCacheManager cacheManager() {
//        return RedisCacheManager.create(jedisConnectionFactory());
//    }

    @Bean(initMethod = "start", destroyMethod = "stop")
    public Server h2Server() throws SQLException {
        return Server.createTcpServer("-tcp", "-tcpAllowOthers", "-tcpPort", "9090");
    }

}


