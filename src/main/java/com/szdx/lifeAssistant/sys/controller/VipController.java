package com.szdx.lifeAssistant.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.szdx.lifeAssistant.common.persistence.web.BaseController;
import com.szdx.lifeAssistant.common.utils.IdGen;
import com.szdx.lifeAssistant.common.utils.ResponseUtils;
import com.szdx.lifeAssistant.common.utils.StringUtils;
import com.szdx.lifeAssistant.sys.entity.Vip;
import com.szdx.lifeAssistant.sys.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by 云终生 on 2018/4/3.
 */
@RequestMapping(value = "/manage/vip")
@Controller
public class VipController extends BaseController {
    @Autowired
    private VipService vipService;

    //查询
    @RequestMapping("/vipQuery")
    public ModelAndView vipQuery(ModelAndView mv, HttpServletRequest request, HttpServletResponse response, Model model){
        getVip(request, mv);
        mv.setViewName("views/manage/vip/vipQuery");
        return mv;
    }

    //添加 or 编辑
    @RequestMapping("/vipAdd")
    public String vipAdd(HttpServletRequest request, HttpServletResponse response, Model model){
        Vip vip=new Vip();
        if(StringUtils.isNoneBlank(request.getParameter("id"))){
            vip.setId(request.getParameter("id"));
            vip= vipService.getVip(vip);
            model.addAttribute("vip", vip);
        } else {
            model.addAttribute("vip", vip);
        }
        return "views/manage/vip/vipAdd";
    }

    //保存
    @ResponseBody
    @RequestMapping(value = "/vipSave",method =RequestMethod.POST)
    public ModelAndView vipSave(ModelAndView mv,HttpServletRequest request, HttpServletResponse response, Vip vip){
        String id = request.getParameter("id");
        JSONObject json = new JSONObject();
        if(id!=null&&id!=""){
            vipService.updateVip(vip);
        }else{
            vip.setCreateTime(new Date());
            vip.setId(IdGen.uuid());
            vip.setNumber(vipService.count());
            vipService.insertVip(vip);
        }
        json.put("flag", true);
        json.put("message", "success");
        getVip(request, mv);
        mv.setViewName("views/manage/vip/vipQuery");
        return mv;
    }

    //列表
    private void getVip(HttpServletRequest request, ModelAndView mv){
        List<Vip> vip = new ArrayList<Vip>();
        int page = 1;
        if (request.getParameter("page") != null){
            page = Integer.parseInt(request.getParameter("page"));
        }
        vip = vipService.getPage(page);
        System.out.println("===========" + vip.toString());
        //返回给前台
        mv.addObject("vip", vip);
    }

    //删除
    @ResponseBody
    @RequestMapping(value = "/vipDel", method = RequestMethod.POST)
    public void vipDel(ModelAndView mv, HttpServletRequest request, HttpServletResponse response, Model model){
        String id = request.getParameter("id");
        JSONObject json = new JSONObject();
        if(id!=null){
            Vip vip=new Vip();
            vip.setId(id);
            vipService.deleteVip(vip);
            json.put("flag", true);
            json.put("message", "success");
        }else {
            json.put("flag", false);
            json.put("message", "error");
        }
        ResponseUtils.renderJson(response, json.toJSONString());
    }
}
