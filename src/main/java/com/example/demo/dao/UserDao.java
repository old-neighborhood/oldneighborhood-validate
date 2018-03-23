package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.User;

  
    /**  
    * @ClassName: UserDao  
    * @Description: TODO(这里用一句话描述这个类的作用)  
    * @author 彭冲 
    * @date 2018年3月22日  
    *    
    */  
    
public interface UserDao extends JpaRepository<User, String> {
	@Query(value="select u_ID, u_name, u_password, u_image,u_score, u_tele, "
			+ "u_date, u_email, u_signature"
			+ " from user where u_name=? or u_tele=? or u_email=?" , nativeQuery=true)
		User findByKey(String name,String tele,String email);

}
