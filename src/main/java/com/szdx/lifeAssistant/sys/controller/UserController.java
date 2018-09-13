package com.szdx.lifeAssistant.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.szdx.lifeAssistant.common.persistence.web.BaseController;
import com.szdx.lifeAssistant.common.utils.MD5Util;
import com.szdx.lifeAssistant.common.utils.ResponseUtils;
import com.szdx.lifeAssistant.common.utils.StringUtils;
import com.szdx.lifeAssistant.sys.entity.User;
import com.szdx.lifeAssistant.sys.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by shizhicheng on 2018/3/30.
 */

@RequestMapping(value = "/manage")
@Controller
public class UserController extends BaseController {
    @Resource
    private UserService userService;

    /**
     * 管理员用户登录
     * @param mv
     * @param request
     * @param response
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView login(ModelAndView mv,HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        //先判断管理员有没有登录过
        HttpSession session = request.getSession();
        User user=new User();
        //获取表单提交得到的参数
        String userName = request.getParameter("userName");
        String passWord = MD5Util.md5Password(request.getParameter("passWord"));
        user.setUserName(userName);
        user.setPassWord(passWord);
        System.out.println("==登录名和密码====");
        System.out.println(userName + "   " + passWord);
        user = userService.getUser(user);
        if (user != null){  //管理员登录成功

            session.setAttribute("user", user);
            //转发到indexManage请求
            mv.setViewName("views/index");
        }else {
            mv.addObject("message", "登录名或密码错误，请重新输入！");
            mv.setViewName("views/login");

        }
        return mv;
    }

    @RequestMapping(value ="/signOut")
    public ModelAndView signOut(ModelAndView mv,HttpServletResponse response,HttpServletRequest request,Model model){
        HttpSession session =request.getSession();
        session.setAttribute("user","");
        return new ModelAndView("/views/login");
    }

    //后台首页
    @RequestMapping(value = "/home")
    public ModelAndView main(ModelAndView mv, HttpServletRequest request, HttpServletResponse response, Model model) throws IOException {
        mv.setViewName("views/home");
        return mv;
    }

    //用户查询
    @RequestMapping("/userQuery")
    public ModelAndView userQuery(ModelAndView mv, HttpServletRequest request, HttpServletResponse response, Model model){
        getUsers(request, mv);
        mv.setViewName("views/manage/user/userQuery");
        return mv;
    }

    //个人资料
    @RequestMapping("/information")
    public String information(HttpServletRequest request, HttpServletResponse response, Model model){
        String id = request.getParameter("id");
        if(StringUtils.isNoneBlank(id)){
            User user =userService.information(id);
            model.addAttribute("user", user);
        }
        return "views/manage/user/userAdd";
    }

    //保存
    @RequestMapping("/userSave")
    public ModelAndView userSave(ModelAndView mv,HttpServletRequest request, HttpServletResponse response, Model model){
        String id = request.getParameter("id");
        JSONObject json = new JSONObject();
        User user=new User();
        if(id!=null){
            userService.updateUser(user);
            getUsers(request, mv);
            mv.setViewName("views/manage/user/userQuery");
        }else{
            user.setId(String.valueOf(userService.count()));
            user.setPassWord(MD5Util.md5Password(user.getPassWord()));
            userService.insertUser(user);
            mv.setViewName("views/login");
        }
        return mv;
    }

    //得到导航列表
    private void getUsers(HttpServletRequest request, ModelAndView mv){
        List<User> user = new ArrayList<User>();
        int page = 1;
        if (request.getParameter("page") != null){
            page = Integer.parseInt(request.getParameter("page"));
        }
        user = userService.getUserPage(page);
        System.out.println("===========" + user.toString());
        //返回给前台
        mv.addObject("user", user);
    }

    //删除
    @ResponseBody
    @RequestMapping(value = "/userDel", method = RequestMethod.POST)
    public void userDel(ModelAndView mv, HttpServletRequest request, HttpServletResponse response, Model model){
        String id = request.getParameter("id");
        JSONObject json = new JSONObject();
        if(id!=null){
            User user=new User();
            user.setId(id);
            userService.deleteUser(user);
            json.put("flag", true);
            json.put("message", "success");
        }else {
            json.put("flag", false);
            json.put("message", "error");
        }
        ResponseUtils.renderJson(response, json.toJSONString());
    }
}
