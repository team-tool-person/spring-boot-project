package com.teamsea.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

import javax.crypto.interfaces.DHPublicKey;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamsea.api.exception.ValueAlreadyExistsException;
import com.teamsea.api.exception.ValueNotExistException;
import com.teamsea.dao.GoodsMapper;
import com.teamsea.pojo.Goods;
import com.teamsea.service.GoodsService;

/**
 * 商品管理的业务类 完成商品的增删改查
 * 
 * 
 * 健壮性增强:
 * 
 * 1. 加入验证存在方法: isExist()
 * 
 * 2. 加入参数是否符合规范方法:inStandard()
 * 
 * 3. 增加异常抛出行为,将不同的错误进行分类处理
 * 
 * 
 * 
 * 关于健壮性增强:
 * 
 * 我是s b 真的干这样干
 * 
 * 不仅仅是对异常的抛出和处理,还有对异常的定义和对代码的优化
 * 
 * 所有的update型的sql语句(insert 语句,delete语句,update语句)都有对返还值row进行判定 但是不同的判定
 * 
 * @author TeamSea
 * @version 0.0.1
 * 
 */

@Service
public class GoodsServiceImpl implements GoodsService {

	@Autowired
	private GoodsMapper mapper;

	/**
	 * 商品的列表
	 */
	@Override
	public List<Goods> getGoodsList() {

		List<Goods> goods = mapper.goodsList();

		return goods;
	}

	/**
	 * 添加商品
	 */
	@Override
	public boolean addGood(Goods good) {

		// 验证参数是否符合规范
		if (!inStandard(good)) {
			return false;
		}

		// 验证是否存在
		if (isExist(good)) {
			return false;
		}

		// 不存在,添加
		Integer row = mapper.addGood(good);

		if (row <= 0) {
			return false;
		}

		return true;

	}

	/**
	 * 删除商品
	 */
	@Override
	public boolean deleteGood(Goods good) {

		// 验证参数是否符合规范
		if (!inStandard(good)) {
			return false;
		}

		Integer row = mapper.deleteGood(good);

		if (row <= 0) {
			return false;
		}

		return true;
	}

	/**
	 * 更新商品
	 * 
	 */
	@Override
	public boolean updateGood(Goods oldGood, Goods newGood) {

		// 验证参数是否符合规范
		if (!inStandard(oldGood)) {
			return false;
		}

		if (!inStandard(newGood)) {
			return false;
		}
		// 追加验证
		if (oldGood.getId() != newGood.getId()) {
			return false;
		}

		// 验证是否存在
		if (!isExist(oldGood)) {
			return false;
		}

		Integer row = mapper.updateGood(newGood);

		if (row <= 0) {
			return false;
		}

		return true;
	}

	/**
	 * 使用异常抛出进行健壮性加强 会抛出各种各样的不同的异常
	 * 
	 * @author TeamSea
	 * 
	 */
	@Override
	public boolean addGoodStrengthen(Goods goods) {

		// 进行参数判断
		paramInStandar(goods);
		// 进行存在判定
		if (isExist(goods)) {
			throw new ValueAlreadyExistsException("数据存在,无法插入");
		}
		// 进行插入值

		Integer row = mapper.addGood(goods);

		return updateSuccesses(row, "数据插入错误");

	}

	/***
	 * 使用异常抛出的进行健壮性加强 会抛出各种各样的不同的异常
	 * 
	 * @author TeamSea
	 * @throws Exception
	 * 
	 */
	@Override
	public boolean deleteGoodStrengthen(Goods goods) {

		// 进行参数判断
		paramInStandar(goods);

		// 进行存在判定
		if (!isExist(goods)) {
			throw new ValueNotExistException("数据不存在,无法删除");
		}

		// 进行删除值
		Integer row = mapper.deleteGood(goods);
		
		updateSuccesses(row, "数据删除错误");
		
		return true;
	}

	@Override
	public boolean updateGoodStrengthen(Goods oldGoods, Goods newGoolds) {

		// 进行参数判断
		paramInStandar(oldGoods);
		paramInStandar(newGoolds);
		// 这里追加一个判定两个goods的id是否等
		if (oldGoods.getId() != newGoolds.getId()) {
			throw new IllegalArgumentException("两个参数的id值不相等");
		}

		// 进行存在判定
		if (!isExist(oldGoods)) {
			throw new ValueNotExistException("数据不存在,无法修改");
		}

		// 进行删除值
		Integer row = mapper.updateGood(newGoolds);
		
		updateSuccesses(row, "数据更新错误");
		
		return true;
	}

	/**
	 * 验证商品(id或name)是否存在
	 * 
	 * @param 上层传递的参数
	 * @return 存在为真,不存在为假
	 * 
	 */
	private boolean isExist(Goods good) {
		// 验证是否存在
		Integer flag = mapper.isExist(good);
		if (flag > 0) {
			return true;
		}

		return false;

	}

	/**
	 * 验证传递的值是否符合规范 要验证以下方面 是否有空值 是否有负值 其中允许num为空值,但是不允许为负值
	 * 
	 * @param 上层传递的商品参数
	 * @return 有问题false 没有问题true
	 */
	private boolean inStandard(Goods goods) {

		if (goods == null) {
			return false;
		}
		if (goods.getId() == null || goods.getId() <= 0) {
			return false;
		}
		if (goods.getName() == null || goods.getName().length() <= 0) {
			return false;
		}
		if (goods.getNum() != null && goods.getNum() < 0) {
			return false;
		}

		return true;
	}

	/**
	 * 如果参数不服和规范,抛出异常
	 */
	private boolean inStandardThrow(Goods goods) {

		if (!inStandard(goods)) {
			throw new IllegalArgumentException("参数错误");
		}
		return true;

	}

	/**
	 * 对具体的参数抛出不同的异常
	 * 
	 * @throws Exception
	 */
	private void paramInStandar(Goods goods) {
		if (goods == null) {
			throw new NullPointerException("参数为空");
		}
		if (goods.getId() == null || goods.getId() <= 0) {
			throw new IllegalArgumentException("Id参数错误");
		}
		if (goods.getName() == null || goods.getName().length() == 0) {
			throw new IllegalArgumentException("Name参数错误");
		}
		if (goods.getNum() != null && goods.getNum() < 0) {
			throw new IllegalArgumentException("Num参数错误");
		}

	}

	/**
	 * 针对update性sql的优化 对于Update性sql的返还值row进行判断,如果值大于0则为真
	 * 
	 * @throws SQLException
	 * 
	 */
	private boolean updateSuccesses(Integer row, String message) {
		if (row <= 0) {

			throw new NoSuchElementException(message);
		}
		return true;
	}

}
