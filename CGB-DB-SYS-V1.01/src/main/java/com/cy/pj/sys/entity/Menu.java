package com.cy.pj.sys.entity;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Menu {

    /**
     * id
     */
    private Integer id;

    /**
     * 名称
     */
    private String name;

    /**
     * 访问地址
     */
    private String url;

    /**
     * 类型
     */
    private int type;

    /**
     * 排序
     */
    private int sort;

    /**
     * 排序
     */
    private String note;

    /**
     * 父菜单id
     */
    private Integer parentId;

    /**
     * 备注
     */
    private String permission;

    private LocalDateTime createDateTime;

    private LocalDateTime modifiedTime;

    private String createdUser;

    private String modifiedUser;

    /**
     * 父菜单名称
     */
    private String parentName;

}
