package com.cy.pj.common.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult implements Serializable {

    private static final long serialVersionUID = 2080943344863436345L;

    /**
     * 状态码
     * 1表示SUCCESS
     * 0表示ERROR
     */
    private byte state = 1;

    /**
     * 传递的信息
     */
    private String message = "ok";

    /**
     * 正确的数据
     */
    private Object data;

    /**
     * 当业务层抛出异常
     * 获取信息失败
     */
    public JsonResult(Throwable t){
        this.state = 0;
        this.message = t.getMessage();
    }

    /**
     * 获取信息成功
     * 直接将信息进行写入
     */
    public JsonResult(Object data){
        this.data = data; 
    }
}
