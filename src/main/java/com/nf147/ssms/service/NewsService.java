package com.nf147.ssms.service;

import com.nf147.ssms.entity.News;

import java.util.List;

public interface NewsService {
    List<News> listNews();
    void addNews(News news);
}
