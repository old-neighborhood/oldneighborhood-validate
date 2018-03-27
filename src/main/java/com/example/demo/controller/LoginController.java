  
    /**    
    * @Title: LoginController.java  
    * @Package com.example.demo.controller  
    * @Description: TODO(用一句话描述该文件做什么)  
    * @author 彭冲 
    * @date 2018年3月22日  
    * @version V1.0    
    */  
    
package com.example.demo.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Saler;
import com.example.demo.entity.User;
import com.example.demo.service.LoginService;

/**  
    * @ClassName: LoginController  
    * @Description: TODO(这里用一句话描述这个类的作用)  
    * @author 彭冲 
    * @date 2018年3月22日  
    *    
    */
@Controller
public class LoginController {
	@Resource
	private LoginService loginService;
	
	@RequestMapping("/")
	public String test1() {
		return "/login";
	}
	@RequestMapping("/salerInfo")
	public String salerInfo() {
		return "/SalerInfo";
	}
	@RequestMapping("/salerInfoModify")
	public String salerInfoModify() {
		return "/SalerInfoModify";
	}
	@RequestMapping("/userIndex")
	public String User() {
		return "/userIndex";
	}
	@RequestMapping("/salerIndex")
	public String Saler() {
		return "/salerIndex";
	}
	@RequestMapping("/adminIndex")
	public String Admin() {
		return "/adminIndex";
	}
	  
	    /**  
	    * @Title: login  
	    * @Description: TODO(这里用一句话描述这个方法的作用)  
	    * @param @param username
	    * @param @param password
	    * @param @param type
	    * @param @return    参数  
	    * @return String    返回类型  
	    * @throws  
	    */  
	    
	@RequestMapping("/login")
	@ResponseBody
	public String login(@RequestBody Map<String,Object> reqMap) {
		String username = reqMap.get("username").toString();
		String password = reqMap.get("password").toString();
		String type = reqMap.get("type").toString();
		System.out.println(username+" "+password+" "+type);
		if(type.equals("user")) {
			User user = loginService.userLogin(username, password);
			if(user!=null) 
				return "{\"result\":\"success\",\"user\":\""+user.getU_ID()+"\",\"type\":\""+type+"\"}";
			
		}else if(type.equals("saler")) {
			Saler saler = loginService.salerLogin(username, password);
			if(saler!=null)
				return "{\"result\":\"success\",\"saler\":\""+saler.getS_ID()+"\",\"type\":\""+type+"\"}";
		}else if(type.equals("admin")) {
			Admin admin = loginService.adminLogin(username, password);
			if(admin!=null)
				return "{\"result\":\"success\",\"admin\":\""+admin.getAd_ID()+"\",\"type\":\""+type+"\"}";
		}
		return "{\"result\":\"error\"}";
	}
}
