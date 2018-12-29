package configuration.misc;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

@Configuration
@EnableCaching
public class RedisConfig {
    @Bean
    RedisConnectionFactory redisFactory() {
        return new JedisConnectionFactory();
    }

    @Bean
    RedisTemplate redisTemplate() {
        // return new StringRedisTemplate(redisFactory());

        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate(redisFactory());
        stringRedisTemplate.setValueSerializer(RedisSerializer.json());

//        RedisTemplate<Object, Object> template = new RedisTemplate<>();
//        template.setConnectionFactory(redisFactory());
//
//        template.setDefaultSerializer(new StringRedisSerializer());
//        template.setKeySerializer(RedisSerializer.string());
//        template.setValueSerializer(new JdkSerializationRedisSerializer());
//        template.setHashKeySerializer(RedisSerializer.string());
//        template.setHashValueSerializer(RedisSerializer.string());

        return stringRedisTemplate;
    }

//    @Bean
//    RedisCacheManager cacheManagerOld () {
//        return new RedisCacheManager(redisTemplate());
//    }

    @Bean
    RedisCacheManager cacheManager() {
        RedisCacheConfiguration configuration = RedisCacheConfiguration
                .defaultCacheConfig()
                .computePrefixWith(cacheName -> "nf147." + cacheName)
                .serializeKeysWith(RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.string()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(RedisSerializer.json()));

        return RedisCacheManager.builder(redisFactory()).cacheDefaults(configuration).build();
    }
}
