package com.stonecode.util;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class StoneUtil {
	 
	 public static boolean isStringNotEmpty(String param){
		 if(param!=null&&!param.isEmpty()){
			 return true;
		 }
		 return false;
	 }
	 
	 public static String getUniqueId() {
		UUID uuid = UUID.randomUUID();
		return uuid.toString();
	 }
	 
}
