package com.cy.pj.sys.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.common.vo.Node;
import com.cy.pj.sys.service.MenusService;

@RestController
@RequestMapping("/menu/")
public class MenuController {

    @Autowired
    private MenusService service;

    @RequestMapping("doFindObjects")
    public JsonResult findPageObjects() {
        List<Map<String, Object>> maps = service.findObjects();
        return new JsonResult(maps);
    }

    @RequestMapping("doDeleteObject")
    public JsonResult deleteObject(Integer id){
        service.deleteObject(id);
        return  new JsonResult("delete ok");
    }

    @RequestMapping("doFindZtreeMenuNodes")
    public JsonResult getZtreeMenuNodes(){
        List<Node> nodes = service.findZtreeMenuNodes();
        return new JsonResult(nodes);
    }

}
