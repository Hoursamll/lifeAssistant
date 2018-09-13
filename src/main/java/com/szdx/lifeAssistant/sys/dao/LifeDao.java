package com.szdx.lifeAssistant.sys.dao;

import com.szdx.lifeAssistant.sys.entity.Life;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by 云终生 on 2018/4/2.
 */
@Repository
public interface LifeDao {
    public Life getLife(Life life);

    public void deleteLife(Life life);

    public void updateLife(Life life);

    public void insertLife(Life life);

    public List<Life> getLifePage(@Param("startCount") int startCount);

    public int count();
}
