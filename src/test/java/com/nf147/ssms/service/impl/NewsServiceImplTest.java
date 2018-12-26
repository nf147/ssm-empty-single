package com.nf147.ssms.service.impl;

import com.nf147.ssms.entity.News;
import com.nf147.ssms.service.NewsService;
import configuration.RootConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = RootConfig.class)
public class NewsServiceImplTest {

    @Autowired
    private NewsService newsService;

    @Test
    public void listNews() {
        List<News> news = newsService.listNews();
        System.out.println(news);
    }

    @Test
    public void addNews() {
        News news = new News("马云说", "圣诞节快乐");
        newsService.addNews(news);
    }
}