package com.teamsea.daotest;

import org.junit.jupiter.api.Test; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.teamsea.dao.GoodsMapper;
import com.teamsea.pojo.Goods;

@SpringBootTest
public class MySQLTest {

	
	
	@Autowired
	private GoodsMapper mapper;

	@Test
	public void addTest() {

		Goods good = new Goods(2,"曲奇饼干",2000);

		System.out.println(mapper.addGood(good));
	}

	@Test
	public void deleteTest() {

		Goods goods = new Goods(1,"100",50);
		System.out.println(mapper.deleteGood(goods));

	}

	@Test
	public void updateTest() {
		Goods good = new Goods(1, "碧浪", 500);
		System.out.println(mapper.updateGood(good));
	}

	@Test
	public void goodsListTest() {
		
		System.out.println(mapper.goodsList());
		
	
	}
	
	@Test
	public void isExistTest() {
	
		
		Goods goods = new Goods(1, "碧浪", 500);
		System.out.println(mapper.isExist(goods));
		
		goods.setName("海飞丝");
		goods.setId(7);
		System.out.println(mapper.isExist(goods));
		
	}
}