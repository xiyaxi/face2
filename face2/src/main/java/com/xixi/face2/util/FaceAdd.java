package com.xixi.face2.util;

import com.baidu.ai.aip.utils.HttpUtil;
import com.baidu.ai.aip.utils.Base64Util;
import com.baidu.ai.aip.utils.FileUtil;
import com.baidu.ai.aip.utils.GsonUtils;

import java.util.*;

/**
* 人脸注册
*/
public class FaceAdd {

    public static String add(String token,String usersId,String imgPath) {
        // 请求url
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

            // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
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