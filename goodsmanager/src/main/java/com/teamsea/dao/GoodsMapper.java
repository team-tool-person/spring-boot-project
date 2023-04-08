package com.teamsea.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.teamsea.pojo.Goods;

@Mapper
public interface GoodsMapper {

	public int addGood(Goods good);

	public int deleteGood(Goods good);

	public int updateGood(Goods good);

	public List<Goods> goodsList();
	
	/**
	 * 商品是否存在,id或name是否相同
	 * 
	 * 返回的值id,name 符合的行数
	 * */
	public int isExist(Goods good);

}
