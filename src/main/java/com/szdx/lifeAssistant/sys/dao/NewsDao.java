package com.szdx.lifeAssistant.sys.dao;

import com.szdx.lifeAssistant.sys.entity.News;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 云终生 on 2018/4/16.
 */
@Repository
public interface NewsDao {
    public News getNews(News news);

    public void deleteNews(News news);

    public void updateNews(News news);

    public void insertNews(News news);

    public List<News> getNewsPage(@Param("startCount") int startCount);

    public int count();
}
