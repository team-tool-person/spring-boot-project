package com.teamsea.service;

import java.util.List;

import com.teamsea.pojo.Goods;

public interface GoodsService {

	/**
	 * 获取商品列表
	 * 
	 * @return 商品列表
	 */
	public List<Goods> getGoodsList();

	/**
	 * 增加商品 失败原因:商品有重复或者添加语句有问题
	 * 
	 * @return 如果添加成功为true
	 * 
	 */
	public boolean addGood(Goods good);

	/**
	 * 删除商品 失败原因:数据库删除错误
	 * 
	 * @return 成功为真
	 */
	public boolean deleteGood(Goods good);

	/**
	 * 修改商品 失败原因:商品不存在,数据库错误
	 * 
	 * @return 成功为真
	 */
	boolean updateGood(Goods oldGood, Goods newGood);

	// 下面是本人脑子抽风写出了的玩意
	public boolean addGoodStrengthen(Goods goods);

	public boolean deleteGoodStrengthen(Goods goods);

	public boolean updateGoodStrengthen(Goods oldGoods, Goods newGoold);

}
