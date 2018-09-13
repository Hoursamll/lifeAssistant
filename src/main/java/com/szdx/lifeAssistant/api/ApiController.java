package com.szdx.lifeAssistant.api;

import com.szdx.lifeAssistant.common.persistence.web.BaseController;
import com.szdx.lifeAssistant.common.utils.JWTUtil;
import com.szdx.lifeAssistant.common.utils.MD5Util;
import com.szdx.lifeAssistant.common.utils.ResponseData;
import com.szdx.lifeAssistant.sys.entity.*;
import com.szdx.lifeAssistant.sys.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RequestMapping(value = "/api")
@Controller
public class ApiController extends BaseController {
    @Autowired
    private UserService userService;
    @Autowired
    private NewsService newsService;
    @Autowired
    private LifeService lifeService;
    @Autowired
    private ShopService shopService;

    /**
     * 登录接口
     * 接口名：/login
     * 传参：userName, userPwd 如 "13801449637"，"000000"
     * 类型：String
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseData login(HttpServletRequest request, HttpServletResponse response){
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");
        User user=new User();
        ResponseData responseData = ResponseData.ok();
        if (userName == null || userPwd == null){
            responseData = new ResponseData(400, "用户名、密码不能为空！");
            return responseData;
        }
        //先到数据库验证
        user=userService.getUser(user);
        if(null != user) {
            //给用户jwt加密生成token
            //过期时间为7天
            String token = JWTUtil.sign(user, 60 * 1000 * 60 * 24 * 7);
            //封装成对象返回给客户端，客户端需要保存userId和Token，访问其他接口需要带上userId和Token
            responseData.putDataValue("userId", user.getId());
            responseData.putDataValue("token", token);
            responseData.putDataValue("user", user);
        }else{
            responseData = new ResponseData(400, "用户名或密码错误,请检查！");
        }
        return responseData;
    }

    /**
     * 注册接口
     * 接口名：/register
     * 传参：userName, userPwd 如 "13801449637"，"000000"
     * 类型：String
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public ResponseData register(HttpServletRequest request, HttpServletResponse response){
        String userPhone = request.getParameter("userPhone");
        String userPwd = MD5Util.md5Password(request.getParameter("userPwd"));
        ResponseData responseData = ResponseData.ok();
        if (userPhone == null || userPwd == null){
            responseData = new ResponseData(400, "用户名、密码不能为空！");
            return responseData;
        }
        if (userService.isRegister(userPhone) == 0){
            boolean isSuccess = userService.register(userPhone, userPwd);
            if (isSuccess){
                //注册成功
                responseData = new ResponseData(200, "注册成功！");
            }else{
                //注册失败
                responseData = new ResponseData(400, "注册失败，请重试");
            }
        }else {
            //已经注册
            responseData = new ResponseData(400, "该手机号已被注册！请换个手机号重新注册");
        }
        return responseData;
    }

    /**
     * 新闻查询与详情接口
     * 接口名：/news
     * 传参：id, startCount,status 如 "897"，"正整数"，"0或1"
     * 类型：String
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/news", method = RequestMethod.POST)
    public ResponseData news(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        String startCount =request.getParameter("startCount");
        //status为1或者0
        String status = request.getParameter("status");
        ResponseData responseData = ResponseData.ok();
        if (status == null){
            responseData = new ResponseData(400, "参数不能为空");
            return responseData;
        }
        if(id==null||("").equals(id)){
            if(startCount==null||("").equals(startCount)){
                startCount = "1";
            }
            List<News> newsList=newsService.getNewsPage(Integer.parseInt(startCount));
            responseData.putDataValue("newsList", newsList);
        }else{
            News news=new News();
            news.setId(id);
            news=newsService.getNews(news);
            responseData.putDataValue("news", news);
        }
        return responseData;
    }

    /**
     * 生活查询与详情接口
     * 接口名：/life
     * 传参：id, startCount,status 如 "897"，"正整数"，"0或1"
     * 类型：String
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/life", method = RequestMethod.POST)
    public ResponseData life(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        String startCount =request.getParameter("startCount");
        //status为1或者0
        String status = request.getParameter("status");
        ResponseData responseData = ResponseData.ok();
        if (status == null){
            responseData = new ResponseData(400, "参数不能为空");
            return responseData;
        }
        if(id==null||("").equals(id)){
            if(startCount==null||("").equals(startCount)){
                startCount = "1";
            }
            List<Life> lifeList=lifeService.getLifePage(Integer.parseInt(startCount));
            responseData.putDataValue("lifeList", lifeList);
        }else{
            Life life=new Life();
            life.setId(id);
            life=lifeService.getLife(life);
            responseData.putDataValue("life", life);
        }
        return responseData;
    }

    /**
     * 商城查询与详情接口
     * 接口名：/shop
     * 传参：id, startCount,status 如 "897"，"正整数"，"0或1"
     * 类型：String
     * @param request
     * @param response
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/shop", method = RequestMethod.POST)
    public ResponseData shop(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        String startCount =request.getParameter("startCount");
        //status为1或者0
        String status = request.getParameter("status");
        ResponseData responseData = ResponseData.ok();
        if (status == null){
            responseData = new ResponseData(400, "参数不能为空");
            return responseData;
        }
        if(id==null||("").equals(id)){
            if(startCount==null||("").equals(startCount)){
                startCount = "1";
            }
            List<Shop> shopList=shopService.getShopPage(Integer.parseInt(startCount));
            responseData.putDataValue("shopList", shopList);
        }else{
            Shop shop=new Shop();
            shop.setId(id);
            shop=shopService.getShop(shop);
            responseData.putDataValue("shop", shop);
        }
        return responseData;
    }
}