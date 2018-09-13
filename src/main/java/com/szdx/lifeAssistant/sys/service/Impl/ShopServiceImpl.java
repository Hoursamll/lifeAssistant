package com.szdx.lifeAssistant.sys.service.Impl;

import com.szdx.lifeAssistant.sys.dao.ShopDao;
import com.szdx.lifeAssistant.sys.entity.Shop;
import com.szdx.lifeAssistant.sys.service.ShopService;
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
public class ShopServiceImpl implements ShopService{
    @Autowired
    private ShopDao shopDao;

    @Override
    public Shop getShop(Shop shop) {
        return shopDao.getShop(shop);
    }

    @Override
    public void updateShop(Shop shop) {
        shopDao.updateShop(shop);
    }

    @Override
    public void deleteShop(Shop shop) {
        shopDao.deleteShop(shop);
    }

    @Override
    public void insertShop(Shop shop) {
        shopDao.insertShop(shop);
    }

    @Override
    public List<Shop> getShopPage(@Param("startCount") int startCount) {
        int start = (startCount - 1) * 200;
        return shopDao.getShopPage(start);
    }

    @Override
    public int count() {
        return shopDao.count();
    }
}
