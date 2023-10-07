package com.cy.pj.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.pj.common.vo.JsonResult;
import com.cy.pj.common.vo.PageObject;
import com.cy.pj.sys.entity.SysLog;
import com.cy.pj.sys.service.SysLogService;

/***
 * 日志系统控制层
 */
@Controller
@RequestMapping("/log/")
public class SysLogController {

    @Autowired
    private SysLogService service;

    /***
     * 查询指定用户的某一页的日志数据
     * 
     * @param username    用户名
     * @param pageCurrent 页数
     * @return JSON数据类型
     */
    @RequestMapping("doFindPageObjects")
    @ResponseBody
    public JsonResult findPageObject(String username, Long pageCurrent) {

        PageObject<SysLog> data = service.finPageObject(username, pageCurrent);

        JsonResult result = new JsonResult(data);

        return result;

    }

    /***
     * 删除指定条目
     * 
     * @param ids 条目id号码
     * @return JSON数据类型
     */ 
    @RequestMapping("doDeleteObjects")
    @ResponseBody
    public JsonResult doDeleteObjects(Integer... ids) {

        service.deleteObject(ids);

        return new JsonResult("delete ok");

    }
}
