import java.io.IOException;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import util.StringUtil;


//接口类型：互亿无线语音验证码接口。
//账户注册：请通过该地址开通账户http://user.ihuyi.com/register.html
//注意事项：
//（1）调试期间，请仔细阅读接口文档；
//（2）请使用 APIID 及 APIKEY来调用接口，可在会员中心获取；
//（3）该代码仅供接入互亿无线短信接口参考使用，客户可根据实际需要自行编写；

public class sendvoice {
	
	private static String Url = "http://api.voice.ihuyi.com/webservice/voice.php?method=Submit";

	public static void main(String [] args) {
		
		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(Url);

		//client.getParams().setContentCharset("GBK");
		client.getParams().setContentCharset("UTF-8");
		method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=UTF-8");

		NameValuePair[] data = {//提交短信
			    new NameValuePair("account", "V60082210"),//查看用户名 登录用户中心->语音验证码>产品总览->API接口信息->APIID
			    new NameValuePair("password", "2ebdc0c4b3ecc7a95f8ff25281438fc6"), //查看密码   登录用户中心->语音验证码>产品总览->API接口信息->APIKEY
			    new NameValuePair("mobile", "15347331541"),//手机号码
			    new NameValuePair("content", "1115"),
		};

		method.setRequestBody(data);

		try {
			client.executeMethod(method);
			
			String SubmitResult = method.getResponseBodyAsString();

			//System.out.println(SubmitResult);

			Document doc = DocumentHelper.parseText(SubmitResult); 
			Element root = doc.getRootElement();

			String code = root.elementText("code");
			String msg = root.elementText("msg");
			String voiceid = root.elementText("voiceid");

			System.out.println(code);
			System.out.println(msg);
			System.out.println(voiceid);

			 if("2".equals(code)){
				System.out.println("短信提交成功");
			}

		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}