package com.szdx.lifeAssistant.sys.service;

import com.szdx.lifeAssistant.sys.entity.Advice;

import java.util.List;

public interface AdviceService {

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
