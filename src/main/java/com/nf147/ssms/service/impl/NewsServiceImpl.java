package com.nf147.ssms.service.impl;

import com.nf147.ssms.entity.News;
import com.nf147.ssms.mapper.NewsMapper;
import com.nf147.ssms.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {

    @Autowired
    private NewsMapper newsMapper;

    @Override
    public List<News> listNews() {
        return newsMapper.list();
    }

    @Override
    public void addNews(News news) {
        newsMapper.add(news);
    }
}
