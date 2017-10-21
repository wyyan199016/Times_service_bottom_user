package com.stonecode.util;

import org.apache.commons.codec.digest.DigestUtils;

public class StoneEncode {
	
	/***
	 * 随机字符编码
	 * ***/
	public static String stoneEncode(String source){
		String result="";
		char[] sourceArray=source.toCharArray();
		for(int i=0;i<sourceArray.length;i++){
			char c=sourceArray[i];
			if(i==sourceArray.length-1){
				int dec=(int)c;
				String HexString=Integer.toHexString(dec).toLowerCase();
				result+=HexString;
			}else{
				int dec=(int)c;
				String HexString=Integer.toHexString(dec).toLowerCase();
				result+=HexString+getRandom();
			}
		}
		return result;
	}
	
	/***
	 * 固定字符编码
	 * ***/
	public static String stoneEncode(String source,String upercase){
		String result="";
		char[] sourceArray=source.toCharArray();
		for(int i=0;i<sourceArray.length;i++){
			char c=sourceArray[i];
			if(i==sourceArray.length-1){
				int dec=(int)c;
				String HexString=Integer.toHexString(dec).toLowerCase();
				result+=HexString;
			}else{
				int dec=(int)c;
				String HexString=Integer.toHexString(dec).toLowerCase();
				result+=HexString+upercase;
			}
		}
		return result;
	}
	
	public static String stoneDecode(String source){
		String result="";
		String[] sourceArray=source.split("([A-Z])");
		for(String v:sourceArray){
			int xnum=Integer.parseInt(v, 16);
			result+=(char)xnum;
		}
		return result;
	}
	
	private static String getRandom(){   //65-90
		java.util.Random ra =new java.util.Random();
		int r=ra.nextInt(26)+65;
		char c=(char)r;
		return c+"";
	}
	
	public static String md5Encode(String source){
		return DigestUtils.md5Hex(source);
	}
	
	public static void main(String[] args) {
		String encode=StoneEncode.stoneEncode("shiruiaaa@qq.com");
		System.out.println(encode);
		String encode1=StoneEncode.stoneEncode("Abc123");
		System.out.println(encode1);
		System.out.println(md5Encode("123456"));
	}
}
