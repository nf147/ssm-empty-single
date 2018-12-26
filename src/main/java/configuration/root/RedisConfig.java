package configuration.root;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class RedisConfig {
    @Bean
    RedisConnectionFactory redisFactory () {
        return new JedisConnectionFactory();
    }

    @Bean
    RedisTemplate redisTemplate () {
        return new StringRedisTemplate(redisFactory());
    }
}
