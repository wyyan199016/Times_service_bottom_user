package com.stonecode.user.service;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

public interface UserService {
	
	Map<String,Object> login(String username,String password);
	Map<String,Object> register(String username,String password);
	Map<String,Object> exist(String username,int flag);
	Map<String,Object> resetpassword(String username,String password,int flag);

}
