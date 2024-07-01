package com.graphql.config;

import java.time.Duration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;

@Configuration
@EnableRedisRepositories
public class RedisConfiguration {

	/*
	 * @Bean JedisConnectionFactory jedisConnectionFactory() {
	 * JedisConnectionFactory jedisConFactory = new JedisConnectionFactory();
	 * jedisConFactory.setHostName("localhost"); jedisConFactory.setPort(6379);
	 * return jedisConFactory; }
	 * 
	 * @Bean public RedisTemplate<String, Object> redisTemplate() {
	 * RedisTemplate<String, Object> template = new RedisTemplate<>();
	 * template.setConnectionFactory(jedisConnectionFactory()); return template; }
	 * 
	 * @Bean public RedisCacheConfiguration cacheConfiguration() { return
	 * RedisCacheConfiguration.defaultCacheConfig().entryTtl(Duration.ofMinutes(60))
	 * .disableCachingNullValues()
	 * .serializeValuesWith(SerializationPair.fromSerializer(new
	 * GenericJackson2JsonRedisSerializer())); }
	 */
	
	@Bean
    public RedisConnectionFactory redisConnectionFactory() {
        return new LettuceConnectionFactory();
    }

    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }

    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        return new StringRedisTemplate(redisConnectionFactory);
    }

}
