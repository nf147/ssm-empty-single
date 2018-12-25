package the_mass.redis;

import redis.clients.jedis.Jedis;

public class JedisDemo {
    public void execute () {
        Jedis jedis = new Jedis();
        //Jedis jedis1 = new Jedis("44.55.66.7", 3333);

        Boolean hello = jedis.exists("hello");
        System.out.println(hello);

        String s = jedis.get("hello");
        System.out.println(s);

        jedis.set("hello:1", "world:23");

        Long hello1 = jedis.exists("hello", "hello:123");
        System.out.println(hello1);
    }
}
