  
    /**    
    * @Title: SalerDao.java  
    * @Package com.example.demo.dao  
    * @Description: TODO(用一句话描述该文件做什么)  
    * @author 彭冲 
    * @date 2018年3月22日  
    * @version V1.0    
    */  
    
package com.example.demo.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Saler;

/**  
    * @ClassName: SalerDao  
    * @Description: TODO(这里用一句话描述这个类的作用)  
    * @author 彭冲 
    * @date 2018年3月22日  
    *    
    */
public interface SalerDao extends JpaRepository<Saler, String> {
	@Query(value="select s_ID, s_name, s_password, s_image, s_tele, "
			+ "s_email, s_address, s_signature, s_date, s_score"
			+ " from saler where s_name=? or s_tele=? or s_email=?" , nativeQuery=true)
	Saler findByKey(String name,String s_tele, String s_email);

}
