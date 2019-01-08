package com.szdx.lifeAssistant;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.security.SecureRandom;

/**
 * Created by shizhicheng on 2018/4/21.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class demoTest{

    @Test
    public void randomLong() {
        //测试
        SecureRandom random = new SecureRandom();
        System.out.println("test================" +Math.abs(random.nextLong()));
    }
}
