package com.demo.SMS;

public class RandomNum {
	private String  random=(int)((Math.random()*9+1)*100000)+"";//调用math.random函数生成0-9的随机数，乘以100000
	public static String num;
	public String getRandom(){
		return random;
	}
} 

//随机验证码