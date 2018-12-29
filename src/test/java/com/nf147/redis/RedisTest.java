package com.nf147.redis;

import com.nf147.ssms.entity.News;
import configuration.RootConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class RedisTest {

    @Autowired
    RedisOperations redisOperations;

    @Test
    public void first () {
        News news = new News("刘强东", "释放了");

        redisOperations.opsForValue().set("hello", news);
    }

}
