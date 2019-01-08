package com.szdx.lifeAssistant.sys.controller;

import com.alibaba.fastjson.JSONObject;
import com.szdx.lifeAssistant.common.persistence.web.BaseController;
import com.szdx.lifeAssistant.common.utils.IdGen;
import com.szdx.lifeAssistant.common.utils.ResponseUtils;
import com.szdx.lifeAssistant.common.utils.StringUtils;
import com.szdx.lifeAssistant.sys.entity.Advice;
import com.szdx.lifeAssistant.sys.entity.Vip;
import com.szdx.lifeAssistant.sys.service.AdviceService;
import com.szdx.lifeAssistant.sys.service.VipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RequestMapping(value = "/advice")
@Controller
public class AdviceController extends BaseController {
    @Autowired
    private AdviceService adviceService;
    @Autowired
    private VipService vipService;

    @RequestMapping("/save")
    public void save(HttpServletRequest request, HttpServletResponse response, Advice advice){
        JSONObject json = new JSONObject();
        String advicePerson = advice.getAdvicePerson();
        List<Vip> page = vipService.getPage(1);
        int exist = vipService.isExist(advicePerson);
        if(exist>0){
            advice.setId(IdGen.uuid());
            adviceService.insert(advice);
            json.put("flag", true);
            json.put("message", "提交成功");
        }else {
            json.put("flag", false);
            json.put("message", "请输入正确的姓名");
        }
        ResponseUtils.renderJson(response, json.toJSONString());
    }

    @RequestMapping("/info")
    @ResponseBody
    public void info(HttpServletRequest request, HttpServletResponse response) throws ParseException {
        JSONObject json = new JSONObject();
        List<Advice> advices=null;
        String date=request.getParameter("date");
        String endDate=request.getParameter("endDate");
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = null;
        Date endDate1=null;
        Advice advice=new Advice();
        if(StringUtils.isNotBlank(date)){
                date1 = sdf.parse(date);
            if(StringUtils.isNotBlank(endDate)){
                endDate1 = sdf.parse(endDate);
                advice.setAdviceDate(endDate1);
            }
            advice.setCreateTime(date1);
            advices = adviceService.queryDate(advice);
        }else
        {
            advices= adviceService.getAdvice();
        }
        json.put("flag", true);
        json.put("advice", advices);
//        return null;
        ResponseUtils.renderJson(response, json.toJSONString());
//        return advices;
    }

    @RequestMapping("/get")
    public void get(HttpServletRequest request, HttpServletResponse response){
        String id = request.getParameter("id");
        JSONObject json = new JSONObject();
        if(StringUtils.isNotBlank(id)){
            Advice advice = adviceService.get(id);
            json.put("flag",true);
            json.put("advice", advice);
        }else{
            json.put("flag",false);
        }
        ResponseUtils.renderJson(response, json.toJSONString());
    }

}
