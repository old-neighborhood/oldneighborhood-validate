  
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
	@ResponseBody
	public String test1() {
		return "/login";
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
	    String ID = "";
		@RequestMapping("/getID")
		@ResponseBody
		public String getID() {
			return ID;
		}
	    
		@RequestMapping("/getInfo")
		@ResponseBody
		public String getInfo(@RequestBody Map<String,Object> reqMap) {
			return loginService.getInfo(
					reqMap.get("ID").toString(),
					reqMap.get("type").toString()
					);
		}
		
		
	@RequestMapping("/login")
	@ResponseBody
	public String login(@RequestBody Map<String,Object> reqMap) {
		String username = reqMap.get("username").toString();
		String password = reqMap.get("password").toString();
		String type = reqMap.get("type").toString();
		System.out.println("here"+username+" "+password+" "+type);
		if(type.equals("user")) {
			User user = loginService.userLogin(username, password);
			if(user!=null) { 
				ID = user.getU_ID();
				return "{\"result\":\"success\",\"ID\":\""+user.getU_ID()+"\",\"type\":\""+type+"\"}";
			}
		}else if(type.equals("saler")) {
			Saler saler = loginService.salerLogin(username, password);
			if(saler!=null) {
				ID = saler.getS_ID();
				return "{\"result\":\"success\",\"ID\":\""+saler.getS_ID()+"\",\"type\":\""+type+"\"}";
			}
		}else if(type.equals("admin")) {
			Admin admin = loginService.adminLogin(username, password);
			if(admin!=null) {
				ID = admin.getAd_ID();
				return "{\"result\":\"success\",\"ID\":\""+admin.getAd_ID()+"\",\"type\":\""+type+"\"}";
			}
		}
		return "{\"result\":\"error\"}";
	}
}
