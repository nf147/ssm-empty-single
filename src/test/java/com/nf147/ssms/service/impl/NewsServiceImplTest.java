package com.nf147.ssms.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.nf147.ssms.entity.News;
import com.nf147.ssms.service.NewsService;
import configuration.RootConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;

import java.io.*;
import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class NewsServiceImplTest {

    @Autowired
    private NewsService newsService;

    @Test
    public void getById() {
        News news = newsService.getNewsById(2);
        System.out.println(news);
    }

    @Test
    public void listNews() throws Exception {
        // System.out.println(newsGson);
        System.out.println(newsService.listNews());
    }

    @Test
    public void addNews() {
        News news = new News("马云说", "圣诞节快乐");
        newsService.addNews(news);
    }

    @Test
    public void toJson() throws Exception {
        ObjectMapper om = new ObjectMapper();

        // java 对象 -> json 字符串
        // json 字符串 -> java 对象
        News news = new News("yuandankuaidaole", "放假通知");
        String s = om.writeValueAsString(news);
        News news_new = om.readValue(s, News.class);

        System.out.println("==============");

        List<News> newsList = Arrays.asList(
                new News("yuandan", "放假"),
                new News("春节", "快来了")
        );
        String newsListStr = om.writeValueAsString(newsList);
        News[] newsArray = om.readValue(newsListStr, News[].class);
        List<News> newsList1 = om.readValue(newsListStr, new TypeReference<List<News>>() {});
        System.out.println(newsList1);

        List<News> newsList2 = new Gson().fromJson(newsListStr, new TypeToken<List<News>>() {}.getType());
        System.out.println(newsList2);
    }

    @Test
    public void serialize() throws IOException {
        List<News> newsList = Arrays.asList(
                new News("yuandan", "放假"),
                new News("春节", "快来了")
        );
        FileOutputStream fos = new FileOutputStream(new File("d:/news.class"));
        ObjectOutputStream stream = new ObjectOutputStream(fos);
        stream.writeObject(newsList);
        stream.close();
    }

    @Test
    public void deserialize () throws Exception {
        FileInputStream is = new FileInputStream(new File("d:/news.class"));
        ObjectInputStream oi = new ObjectInputStream(is);

        Object o = oi.readObject();
        System.out.println(o);
    }

    @Test
    public void serornotserialize() throws Exception {
        Jedis jedis = new Jedis();

        // round 1
        ByteArrayOutputStream bro = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bro);
        oos.writeObject(new News("ni", "kuailema"));
        oos.writeObject(new News("wo", "bukuaile"));

        jedis.set("demo-01".getBytes(), bro.toByteArray());
        oos.close();

        // round 2
        ByteArrayInputStream bri    = new ByteArrayInputStream(jedis.get("demo-01".getBytes()));
        // ByteArrayInputStream bri = new ByteArrayInputStream(jedis.get("demo-01").getBytes()); // WRONG!
        ObjectInputStream ois = new ObjectInputStream(bri);
        Object o1 = ois.readObject();
        Object o2 = ois.readObject();

        System.out.println(o1);
        System.out.println(o2);
        ois.close();
    }
}