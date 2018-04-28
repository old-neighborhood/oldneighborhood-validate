  
    /**    
    * @Title: Admin.java  
    * @Package com.example.demo.entity  
    * @Description: TODO(用一句话描述该文件做什么)  
    * @author 彭冲 
    * @date 2018年3月22日  
    * @version V1.0    
    */  
    
package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**  
    * @ClassName: Admin  
    * @Description: TODO(这里用一句话描述这个类的作用)  
    * @author 彭冲 
    * @date 2018年3月22日  
    *    
    */
@Entity
@Table(name = "admin")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Admin implements Serializable{

	  
	    /**  
	    * @Fields field:field:{todo}(用一句话描述这个变量表示什么)  
	    */  
	    
	private static final long serialVersionUID = 4211746646205851747L;
	
	  
		    /**  
		     * 创建一个新的实例 Admin.  
		     *  
		     * @param ad_ID
		     * @param ad_name
		     * @param ad_password
		     * @param ad_image  
		     */  
		    
		
	@Id @NonNull
	private String ad_ID;
	@NonNull
	private String ad_name;
	@NonNull
	private String ad_password;
	@NonNull
	private String ad_image;
	@NonNull
	private String ad_permission;
}
