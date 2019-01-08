package com.szdx.lifeAssistant.sys.service.Impl;

import com.szdx.lifeAssistant.sys.dao.VipDao;
import com.szdx.lifeAssistant.sys.entity.Vip;
import com.szdx.lifeAssistant.sys.service.VipService;
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
public class VipServiceImpl implements VipService{
    @Autowired
    private VipDao vipDao;

    @Override
    public List<Vip> getPage(@Param("startCount") int startCount) {
        int start = (startCount - 1) * 200;
        return vipDao.getPage(start);
    }

    @Override
    public void deleteVip(Vip vip) {
        vipDao.deleteVip(vip);
    }

    @Override
    public void updateVip(Vip vip) {
        vipDao.updateVip(vip);
    }

    @Override
    public void insertVip(Vip vip) {
        vipDao.insertVip(vip);
    }

    @Override
    public Vip getVip(Vip vip) {
        return vipDao.getVip(vip);
    }

    @Override
    public int count() {
        return vipDao.count();
    }

    @Override
    public int isExist(String name) {
        return vipDao.isExist(name);
    }
}
