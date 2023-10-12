package com.cy.pj.sys.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.sys.service.MenusService;

@Controller
@RequestMapping("/menu/")
public class MenuController {

    @Autowired
    private MenusService service;
    
    @RequestMapping("doFindObjects")
    @ResponseBody
    public JsonResult findPageObjects(){

        List<Map<String,Object>> maps = service.findObjects();
        
        return new JsonResult(maps);

    }

}
