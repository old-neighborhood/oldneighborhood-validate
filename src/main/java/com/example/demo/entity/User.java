  
    /**    
    * @Title: User.java  
    * @Package com.example.demo.entity  
    * @Description: TODO(用一句话描述该文件做什么)  
    * @author 彭冲 
    * @date 2018年3月21日  
    * @version V1.0    
    */  
    
package com.example.demo.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

/**  
    * @ClassName: User  
    * @Description: 创建一个新的实例 User.
    * @author 彭冲 
    * @date 2018年3月21日  
    *    
    */
@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
@Data
@Builder
public class User implements Serializable{
	    /**  
	    * @Fields field:field  
	    */  
	    
	private static final long serialVersionUID = -1369148652554782331L;
	  
		    /**  
		     * 创建一个新的实例 User.  
		     *  
		     * @param u_ID
		     * @param u_name
		     * @param u_password
		     * @param u_image
		     * @param u_score
		     * @param u_tele
		     * @param u_date
		     * @param u_email
		     * @param u_signature  
		     */  
		     
	@Id @NonNull
	private String u_ID;
	@NonNull
	private String u_name;
	@NonNull
	private String u_password;
	@NonNull
	private String u_image;
	@NonNull
	private Integer u_score;
	@NonNull
	private String u_tele;
	@Column(columnDefinition = "timestamp not null default now()", updatable = false)
	private Timestamp u_date;
	private String u_email;
	@NonNull
	private String u_signature;
	
}
