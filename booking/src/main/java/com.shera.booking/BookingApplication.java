package com.shera.booking;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static java.util.Collections.singletonMap;
import static org.springframework.data.redis.cache.RedisCacheConfiguration.defaultCacheConfig;

@SpringBootApplication
public class BookingApplication {


//	@Bean
//	public RedisCacheManager cacheManager() {
//		RedisCacheConfiguration config = defaultCacheConfig()
//				.entryTtl(Duration.ofSeconds(1))
//				.disableCachingNullValues();
//
//		RedisCacheManager cm = RedisCacheManager.builder(jedisConnectionFactory())
//				.cacheDefaults(config)
//				.withInitialCacheConfigurations(singletonMap("predefined", defaultCacheConfig().disableCachingNullValues()))
//				.transactionAware()
//				.build();
//		return cm;
//	}

//	@Bean
//	JedisConnectionFactory jedisConnectionFactory() {
//		JedisConnectionFactory jedisConFactory
//				= new JedisConnectionFactory();
//		jedisConFactory.setHostName("127.0.0.1");
//		jedisConFactory.setPort(6379);
//		return jedisConFactory;
//	}

	public static void main(String[] args) {
		SpringApplication.run(BookingApplication.class, args);
	}

}
