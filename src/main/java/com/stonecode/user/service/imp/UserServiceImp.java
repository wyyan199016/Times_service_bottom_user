package com.stonecode.user.service.imp;

import com.stonecode.util.Constants;
import com.stonecode.util.JsonUtil;
import com.stonecode.util.StoneEncode;
import com.stonecode.util.StoneUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.Map;
import com.stonecode.database.StoneMapper;
import com.stonecode.user.service.UserService;

@Service("UserServiceImp")
public class UserServiceImp implements UserService{
	private final Logger logger = Logger.getLogger(this.getClass());
	
	@Autowired
	StoneMapper mapper;
	
	@Override
	public Map<String,Object> login(String username,String password) {
		try{
			if(StoneUtil.isStringNotEmpty(username)&&StoneUtil.isStringNotEmpty(password)){
				Map<String,String> params=new HashMap<>();
				params.put("username", StoneEncode.stoneDecode(username));
				params.put("password", StoneEncode.stoneDecode(password));
				Map<String,Object> user= mapper.login(params);
				if(user!=null&&!user.isEmpty()){
					return JsonUtil.formatResult(Constants.HTTP_OK, user);
				}
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
		return JsonUtil.formatResult(Constants.HTTP_ERROR, null);
	}
	
	@Override
	public Map<String,Object> register(String username,String password) {
		try{
			if(StoneUtil.isStringNotEmpty(username)&&StoneUtil.isStringNotEmpty(password)){
				Map<String,String> params=new HashMap<>();
				params.put("userid", StoneUtil.getUniqueId());
				params.put("password", StoneEncode.stoneDecode(password));
				String uname=StoneEncode.stoneDecode(username);
				if(uname.indexOf("@")>-1){
					params.put("email", uname);
					params.put("mobile", "");
				}else{
					params.put("mobile", uname);
					params.put("email", "");
				}
				int num= mapper.register(params);
				return JsonUtil.formatResult(num>0?Constants.HTTP_OK:Constants.HTTP_ERROR, null);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
		return JsonUtil.formatResult(Constants.HTTP_ERROR, null);
	}
	
	@Override
	public Map<String,Object> exist(String username,int flag) {
		try{
			if(StoneUtil.isStringNotEmpty(username)&&flag!=0){
				int num=0;
				Map<String,String> params=new HashMap<>();
				switch(flag){
					case Constants.exist_userid:
						params.put("userid", StoneEncode.stoneDecode(username));
						num= mapper.exist_userid(params);
						break;
					case Constants.exist_email:
						params.put("email", StoneEncode.stoneDecode(username));
						num= mapper.exist_email(params);
						break;
					case Constants.exist_mobile:
						params.put("mobile", StoneEncode.stoneDecode(username));
						num= mapper.exist_mobile(params);
						break;
				}
				return JsonUtil.formatResult(num>0?Constants.HTTP_OK:Constants.HTTP_ERROR, null);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
		return JsonUtil.formatResult(Constants.HTTP_ERROR, null);
	}
	
	@Override
	public Map<String,Object> resetpassword(String username,String password,int flag) {
		try{
			if(StoneUtil.isStringNotEmpty(username)&&StoneUtil.isStringNotEmpty(password)&&flag!=0){
				int num=0;
				Map<String,String> params =new HashMap<String,String>();
				params.put("password", StoneEncode.stoneDecode(password));
				switch(flag){
					case Constants.resetpassword_email:
						params.put("email", StoneEncode.stoneDecode(username));
						num= mapper.resetpassword_email(params);
						break;
					case Constants.resetpassword_mobile:
						params.put("mobile", StoneEncode.stoneDecode(username));
						num= mapper.resetpassword_mobile(params);
						break;
				}
				return JsonUtil.formatResult(num>0?Constants.HTTP_OK:Constants.HTTP_ERROR, null);
			}
		}catch(Exception e){
			logger.error(e.getMessage(), e);
		}
		return JsonUtil.formatResult(Constants.HTTP_ERROR, null);
	}

}
 