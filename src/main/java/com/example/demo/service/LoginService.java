package com.example.demo.service;

import com.example.demo.entity.Admin;
import com.example.demo.entity.Saler;
import com.example.demo.entity.User;

public interface LoginService {
	public User userLogin(String name,String password);
	public Saler salerLogin(String name,String password);
	public Admin adminLogin(String name,String password);
}
