package com.szdx.lifeAssistant.common.utils;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * Created by Administrator on 2017/7/26.
 */
public class UploadPicUtils {

    public static ResponseData uploadPic(String toPath, HttpServletRequest request, CommonsMultipartFile file){
        String fileName = file.getOriginalFilename();
        System.out.println("原始文件名:" + fileName);
        //获取项目路径
        ServletContext sc = request.getSession().getServletContext();
        //上传位置
        //String path = sc.getRealPath("/img") + "/"; //设定文件保存路径
        String path = "c:/lifeAssistant/uploads/" + toPath; //设定文件保存路径
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
        System.out.println("图片访问地址:" + Constants.BASE_URL + "love-cook/uploads/" + toPath + fileName);
        ResponseData responseData = ResponseData.ok();
        responseData.putDataValue("src",  "love-cook/uploads/" + toPath + fileName);
        responseData.putDataValue("title", "love-cook/uploads/" + toPath + fileName);
        return responseData;
    }

}
