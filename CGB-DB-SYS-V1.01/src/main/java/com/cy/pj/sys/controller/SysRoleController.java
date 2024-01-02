package com.cy.pj.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysRole;
import com.cy.pj.sys.service.SysRoleService;


@RestController
@RequestMapping("/role/")
public class SysRoleController {

    @Autowired
    private SysRoleService sysRoleService;

    @RequestMapping("doFindPageObjects")
    public JsonResult doFindPageObjects(String name, Long pageCurrent){

        PageObject<SysRole> data =  sysRoleService.findPageObject(name,pageCurrent);

        return new JsonResult(data);
    }

}
