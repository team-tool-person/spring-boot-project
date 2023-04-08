package com.teamsea.servicetest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.teamsea.pojo.Goods;
import com.teamsea.service.GoodsService;

/**
 * 本类针对Service方法进行测试
 */
@SpringBootTest
public class ServiceTest {

	@Autowired
	private GoodsService service;

	@Test
	public void getListTest() {
		System.out.println(service.getGoodsList());
	}

	@Test
	public void addGoodTest() {

		Goods goods = new Goods(2, "曲奇饼干", 2000);
		Goods goods2 = new Goods(1, "曲奇饼干", 2000);

		System.out.println(service.addGood(goods2));
		System.out.println(service.addGood(goods));

	}

	@Test
	public void deleteGoodTest() {
		Goods goods = new Goods();
		goods.setId(1);
		goods.setName("碧浪");
		System.out.println(service.deleteGood(goods));
	}

	@Test
	public void updaGoodTest() {
		Goods oldgoods = new Goods(2, "曲奇饼干", 200);
		Goods newgoods = new Goods(1, "曲奇饼干", 500);
		System.out.println(service.updateGood(oldgoods, newgoods));
		newgoods.setId(2);
		System.out.println(service.updateGood(oldgoods, newgoods));
	}

	@Test
	public void addGoodSTest() {
		Goods good1 = null;

		try {
			System.out.println(service.addGoodStrengthen(good1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		good1 = new Goods();

		try {
			System.out.println(service.addGoodStrengthen(good1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		good1.setId(1);
		good1.setName("");

		try {
			System.out.println(service.addGoodStrengthen(good1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		good1.setName("海飞丝");
		good1.setNum(-10000000);

		try {
			System.out.println(service.addGoodStrengthen(good1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		good1.setNum(10000000);
		try {
			System.out.println(service.addGoodStrengthen(good1));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Goods good2 = new Goods(5, "棒棒糖", 500);
		try {
			System.out.println(service.addGoodStrengthen(good2));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void deleteGoodSTest() {
		Goods goods = new Goods();
		goods.setId(1);
		goods.setName("海飞丝");
		try {
			System.out.println(service.deleteGoodStrengthen(goods));
		} catch (Exception e) {
			e.printStackTrace();
		}

		goods.setName("碧浪");
		try {
			System.out.println(service.deleteGoodStrengthen(goods));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void updateGoodSTest() {
		Goods oldgoods = new Goods(2, "曲奇饼干", 200);
		Goods newgoods = new Goods(1, "曲奇饼干", 1222);
		try {
			System.out.println(service.updateGoodStrengthen(oldgoods, newgoods));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		newgoods.setId(2);
		System.out.println(newgoods);
		try {
			System.out.println(service.updateGoodStrengthen(oldgoods, newgoods));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
