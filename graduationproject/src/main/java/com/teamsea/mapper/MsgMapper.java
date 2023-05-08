package com.teamsea.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.teamsea.model.Msg;

@Mapper
public interface MsgMapper {

	/**
	 * 新增Msg
	 * 
	 */
	public int insertMsg(Msg msg);

	/**
	 * 删除Msg
	 * 
	 * 
	 * */
	public int deleteMsgById(Integer id);
	
	/**
	 * 修改Msg
	 * 
	 * 
	 * */
	public int updataMsgById(Msg msg);
	
	/**
	 * 解决Msg
	 * 
	 * */
	public int solvedMsg(Integer id);
	
	/**
	 * 获取到所有的Msg
	 * 
	 */
	public List<Msg> seleteAll();

	/**
	 * 获取到未被解决的Msg
	 * 
	 */
	public List<Msg> selectNotSolved();

}
