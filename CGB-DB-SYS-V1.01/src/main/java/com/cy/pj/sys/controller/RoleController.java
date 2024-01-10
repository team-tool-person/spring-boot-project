package com.cy.pj.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.Role;
import com.cy.pj.sys.service.RoleService;

@RestController
@RequestMapping("/role/")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("doFindPageObjects")
    public JsonResult doFindPageObjects(String name, Long pageCurrent) {

        PageObject<Role> data = roleService.findPageObject(name, pageCurrent);

        return new JsonResult(data);
    }

    @RequestMapping("doDeleteObject")
    public JsonResult doDeleteObject(Integer id){

        Integer row =  roleService.deleteObject(id);
        
        return new JsonResult("delete ok"+row);

    }

    @RequestMapping("doSaveObject")
    public JsonResult doSaveObjecResult(Role role,Integer[] menuIds){
        Integer row = roleService.saveObejct(role, menuIds);
        return new JsonResult("Insert OK"+row);
    }

}
