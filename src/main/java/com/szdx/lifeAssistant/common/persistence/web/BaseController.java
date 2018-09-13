package com.szdx.lifeAssistant.common.persistence.web;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public abstract class BaseController {

    /** 日志对象 */
    protected Logger logger = LoggerFactory.getLogger(getClass());

    protected Gson gson = new Gson();


    /**
     * 客户端返回字符串
     * @param response
     * @param string
     * @return
     */
    protected String renderString(HttpServletResponse response, String string, String type) {
        try {
            response.reset();
            response.setContentType(type);
            response.setCharacterEncoding("utf-8");
            response.getWriter().print(string);
            response.getWriter().close();
            return null;
        } catch (IOException e) {
            return null;
        }
    }
}
