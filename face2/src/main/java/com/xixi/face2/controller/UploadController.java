package com.xixi.face2.controller;

import java.io.File;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.mysql.fabric.xmlrpc.base.Data;
import com.xixi.face2.entity.Users;
import com.xixi.face2.service.UsersService;
import com.xixi.face2.util.FaceAdd;


@Controller
public class UploadController {

	@Autowired
	private UsersService usersService;

	/*** 
     * 保存文件 
     * @param file 
     * @return 
     */  
    private boolean saveFile(MultipartFile file,HttpServletRequest request,String name) {  
        // 判断文件是否为空  
        if (!file.isEmpty()) {  
            try {  
            	Date date=new Date();
                // 文件保存路径  
                String filePath = request.getSession().getServletContext().getRealPath("/") + "img/"  
                        + date.getTime()+".jpg";  
                String pathxi = request.getSession().getServletContext().getRealPath("/") + "img";
                File uploadDir = new File(pathxi);
    	        if (!uploadDir.exists()) {
    	            uploadDir.mkdirs();
    	        }
    	        
                // 转存文件  
                file.transferTo(new File(filePath));  
                Users users=new Users();
                users.setUsersName(name);
                usersService.addUsers(users);
                
                //上传人脸到百度Ai
                String reslut=FaceAdd.addFace(users.getUsersId()+"",filePath);
                System.err.println(reslut);
                return true;  
            } catch (Exception e) {  
                e.printStackTrace();  
            }  
        }  
        return false;  
    }  
    
    @RequestMapping("/addUserUpload")  
    public String filesUpload(@RequestParam("files") MultipartFile[] files,HttpServletRequest request,String name) {  
    	
        //判断file数组不能为空并且长度大于0  
        if(files!=null&&files.length>0){  
            //循环获取file数组中得文件  
            for(int i = 0;i<files.length;i++){  
                MultipartFile file = files[ i];  
                //保存文件 
                saveFile(file,request,name);  
            }  
        }  
        // 重定向  
        return "redirect:http://192.168.43.41:8080/nhdx/index.html";  
    }      


}
