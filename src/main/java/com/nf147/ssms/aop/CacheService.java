package com.nf147.ssms.aop;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

// TODO: 酌情实现，增加注解，类似于 Spring Cache，而且要让它更通用

@Aspect
@Component
public class CacheService {
    @Around(value = "@annotation(com.nf147.ssms.aop.MyCacheable)")
    public Object listNews(ProceedingJoinPoint point) throws Throwable {
        ObjectMapper om = new ObjectMapper();
        Jedis jedis = new Jedis();
        String[] s1 = point.getSignature().toLongString().split(" ");
        Class<?> aClass = Class.forName(s1[2]);
        String methodName = point.getSignature().getName();
        String returnValue = jedis.get(methodName);
        if (returnValue != null) {
            return om.readValue(returnValue, aClass);
        } else {
            Object proceed = point.proceed();
            String s = om.writeValueAsString(proceed);
            jedis.set(methodName, s);
            return proceed;
        }

        /*
        Jedis jedis = new Jedis();
        String key = "";

        ObjectMapper om = new ObjectMapper();
        if (jedis.exists(key)) {
            return om.readValue(jedis.get(key), new TypeReference<List<News>>() {
            });
        }

        List<News> news = (List<News>) point.proceed();
        System.out.println(point.getSignature().getDeclaringType());
        System.out.println(point.getTarget());
        jedis.set(key, om.writeValueAsString(news));
//            Object res = point.proceed();
        return news;
        */
    }

}
