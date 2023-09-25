package com.cy.pj.common.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cy.pj.common.vo.JsonResult;

import lombok.extern.log4j.Log4j2;

/***
 * 这是一个异常全局处理类型
 * 
 * 整个项目的中可以抛出到前端的异常都可以由整个类来处理
 * 
 */
@Log4j2
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public JsonResult doHandleRuntimeException(RuntimeException exception) {

        log.info(exception.getMessage());

        // 在控制台上打印输出异常信息
        // exception.printStackTrace();

        // 将结果传递到前端
        return new JsonResult(exception);
    }

}
