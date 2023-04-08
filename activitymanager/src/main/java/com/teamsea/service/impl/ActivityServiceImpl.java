package com.teamsea.service.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.teamsea.dao.ActivityDao;
import com.teamsea.pojo.Activity;
import com.teamsea.service.ActivityService;
import com.teamsea.tools.FieldInRule;

/**
 * Service 接口实现类
 * 
 * @author TeamSea
 * @version 0.0.1
 */
@Service
public class ActivityServiceImpl implements ActivityService {

	@Autowired
	ActivityDao mapper;

	@Override
	public List<Activity> getActivities() {

		List<Activity> activities = mapper.getActivityts();
		return activities;
	}

	/**
	 * 创建活动方法
	 * */
	@Override
	public boolean createActivity(Activity activity) throws Exception {
		// 验证参数是否有错误
		fieldInRule(activity);

		// 验证是否存在
		if (isExist(activity.getId(), activity.getTitle())) {
			throw new IllegalArgumentException("参数存在,无法添加相同的活动");
		}

		// 进行添加
		updateSuccesses(mapper.createActivity(activity), "添加错误");

		return true;
	}

	/**
	 * 删除活动方法
	 * */
	@Override
	public boolean deleteActivity(Activity activity) {

		// 验证参数是否有错误
		fieldInRule(activity);

		// 验证是否存在
		if (!isExist(activity.getId(), activity.getTitle())) {
			throw new IllegalArgumentException("参数不存在,无法删除不存在的活动");
		}

		// 进行删除
		updateSuccesses(mapper.deleteActivity(activity.getId()), "删除错误");

		return true;
	}
	/**
	 * 更新活动方法
	 * */
	@Override
	public boolean updateActivity(Activity activity) {
		// 验证参数是否有错误
		fieldInRule(activity);

		// 验证是否存在
		if (!isExist(activity.getId(), activity.getTitle())) {
			throw new IllegalArgumentException("参数不存在,无法更新不存在的活动");
		}

		// 进行删除
		updateSuccesses(mapper.deleteActivity(activity.getId()), "更新错误");

		return true;
	}

	/**
	 * 参数检查方法 验证前端传递的参数是否符合规范
	 * 
	 * 1. 除了id 以外不能为空
	 * 
	 * 2. 数字属性不能有负值
	 * 
	 * 3. 字符串不可以有空串
	 * 
	 * 4. 开始时间要在结束时间之前
	 * 
	 */
	public boolean fieldInRule(Activity activity) {

		FieldInRule fieldInRule = new FieldInRule() {

			@Override
			public boolean rule(String name, Object value) {

				// 除了id 以外不能为空
				if (value == null && !"id".equals(name)) {
					throw new IllegalArgumentException(name + "参数为空");
				}

				// 数字属性不能有负值
				if (value instanceof Number && (Integer.parseInt(value.toString()) < 0)) {
					throw new IllegalArgumentException(name + "值为负数");
				}

				// 字符串不可以有空串
				if (value instanceof String && ((String) value).length() == 0) {
					throw new IllegalArgumentException(name + "为字符空串");
				}

				return true;
			}

		};

		boolean b = false;
		try {
			b = fieldInRule.fieldInRule(activity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if (!activity.getStartTime().isBefore(activity.getEndTime())) {
			throw new IllegalArgumentException("开始时间没有在结束时间之前");
		}

		return b;

	}

	/**
	 * 判断活动是否存在
	 * 
	 * @return 存在为真,不存在为假
	 */
	public boolean isExist(Integer id, String title) {

		int row = mapper.isExist(id, title);

		if (row <= 0) {
			return false;
		}
		return true;
	}

	/**
	 * 针对update性sql的优化 对于Update性sql的返还值row进行判断,如果值大于0则为真
	 * 
	 * 
	 * @param 执行SQL语句的返还行数
	 * @param 抛出异常的值
	 * @throws SQLException
	 */
	private boolean updateSuccesses(Integer row, String message) {
		if (row <= 0) {

			throw new NoSuchElementException(message);
		}
		return true;
	}

}
