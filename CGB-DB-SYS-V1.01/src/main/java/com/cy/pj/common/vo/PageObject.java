package com.cy.pj.common.vo;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 页面展值对象
 * 
 * 其中包括了向前端页面传输的所有的值
 * 
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PageObject<T> implements Serializable {

	/**
	 * 序列化ID
	 */
	private static final long serialVersionUID = 1536631092048817285L;

	/**
	 * 当前页码数,默认值为1
	 */
	private Long pageCurrent = 1L;

	/**
	 * 页面展示数据数,默认值为3
	 */
	private Integer pageSize = 3;

	/**
	 * 总数据数
	 */
	private Long rowCount = 0L;

	/**
	 * 总页数
	 */
	private Long pageCount = 0L;

	/**
	 * 查询的数据
	 */
	private List<T> records;

	/**
	 * 使用构造方法对属性赋值
	 * 
	 * @param pageCurrent 当前页码数
	 * @param pageSize	页面大小
	 * @param rowCount	总记录数
	 * @param records	记录
	 */
	public PageObject(Long pageCurrent, Integer pageSize, Long rowCount, List<T> records) {
		super();
		this.pageCurrent = pageCurrent;
		this.pageSize = pageSize;
		this.rowCount = rowCount;
		this.records = records;
		
		// 对总页面数进行赋值 总数/大小
//		this.pageCount = rowCount/pageSize;
//		// 如果不能整除则加一
//		if(rowCount % pageSize !=0) {
//			this.pageCount++;
//		}
		this.pageCount= (rowCount-1)/pageSize+1;
		
		
	}
	

	

}
