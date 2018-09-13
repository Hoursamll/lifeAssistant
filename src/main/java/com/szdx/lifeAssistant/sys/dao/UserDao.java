package com.szdx.lifeAssistant.sys.dao;

import com.szdx.lifeAssistant.sys.entity.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by shizhicheng on 2018/3/30.
 */
@Repository
public interface UserDao {

    public User getUser(User user);

    public void deleteUser(User user);

    public void updateUser(User user);

    public void insertUser(User user);

    List<User> getUserPage(@Param("startCount") int startCount);

    public int count();

    public User information(@Param("id")String id);

    public int isRegister(@Param("userPhone") String userPhone);

    public Boolean register(@Param("userPhone")String userPhone,@Param("userPwd")String userPwd);
}
