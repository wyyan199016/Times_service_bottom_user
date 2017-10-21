package com.stonecode.user.controller;

import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.stonecode.user.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	@Qualifier("UserServiceImp")
	private UserService userService;
	
	@Value("${server.port}")
	private int port;
	
	@RequestMapping(value = "/login/{username}/{password}")
    public Map<String,Object> login(@PathVariable String username,@PathVariable String password) {
		System.out.println("Times_service_bottom_user port"+port);
		return userService.login(username,password);
    }
	
	@RequestMapping(value = "/register/{username}/{password}")
    public Map<String,Object> register(@PathVariable String username,@PathVariable String password) {
		return userService.register(username,password);
    }
	
	@RequestMapping(value = "/exist/{username}/{flag}")
    public Map<String,Object> exist(@PathVariable String username,@PathVariable int flag) {
		return userService.exist(username,flag);
    }
	
	@RequestMapping(value = "/resetpassword/{username}/{password}/flag")
    public Map<String,Object> resetpassword(@PathVariable String username,@PathVariable String password,@PathVariable int flag) {
		return userService.resetpassword(username,password,flag);
    }
	
}
