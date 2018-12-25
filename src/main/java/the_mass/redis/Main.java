package the_mass.redis;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);

        RedisService redisService = context.getBean(RedisService.class);
        redisService.testRedis();
        redisService.testRedisTemplate();
    }
}
