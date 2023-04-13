package com.teamsea.mybatistest;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.teamsea.mapper.GoodsMapper;
import com.teamsea.model.Goods;
import com.teamsea.model.GoodsExample;
import com.teamsea.model.GoodsExample.Criteria;

@SpringBootTest
public class mybatisTest {

	@Autowired
	GoodsMapper mapper;

	@Test
	public void sqlTest() {

		// 查询所有商品信息

		// 使用QBC风格 Query By Criteria
		GoodsExample example = new GoodsExample();
		// 创建约束
		Criteria criteria = example.createCriteria();
		// criteria.andNumGreaterThan(50);

		criteria.andNumGreaterThanOrEqualTo(500);

		List<Goods> goods = mapper.selectByExample(example);
		System.out.println(goods);

	}

	// 添加测试方法
	@Test
	public void testAdd() {
		Goods goods = new Goods();
		goods.setName("test");
		goods.setNum(100);
		mapper.insert(goods);
		// 查询刚刚添加的商品信息
		GoodsExample example = new GoodsExample();
		Criteria criteria = example.createCriteria();
		criteria.andNameEqualTo("test");
		List<Goods> goodsList = mapper.selectByExample(example);
		System.out.println(goodsList);
	}

}
