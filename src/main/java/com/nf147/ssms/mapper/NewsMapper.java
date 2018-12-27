package com.nf147.ssms.mapper;

import com.nf147.ssms.entity.News;

import java.util.List;

public interface NewsMapper {
    List<News> list();

    void add(News news);

    News getById(long id);
}
