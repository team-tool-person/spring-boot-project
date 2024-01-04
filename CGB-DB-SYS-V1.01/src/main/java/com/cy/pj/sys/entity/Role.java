package com.cy.pj.sys.entity;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysRole implements Serializable{

	/**
	 * 序列化id 
	 */
	private static final long serialVersionUID = 8676320356852063050L;
	private Integer id;
	private String name;
	private String note;
	private LocalDate createdTime;
	private LocalDate modifiedTime;
	private String createdUser;
	private String modifiedUser;
	
}
