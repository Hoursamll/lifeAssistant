package com.szdx.lifeAssistant.sys.service.Impl;

import com.szdx.lifeAssistant.sys.dao.NewsDao;
import com.szdx.lifeAssistant.sys.entity.News;
import com.szdx.lifeAssistant.sys.service.NewsService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 云终生 on 2018/4/16.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class NewsServiceImpl implements NewsService{
    @Autowired
    private NewsDao newsDao;

    @Override
    public News getNews(News news) {
        return newsDao.getNews(news);
    }

    @Override
    public void deleteNews(News news) {
        newsDao.deleteNews(news);
    }

    @Override
    public void updateNews(News news) {
        newsDao.updateNews(news);
    }

    @Override
    public void insertNews(News news) {
        newsDao.insertNews(news);
    }

    @Override
    public List<News> getNewsPage(@Param("startCount") int startCount) {
        int start = (startCount - 1) * 200;
        return newsDao.getNewsPage(start);
    }

    @Override
    public int count() {
        return newsDao.count();
    }
}
