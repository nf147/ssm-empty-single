package com.nf147.ssms.service.impl;

import com.nf147.ssms.entity.News;
import com.nf147.ssms.mapper.NewsMapper;
import com.nf147.ssms.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceWithSpringCacheSupportImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public News getNewsById(long id) {
        return newsMapper.getById(id);
    }

    @Override
   // @Cacheable("listNews")
    @Cacheable(cacheNames = "listNews", keyGenerator = "myKeyGenerator", cacheManager = "cacheManager")
    public List<News> listNews() {
        return newsMapper.list();
    }

    @Override
    @Cacheable("listNewsHot")
    public List<News> listNewsHot() {
        return newsMapper.listHot();
    }

    @Override
    @CacheEvict({"listNews", "listNewsHot"})
    public void addNews(News news) {
        newsMapper.add(news);
    }

    @CachePut("listNews")
    public List<News> adminListNews() {
        return newsMapper.list();
    }
}
