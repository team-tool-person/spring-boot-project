package com.teamsea.tools;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 对一个对象的所有参数经合法性的验证
 * 
 * 这个方法支持 pojo 类型(所有的属性都是private)
 * 
 * 使用这个AIP要对 rule方法进行重写,来编写规定
 * 
 * 
 */

public abstract class FieldInRule {

	/**
	 * 验证Object中的所有参数是否符合规范
	 * 
	 * @throws IntrospectionException
	 * @throws InvocationTargetException
	 * @throws IllegalAccessException
	 */
	public boolean fieldInRule(Object object)
			throws Exception {
		boolean flag = false;

		if (object == null) {
			throw new NullPointerException("这个对象是空的");
		}

		// 获取这个对象的类对象
		Class<?> clazz = object.getClass();

		// 获取对象中的所有属性
		Field[] fields = clazz.getDeclaredFields();

		// 挨个获取值,和所有的名称,并进行判断

		for (Field field : fields) {
			// 使用 PropertyDescriptor 获取属性的值
			PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);

			Method getMethod = pd.getReadMethod();

			// 这里的 value 就是属性的值
			Object value = getMethod.invoke(object);

			flag = rule(field.getName(), value);

		}

		return flag;
	}

	/**
	 * 规则方法
	 * 
	 * 这个方法由开发人员自己编写判断规则
	 * 
	 * 这个方法建议只判断一些普通规则
	 * 
	 * 建议抛出异常
	 *
	 */
	public abstract boolean rule(String name, Object value) throws Exception;

}
