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
     * �����ļ� 
     * @param file 
     * @return 
     */  
    private boolean saveFile(MultipartFile file,HttpServletRequest request,String name) {  
        // �ж��ļ��Ƿ�Ϊ��  
        if (!file.isEmpty()) {  
            try {  
            	Date date=new Date();
                // �ļ�����·��  
                String filePath = request.getSession().getServletContext().getRealPath("/") + "img/"  
                        + date.getTime()+".jpg";  
                String pathxi = request.getSession().getServletContext().getRealPath("/") + "img";
                File uploadDir = new File(pathxi);
    	        if (!uploadDir.exists()) {
    	            uploadDir.mkdirs();
    	        }
    	        
                // ת���ļ�  
                file.transferTo(new File(filePath));  
                Users users=new Users();
                users.setUsersName(name);
                usersService.addUsers(users);
                
                //�ϴ��������ٶ�Ai
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
    	
        //�ж�file���鲻��Ϊ�ղ��ҳ��ȴ���0  
        if(files!=null&&files.length>0){  
            //ѭ����ȡfile�����е��ļ�  
            for(int i = 0;i<files.length;i++){  
                MultipartFile file = files[ i];  
                //�����ļ� 
                saveFile(file,request,name);  
            }  
        }  
        // �ض���  
        return "redirect:http://192.168.43.41:8080/nhdx/index.html";  
    }      


}
