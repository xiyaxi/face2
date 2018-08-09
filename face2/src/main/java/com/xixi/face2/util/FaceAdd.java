package com.xixi.face2.util;

import com.baidu.ai.aip.utils.HttpUtil;
import com.baidu.ai.aip.utils.Base64Util;
import com.baidu.ai.aip.utils.FileUtil;
import com.baidu.ai.aip.utils.GsonUtils;

import java.util.*;

/**
* ����ע��
*/
public class FaceAdd {

    public static String add(String token,String usersId,String imgPath) {
        // ����url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/faceset/user/add";
        try {
        	byte[] bytes = FileUtil.readFileByBytes(imgPath);
            String image = Base64Util.encode(bytes);
            Map<String, Object> map = new HashMap<String,Object>();
            map.put("image", image);
            map.put("group_id", "group_repeat");
            map.put("user_id", usersId);
            map.put("user_info", usersId);
            map.put("liveness_control", "NORMAL");
            map.put("image_type", "BASE64");
            map.put("quality_control", "LOW");

            String param = GsonUtils.toJson(map);

            // ע�������Ϊ�˼򻯱���ÿһ������ȥ��ȡaccess_token�����ϻ���access_token�й���ʱ�䣬 �ͻ��˿����л��棬���ں����»�ȡ��
            String accessToken = token;

            String result = HttpUtil.post(url, accessToken, "application/json", param);
            System.out.println(result);
            return result;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String addFace(String usersId,String imgPath) {
    	
      return FaceAdd.add(AuthService.getAuth(),usersId,imgPath);
    }
}