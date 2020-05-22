package com.dyh.peachsys.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author Peach-華
 * @version V1.0
 * @desc redis的配置
 * @copyright &copy; DYH
 * @date 2020/5/18-22:08
 * @address 成都
 */
@Configuration //让Spring来加载该类配置
@EnableCaching //开启缓存
public class RedisConfig {
    //编写自己的配置
    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();

        //JSON序列化实例
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
        ObjectMapper obj = new ObjectMapper();//转义对象
        obj.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        obj.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(obj);

        //String 序列化实例
        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();

        /**
         * 配置序列化方式
         * 根据需要设置序列化方式
         */
        // key 的序列化方式
        template.setKeySerializer(stringRedisSerializer);
        // hash key的序列化方式
        template.setHashKeySerializer(stringRedisSerializer);
        //value的序列化方式
        template.setValueSerializer(stringRedisSerializer);
        // hash value的序列化方式
        template.setHashValueSerializer(stringRedisSerializer);

        //配置连接工程
        template.setConnectionFactory(redisConnectionFactory);
        return template;
    }
}
