package com.szdx.lifeAssistant.sys.service;

import com.szdx.lifeAssistant.sys.entity.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 云终生 on 2018/4/3.
 */
public interface ShopService {
    public Shop getShop(Shop shop);

    public void updateShop(Shop shop);

    public void deleteShop(Shop shop);

    public void insertShop(Shop shop);

    public List<Shop> getShopPage(@Param("startCount") int startCount);

    public int count();
}
