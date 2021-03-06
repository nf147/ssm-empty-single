package the_mass.redis;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
@ComponentScan("the_mass.redis")
public class SpringConfig {

    @Bean
    RedisConnectionFactory redisFactory () {
        return new JedisConnectionFactory();
    }

    @Bean
    RedisTemplate redisTemplate () {
        return new StringRedisTemplate(redisFactory());
    }
}
