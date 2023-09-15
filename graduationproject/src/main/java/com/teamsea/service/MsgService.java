package com.teamsea.service;

import java.util.List;

import com.teamsea.model.MsgShow;

/**
 * Msg业务层接口
 * 
 */
public interface MsgService {

    /**
     * 获取所有信息
     *
     */
    public List<MsgShow> getMsgShows();

    /**
     * 	删除信息
     * 
     * */
	public Integer deleteMsg(Integer id);

}
