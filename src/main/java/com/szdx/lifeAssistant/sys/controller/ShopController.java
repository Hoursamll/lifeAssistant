package com.szdx.lifeAssistant.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.szdx.lifeAssistant.common.persistence.web.BaseController;
import com.szdx.lifeAssistant.common.utils.*;
import com.szdx.lifeAssistant.sys.entity.Shop;
import com.szdx.lifeAssistant.sys.service.ShopService;
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
 * Created by 云终生 on 2018/4/3.
 */
@RequestMapping(value = "/manage/shop")
@Controller
public class ShopController extends BaseController {
    @Autowired
    private ShopService shopService;

    //查询
    @RequestMapping("/shopQuery")
    public ModelAndView shopQuery(ModelAndView mv, HttpServletRequest request, HttpServletResponse response, Model model){
        getShop(request, mv);
        mv.setViewName("views/manage/shop/shopQuery");
        return mv;
    }

    //添加 or 编辑
    @RequestMapping("/shopAdd")
    public String shopAdd(ModelAndView mv, HttpServletRequest request, HttpServletResponse response, Model model){
        Shop shop=new Shop();
        if(StringUtils.isNoneBlank(request.getParameter("id"))){
            shop.setId(request.getParameter("id"));
            shop= shopService.getShop(shop);
            model.addAttribute("shop", shop);
        } else {
            model.addAttribute("shop", shop);
        }
        return "views/manage/shop/shopAdd";
    }

    //保存
    @ResponseBody
    @RequestMapping(value = "/shopSave",method =RequestMethod.POST)
    public ModelAndView shopSave(ModelAndView mv,HttpServletRequest request, HttpServletResponse response, Model model,Shop shop){
        String id = shop.getId();
        JSONObject json = new JSONObject();
        if(id!=null&&id!=""){
            shopService.updateShop(shop);
        }else{
            shop.setId(IdGen.uuid());
            shop.setNumber(shopService.count());
            shop.setCreateTime(new Date());
            shopService.insertShop(shop);
        }
        json.put("flag", true);
        json.put("message", "success");
        getShop(request, mv);
        mv.setViewName("views/manage/shop/shopQuery");
        return mv;
    }

    //得到导航列表
    private void getShop(HttpServletRequest request, ModelAndView mv){
        List<Shop> shop = new ArrayList<Shop>();
        int page = 1;
        if (request.getParameter("page") != null){
            page = Integer.parseInt(request.getParameter("page"));
        }
        shop = shopService.getShopPage(page);
        System.out.println("===========" + shop.toString());
        //返回给前台
        mv.addObject("shop", shop);
    }

    //添加场馆
    @RequestMapping("/addShop")
    public ModelAndView addShop(ModelAndView mv, HttpServletRequest request, HttpServletResponse response, Model model){
        Shop shop=new Shop();
        shopService.insertShop(shop);
        mv.setViewName("views/manage/shop/shopAdd");
        return mv;
    }

    //删除
    @ResponseBody
    @RequestMapping(value = "/shopDel", method = RequestMethod.POST)
    public void shopDel(ModelAndView mv, HttpServletRequest request, HttpServletResponse response, Model model){
        String id = request.getParameter("id");
        JSONObject json = new JSONObject();
        if(id!=null){
            Shop shop=new Shop();
            shop.setId(id);
            System.out.println("id===========" + id);
            shopService.deleteShop(shop);
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
    public ResponseData uploadShopPic(@RequestParam(value = "file")CommonsMultipartFile file, HttpServletRequest request, HttpServletResponse response) throws IOException{
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
