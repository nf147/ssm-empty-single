package com.nf147.ssms.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.nf147.ssms.entity.News;

import java.util.List;

public interface NewsService {
    List<News> listNews() throws JsonProcessingException, Exception;

    void addNews(News news);

    News getNewsById(long id);
}
