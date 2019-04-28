package com.demo.SMS;

/**
 * 验证码通知短信接口
 * 
 * @ClassName: IndustrySMS
 * @Description: 验证码通知短信接口
 *
 */
public class IndustrySMS
{
	private static String operation = "/industrySMS/sendSMS";//操作
	private static String accountSid = Config.ACCOUNT_SID;
	private static String smsContent="【XXXX】登录验证码：" ;//短信内容
	/**
	 * 验证码通知短信
	 */
	public static String execute(String to,String code)
	{
		String url = Config.BASE_URL + operation;
		String body ="accountSid="+accountSid+"&smsContent="+"【XXXX】登录验证码："+code+"，如非本人操作，请忽略此短信。"+"&to="+to+ HttpUtil.createCommonParam();

		// 提交请求
		String result = HttpUtil.post(url, body);
		return result;
	}
}
