package com.stonecode.database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.SelectProvider;

@org.apache.ibatis.annotations.Mapper
public interface StoneMapper {
	
	Map<String,Object> login(Map<String,String> params);
	int register(Map<String,String> params);
	int exist_userid(Map<String,String> params);
	int exist_email(Map<String,String> params);
	int exist_mobile(Map<String,String> params);
	int resetpassword_email(Map<String,String> params);
	int resetpassword_mobile(Map<String,String> params);
	
}
