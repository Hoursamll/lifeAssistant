package com.szdx.lifeAssistant.sys.controller;

import com.szdx.lifeAssistant.common.persistence.web.BaseController;
import com.szdx.lifeAssistant.sys.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Administrator on 2017/7/25.
 */

@Controller
public class IndexController extends BaseController {


    //打开首页
    @RequestMapping("/")
    public ModelAndView pageIndex(ModelAndView modelAndView, HttpServletRequest request, HttpServletResponse response, Model model){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null){  //已登陆
            modelAndView.setViewName("views/index");
        }else { //未登录，去登录
            modelAndView.setViewName("views/login");
        }
        return modelAndView;
    }
}
