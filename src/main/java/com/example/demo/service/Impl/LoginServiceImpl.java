package com.example.demo.service.Impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.dao.AdminDao;
import com.example.demo.dao.SalerDao;
import com.example.demo.dao.UserDao;
import com.example.demo.entity.Admin;
import com.example.demo.entity.Saler;
import com.example.demo.entity.User;
import com.example.demo.service.LoginService;
@Service("LoginService")
public class LoginServiceImpl implements LoginService {
	@Resource
	private UserDao userDao ;
	@Resource
	private SalerDao salerDao ;
	@Resource
	private AdminDao adminDao ;
	@Override
	public User userLogin(String name, String password) {
		User user=userDao.findByKey(name,name,name);
		if(user!=null&&user.getU_password().equals(password))
			return user;
		return null;
	}

	@Override
	public Saler salerLogin(String name, String password) {
		Saler saler=salerDao.findByKey(name,name,name);
		if(saler!=null&&saler.getS_password().equals(password))
			return saler;
		return null;
	}

	@Override
	public Admin adminLogin(String name, String password) {
		Admin admin=adminDao.findByAd_name(name);
		if(admin!=null&&admin.getAd_password().equals(password))
			return admin;
		return null;
	}

}
