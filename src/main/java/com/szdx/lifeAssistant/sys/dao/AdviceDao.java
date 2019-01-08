package com.szdx.lifeAssistant.sys.dao;

import com.szdx.lifeAssistant.common.web.ServerResponse;
import com.szdx.lifeAssistant.sys.entity.Advice;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public interface AdviceDao {

    public List<Advice> getAdvice();

    public Advice get(String id);

    public void delete(String id);

    public void insert(Advice advice);

    /**
     * 根据日期查询
     * @param advice
     * @return
     */
    public List<Advice> queryDate(Advice advice);

}
