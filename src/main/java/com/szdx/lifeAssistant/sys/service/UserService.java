package com.szdx.lifeAssistant.sys.service;

import com.szdx.lifeAssistant.sys.entity.User;
import org.apache.ibatis.annotations.Param;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by shizhicheng on 2018/3/30.
 */
public interface UserService {

    public User getUser(User user);

    public void deleteUser(User user);

    public void updateUser(User user);

    public void insertUser(User user);

    public List<User> getUserPage(int page);

    public int count();

    public User information(String id);

    public int isRegister(String userPhone);

    public Boolean register(String userPhone,String userPwd);
}
