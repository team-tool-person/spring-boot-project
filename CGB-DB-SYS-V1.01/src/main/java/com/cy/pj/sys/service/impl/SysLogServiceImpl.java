package com.cy.pj.sys.service.impl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.dao.SysLogDao;
import com.cy.pj.sys.entity.SysLog;
import com.cy.pj.sys.service.SysLogService;

/**
 * Java 日志业务层实现类
 * 
 * 
 * 
 */
@Service
public class SysLogServiceImpl implements SysLogService {

	/**
	 * 页面最多显示10行数据
	 */
	private static final Integer pageSize = 10;

	@Autowired
	private SysLogDao sysLogDao;

	/**
	 * 通过用户名来查询某一页的信息
	 * 
	 * @param username    用户名
	 * @param pageCurrent 页码
	 * @return 当前页记录,分页信息
	 */
	/*
	 * 这个方法分为四部分
	 * 1. 校验参数
	 * 2. 查询总数,校验参数
	 * 3. 查询记录
	 * 4. 封装数据
	 */
	@Override
	public PageObject<SysLog> finPageObject(String username, Long pageCurrent) {

		// 1. 校验参数
		/*
		 *
		 * 其中username 可以为空值
		 * 
		 * pageCurrent不能为空值,且值要大于1
		 *
		 */
		if (pageCurrent == null || pageCurrent < 1) {
			throw new IllegalArgumentException("页码值错误");
		}

		// 2. 查询总记录数,并校验
		/*
		 * 如果没有数据,提示没有记录
		 * 
		 * 如果页码数数不能大于总页数
		 */
		Long rowCount = sysLogDao.getRowCount(username).longValue();

		// 如果没有数据
		if (rowCount == 0) {
			throw new NoSuchElementException("没有记录");
		}

		// 计算总页数
		Long pageCount = (rowCount - 1) / pageSize + 1;

		// 页码数要小于总数
		if (pageCurrent > pageCount) {
			throw new IllegalArgumentException("页码值错误");
		}

		// 3. 查询当前页页码记录
		Long startIndex = (pageCurrent - 1) * pageSize;
		
		List<SysLog> sysLogs = sysLogDao.findPageObject(username, startIndex, pageSize);

		// 4. 对查询结果进行封装
		PageObject<SysLog> logPageObject = new PageObject<SysLog>(pageCurrent, pageSize, rowCount, sysLogs);

		return logPageObject;
	}

	/**
	 * 删除指定条目
	 * 
	 * @param ids 条目id号码
	 * @return 影响的行数
	 */
	@Override
	public Integer deleteObject(Integer... ids) {
		int row = 0;

		if (ids == null || ids.length == 0) {
			throw new IllegalArgumentException("id值为空");
		}

		// 处理有可能出现的SQL异常
		try {
			row = sysLogDao.deleteObject(ids);
		} catch (Exception e) {
			e.printStackTrace();
			//TODO 需要联系运维人员
			throw new RuntimeException(e);
		}

		if (row <= 0) {
			throw new NoSuchElementException("记录已经不存在");
		}

		return row;
	}
   
}
