package com.xixi.doubleTableSelectc.ontroller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class FileUploadController {

	//�ϴ��ļ����Զ��󶨵�MultipartFile��
    @RequestMapping(value="/upload",method=RequestMethod.POST)
    public String upload(HttpServletRequest request, String description,MultipartFile file) throws Exception {

       System.out.println(description);
       //����ļ���Ϊ�գ�д���ϴ�·��
       if(!file.isEmpty()) {
           //�ϴ��ļ�·��
           String path = request.getServletContext().getRealPath("/images/");
           //�ϴ��ļ���
           String filename = file.getOriginalFilename();
           File filepath = new File(path,filename);
           //�ж�·���Ƿ���ڣ���������ھʹ���һ��
           if (!filepath.getParentFile().exists()) { 
               filepath.getParentFile().mkdirs();
           }
           //���ϴ��ļ����浽һ��Ŀ���ļ�����
           file.transferTo(new File(path + File.separator + filename));
           return "success";
       } else {
           return "error";
       }

    }
}
