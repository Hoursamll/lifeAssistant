package com.szdx.lifeAssistant.sys.service.Impl;

import com.szdx.lifeAssistant.sys.dao.LifeDao;
import com.szdx.lifeAssistant.sys.entity.Life;
import com.szdx.lifeAssistant.sys.service.LifeService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by 云终生 on 2018/4/3.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class LifeServiceImpl implements LifeService{
    @Autowired
    private LifeDao lifeDao;

    @Override
    public Life getLife(Life life) {
        return lifeDao.getLife(life);
    }

    @Override
    public void deleteLife(Life life) {
        lifeDao.deleteLife(life);
    }

    @Override
    public void updateLife(Life life) {
        lifeDao.updateLife(life);
    }

    @Override
    public void insertLife(Life life) {
        lifeDao.insertLife(life);
    }

    @Override
    public List<Life> getLifePage(@Param("startCount") int startCount) {
        int start = (startCount - 1) * 200;
        return lifeDao.getLifePage(start);
    }

    @Override
    public int count() {
        return lifeDao.count();
    }
}
