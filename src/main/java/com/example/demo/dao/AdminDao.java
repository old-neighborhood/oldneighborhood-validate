  
    /**    
    * @Title: AdminDao.java  
    * @Package com.example.demo.dao  
    * @Description: TODO(用一句话描述该文件做什么)  
    * @author 彭冲 
    * @date 2018年3月22日  
    * @version V1.0    
    */  
    
package com.example.demo.dao;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Admin;

/**  
    * @ClassName: AdminDao  
    * @Description: TODO(这里用一句话描述这个类的作用)  
    * @author 彭冲 
    * @date 2018年3月22日  
    *    
    */

public interface AdminDao extends JpaRepository<Admin, Serializable> {

	@Query(value="select ad_ID, ad_name, ad_password, ad_image from admin where ad_name=?" , nativeQuery=true)
	Admin findByAd_name(String name);

}
