package com.stonecode.util;

import java.util.HashMap;
import java.util.Map;

public class JsonUtil {
	
	public static Map<String,Object> formatResult(String code,Map<String,Object> data){
		 Map<String,Object> result=new HashMap<>();
		 result.put(Constants.HTTP_CODE, code);
		 if(data!=null&&!data.isEmpty()){
			 result.put(Constants.HTTP_DATA, data);
		 }
		 return result;
	 }
}
