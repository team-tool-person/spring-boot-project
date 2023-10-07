package com.cy.pj.sys.service;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysLog;

/**
 * 日志页面操作接口
 * 
 * 本接口提供对日志的操作
 * 
 * 
 */
public interface SysLogService {
	
	
	/**
	 * 指定用户的某一页信息
	 * 
	 * @param username 用户名
	 * @param pageCurrent 页码
	 * @return 当前页记录,分页信息
	 */
	PageObject<SysLog> finPageObject(String username, Long pageCurrent);
  
	
	/**
     * 删除指定条目
     * 
     * @param ids 条目id号码
     * @return 影响的行数
	 */
	Integer deleteObject(Integer...ids);
	

	
	
}
