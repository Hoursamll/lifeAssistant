package com.szdx.lifeAssistant.sys.service.Impl;

import com.szdx.lifeAssistant.sys.dao.AdviceDao;
import com.szdx.lifeAssistant.sys.entity.Advice;
import com.szdx.lifeAssistant.sys.service.AdviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class AdviceServiceImpl implements AdviceService {
    @Autowired
    private AdviceDao adviceDao;

    @Override
    public List<Advice> getAdvice() {
        return adviceDao.getAdvice();
    }

    @Override
    public Advice get(String id) {
        return adviceDao.get(id);
    }

    @Override
    public void delete(String id) {
        adviceDao.delete(id);
    }

    @Override
    public void insert(Advice advice) {
        adviceDao.insert(advice);
    }

    @Override
    public List<Advice> queryDate(Advice advice) {
        return adviceDao.queryDate(advice);
    }
}
