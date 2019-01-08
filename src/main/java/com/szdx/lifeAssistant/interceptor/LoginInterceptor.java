package com.szdx.lifeAssistant.interceptor;

import com.szdx.lifeAssistant.sys.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/6/28.
 */
public class LoginInterceptor implements HandlerInterceptor {

    //不拦截"/userLogin"和"/adminLogin"的请求
    private static final String[] IGNORE_URI = {"/login","/advice/*"};

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        //flag变量用于判断用户是否登录，默认为false
        boolean flag = false;
        //获取请求路径进行判断
        String servletPath = httpServletRequest.getServletPath();
        System.out.println("管理的拦截servletPath ==>");
        System.out.println(servletPath);
        //判断是否需要拦截
        for (String s : IGNORE_URI){
            if (servletPath.contains(s)){   //不拦截
                flag = true;
                break;
            }
        }

        //拦截请求
        if (!flag){
            //获取session中的用户
            User user = (User) httpServletRequest.getSession().getAttribute("user");
            //判断用户是否登录
            if (user == null){
                //如果用户没有登录，则设置提示信息，跳转到登录页面
                System.out.println("LoginInterceptor 拦截请求");
                httpServletRequest.setAttribute("message", "请先登录再访问网站");
                httpServletResponse.sendRedirect("views/login");
                //httpServletRequest.getRequestDispatcher("toLogin").forward(httpServletRequest, httpServletResponse);
            }else {
                //如果用户已经登录，则验证通过，放行
                System.out.println("LoginInterceptor 放行请求");
                flag = true;
            }
        }


        return flag;
    }

    /**
     * 该方法将在Controller的方法调用之后执行，方法中可以对ModleAndView进行操作，
     * 该方法也只能在当前Interceptor的preHandle方法的返回值为true时才会执行
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param modelAndView
     * @throws Exception
     */
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("LoginInterceptor postHandle -->");
    }

    /**
     * 该方法将在整个请求完成之后执行，主要用于清理资源，
     * 该方法也只能在当前的Interceptor的preHandle方法的返回值为true时才会生效
     * @param httpServletRequest
     * @param httpServletResponse
     * @param o
     * @param e
     * @throws Exception
     */
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("LoginInterceptor afterCompletion -->");
    }
}
