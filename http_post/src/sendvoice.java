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


//�ӿ����ͣ���������������֤��ӿڡ�
//�˻�ע�᣺��ͨ���õ�ַ��ͨ�˻�http://user.ihuyi.com/register.html
//ע�����
//��1�������ڼ䣬����ϸ�Ķ��ӿ��ĵ���
//��2����ʹ�� APIID �� APIKEY�����ýӿڣ����ڻ�Ա���Ļ�ȡ��
//��3���ô���������뻥�����߶��Žӿڲο�ʹ�ã��ͻ��ɸ���ʵ����Ҫ���б�д��

public class sendvoice {
	
	private static String Url = "http://api.voice.ihuyi.com/webservice/voice.php?method=Submit";

	public static void main(String [] args) {
		
		HttpClient client = new HttpClient();
		PostMethod method = new PostMethod(Url);

		//client.getParams().setContentCharset("GBK");
		client.getParams().setContentCharset("UTF-8");
		method.setRequestHeader("ContentType","application/x-www-form-urlencoded;charset=UTF-8");

		NameValuePair[] data = {//�ύ����
			    new NameValuePair("account", "V60082210"),//�鿴�û��� ��¼�û�����->������֤��>��Ʒ����->API�ӿ���Ϣ->APIID
			    new NameValuePair("password", "2ebdc0c4b3ecc7a95f8ff25281438fc6"), //�鿴����   ��¼�û�����->������֤��>��Ʒ����->API�ӿ���Ϣ->APIKEY
			    new NameValuePair("mobile", "15347331541"),//�ֻ�����
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
				System.out.println("�����ύ�ɹ�");
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