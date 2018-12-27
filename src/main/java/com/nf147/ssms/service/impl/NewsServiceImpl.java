package com.nf147.ssms.service.impl;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nf147.ssms.entity.News;
import com.nf147.ssms.mapper.NewsMapper;
import com.nf147.ssms.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public News getNewsById(long id) {
        return newsMapper.getById(id);
    }

    @Override
    public List<News> listNews() throws Exception {
        Jedis jedis = new Jedis();
        String key = "listNews";

        ObjectMapper om = new ObjectMapper();

        if (jedis.exists(key)) {
            return om.readValue(jedis.get(key), new TypeReference<List<News>>() {
            });
        }

        List<News> news = newsMapper.list();
        jedis.set(key, om.writeValueAsString(news));
        return news;
    }

    @Override
    public void addNews(News news) {
        Jedis jedis = new Jedis();
        String key = "listNews";
        if (jedis.exists(key)) jedis.del(key);

        newsMapper.add(news);
    }
}
