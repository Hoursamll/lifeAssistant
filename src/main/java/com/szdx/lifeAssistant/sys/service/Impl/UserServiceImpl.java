package com.szdx.lifeAssistant.sys.service.Impl;

import com.szdx.lifeAssistant.sys.dao.UserDao;
import com.szdx.lifeAssistant.sys.entity.User;
import com.szdx.lifeAssistant.sys.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by shizhicheng on 2018/3/30.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService{
    @Resource
    private UserDao userDao;

    @Override
    public User getUser(User user) {
        return userDao.getUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public void insertUser(User user) {
        userDao.insertUser(user);
    }

    @Override
    public List<User> getUserPage(int page) {
        int startCount = (page - 1) * 200;
        return userDao.getUserPage(startCount);
    }

    @Override
    public int count() {
        return userDao.count();
    }

    @Override
    public User information(@Param("id") String id) {
        return userDao.information(id);
    }

    @Override
    public int isRegister(String userPhone) {
        return userDao.isRegister(userPhone);
    }

    @Override
    public Boolean register(String userPhone, String userPwd) {
        return userDao.register(userPhone,userPwd);
    }
}
