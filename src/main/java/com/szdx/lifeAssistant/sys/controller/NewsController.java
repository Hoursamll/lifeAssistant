package com.szdx.lifeAssistant.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.szdx.lifeAssistant.common.persistence.web.BaseController;
import com.szdx.lifeAssistant.common.utils.*;
import com.szdx.lifeAssistant.sys.entity.News;
import com.szdx.lifeAssistant.sys.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 云终生 on 2018/4/16.
 */
@Controller
@RequestMapping(value = "/manage/news")
public class NewsController extends BaseController{
    @Autowired
    private NewsService newsService;

    //查询
    @RequestMapping("/newsQuery")
    public ModelAndView lifeQuery(ModelAndView mv, HttpServletRequest request, HttpServletResponse response, Model model){
        getLife(request, mv);
        mv.setViewName("views/manage/news/newsQuery");
        return mv;
    }

    //添加 or 编辑
    @RequestMapping("/newsAdd")
    public String lifeAdd(ModelAndView mv, HttpServletRequest request, HttpServletResponse response, Model model){
        News news=new News();
        if(StringUtils.isNoneBlank(request.getParameter("id"))){
            news.setId(request.getParameter("id"));
            news= newsService.getNews(news);
            model.addAttribute("news", news);
        } else {
            model.addAttribute("news", news);
        }
        System.out.println("================"+news.toString());
        return "views/manage/news/newsAdd";
    }

    //保存
    @ResponseBody
    @RequestMapping(value = "/newsSave",method = RequestMethod.POST)
    public ModelAndView lifeSave(ModelAndView mv,HttpServletRequest request, HttpServletResponse response, Model model,News news){
        String id = news.getId();
        JSONObject json = new JSONObject();
        if(id!=null&&id!=""){
            newsService.updateNews(news);
        }else{
            news.setCreateTime(new Date());
            news.setId(IdGen.uuid());
            news.setNumber(newsService.count());
            newsService.insertNews(news);
        }
        json.put("flag", true);
        json.put("message", "success");
        getLife(request, mv);
        mv.setViewName("views/manage/news/newsQuery");
        return mv;
    }

    //得到导航列表
    private void getLife(HttpServletRequest request, ModelAndView mv){
        List<News> news = new ArrayList<News>();
        int page = 1;
        if (request.getParameter("page") != null){
            page = Integer.parseInt(request.getParameter("page"));
        }
        news = newsService.getNewsPage(page);
        System.out.println("===========" + news.toString());
        //返回给前台
        mv.addObject("news", news);
    }

    //添加场馆
    @RequestMapping("/addNews")
    public ModelAndView addLife(ModelAndView mv, HttpServletRequest request, HttpServletResponse response, Model model){
        News news=new News();
        newsService.insertNews(news);
        mv.setViewName("views/manage/news/newsAdd");
        return mv;
    }

    //删除
    @ResponseBody
    @RequestMapping(value = "/newsDel", method = RequestMethod.POST)
    public void newsDel(ModelAndView mv, HttpServletRequest request, HttpServletResponse response, Model model){
        String id = request.getParameter("id");
        JSONObject json = new JSONObject();
        if(id!=null&&id!=""){
            News news=new News();
            news.setId(id);
            System.out.println("id===========" + id);
            newsService.deleteNews(news);
            json.put("flag", true);
            json.put("message", "success");
        }else {
            json.put("flag", false);
            json.put("message", "error");
        }
        ResponseUtils.renderJson(response, json.toJSONString());
    }

    //上传图片
    @ResponseBody
    @RequestMapping(value = "/uploadShopPic")
    public ResponseData uploadShopPic(@RequestParam(value = "file")CommonsMultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException {
        String fileName = file.getOriginalFilename();
        System.out.println("原始文件名:" + fileName);
        //获取项目路径
        ServletContext sc = request.getSession().getServletContext();
        //上传位置
        String path = sc.getRealPath("/picture") + "/"; //设定文件保存路径
        //String path = "/usr/local/news_comment/uploads/" + "news/"; //设定文件保存路径
        File f = new File(path);
        if (!f.exists())
            f.mkdirs();
        if (!file.isEmpty()) {
            try {
                FileOutputStream fos = new FileOutputStream(path + fileName);
                InputStream in = file.getInputStream();
                int b = 0;
                while ((b = in.read()) != -1) {
                    fos.write(b);
                }
                fos.close();
                in.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("上传图片到:" + path + fileName);
        System.out.println("图片访问地址:" + Constants.BASE_URL + "lifeAssistant/picture/" + fileName);
        ResponseData responseData = ResponseData.ok();
        responseData.putDataValue("src",   Constants.BASE_URL + "lifeAssistant/picture/" + fileName);
        responseData.putDataValue("title",  Constants.BASE_URL + "lifeAssistant/picture/" + fileName);
        return responseData;
    }
}
