package com.szdx.lifeAssistant.sys.service;

import com.szdx.lifeAssistant.sys.entity.Vip;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by 云终生 on 2018/4/3.
 */
public interface VipService {
    List<Vip> getPage(@Param("startCount") int startCount);

    public void deleteVip(Vip vip);

    public void updateVip(Vip vip);

    public void insertVip(Vip vip);

    public Vip getVip(Vip vip);

    public int count();

    public int isExist(String name);
}
