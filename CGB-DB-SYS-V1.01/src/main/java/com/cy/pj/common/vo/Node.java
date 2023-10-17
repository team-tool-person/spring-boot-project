package com.cy.pj.common.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Node implements Serializable{

	private static final long serialVersionUID = -8392220068729364105L;
    
    /**
     * 菜单id
     */
    private Integer id;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 父辈菜单id
     */
    private Integer parentId;
}
