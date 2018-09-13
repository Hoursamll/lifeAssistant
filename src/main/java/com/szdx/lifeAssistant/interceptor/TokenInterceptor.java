package com.szdx.lifeAssistant.interceptor;

import com.alibaba.fastjson.JSONObject;
import com.szdx.lifeAssistant.common.utils.JWTUtil;
import com.szdx.lifeAssistant.common.utils.ResponseData;
import com.szdx.lifeAssistant.sys.entity.Vip;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * Created by Administrator on 2017/6/29.
 */
public class TokenInterceptor implements HandlerInterceptor {
    //不拦截"/api"的请求
    //包括，登录接口，注册接口，菜品详细以及获取欢迎页面数据接口
    private static final String[] IGNORE_URI = {"/login", "/register","/news","/life","/shop"};

    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response, Object handler, Exception arg3)
            throws Exception {
    }

    public void postHandle(HttpServletRequest request, HttpServletResponse response,
                           Object handler, ModelAndView model) throws Exception {
    }

    //拦截每个请求
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        response.setCharacterEncoding("utf-8");
        String token = request.getParameter("token");
        String servletPath = request.getServletPath();
        System.out.println("Api端拦截的servletPath ==>");
        System.out.println(servletPath);
        //判断是否需要拦截
        for (String s : IGNORE_URI){
            if (servletPath.contains(s)){   //不拦截
                return true;
            }
        }
        ResponseData responseData = ResponseData.ok();
        //token不存在
        if(null != token) {
            Vip vip = JWTUtil.unSign(token, Vip.class);
            String vipId = request.getParameter("vipId");
            //解密token后的userId与用户传来的userId不一致，一般都是token过期
            if(null != vipId && null != vip) {
                if(vipId .equals(vip.getId())) {
                    return true;
                }else{
                    responseData = ResponseData.forbidden();
                    responseMessage(response, response.getWriter(), responseData);
                    return false;
                }
            }else {
                responseData = ResponseData.forbidden();
                responseMessage(response, response.getWriter(), responseData);
                return false;
            }
        }else {
            responseData = ResponseData.forbidden();
            responseMessage(response, response.getWriter(), responseData);
            return false;
        }
    }

    //请求不通过，返回错误信息给客户端
    private void responseMessage(HttpServletResponse response, PrintWriter out, ResponseData responseData) {
        responseData = ResponseData.forbidden();
        response.setContentType("application/json; charset=utf-8");
        String json = JSONObject.toJSONString(responseData);
        out.print(json);
        out.flush();
        out.close();
    }
}
