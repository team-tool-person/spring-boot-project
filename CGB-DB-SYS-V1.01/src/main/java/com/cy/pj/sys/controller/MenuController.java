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


    /**
     * 查找所有的菜单节点
     * @return 所有菜单阶节点的JSON数据
     */
    @RequestMapping("doFindObjects")
    public JsonResult findPageObjects() {
        List<Map<String, Object>> maps = service.findObjects();
        return new JsonResult(maps);
    }

    /**
     * 删除一个菜单节点
     * 
     * @param id 要删除的菜单阶段id
     * @return 删除提示JSON数据
     */
    @RequestMapping("doDeleteObject")
    public JsonResult deleteObject(Integer id){
        service.deleteObject(id);
        return  new JsonResult("delete ok");
    }
    
    /**
     * 查找节点数的所有结点
     * @return
     */
    @RequestMapping("doFindZtreeMenuNodes")
    public JsonResult getZtreeMenuNodes(){
        List<Node> nodes = service.findZtreeMenuNodes();
        return new JsonResult(nodes);
    }

}
