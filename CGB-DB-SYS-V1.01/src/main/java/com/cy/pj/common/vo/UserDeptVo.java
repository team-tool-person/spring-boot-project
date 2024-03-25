package com.cy.pj.common.vo;

import java.io.Serializable;
import java.util.Date;

import com.cy.pj.sys.entity.SysDept;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDeptVo implements Serializable{
	
	private static final long serialVersionUID = 4625097425315699421L;
	
	private Long id;
	private String username;
	private String salt;
	private String email;
	private String mobile;
	private Integer valid;
	private SysDept sysDept;
	private Date createTime;
	private Date modifiedTime;
	private String createdUser;
	private String modifiedUser;
}
