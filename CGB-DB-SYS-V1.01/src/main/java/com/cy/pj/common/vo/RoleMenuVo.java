package com.cy.pj.common.vo;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
