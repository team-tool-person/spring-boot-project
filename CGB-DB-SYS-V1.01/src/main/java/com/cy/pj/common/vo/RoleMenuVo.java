package com.cy.pj.common.vo;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 基于角色id从数据库中获取数据然后封装到此对象
 * 
 * 在数据表中，角色和菜单时多对多的关系，这里只修改一个角色的信息
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RoleMenuVo implements Serializable {

	private static final long serialVersionUID = -8115408727298083776L;

	private Integer id;
	private String name;
	private String note;

	private List<Integer> menuIds;

}