package com.teamsea.tools;

import java.io.File;
import java.io.FilenameFilter;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * 描述Spring Boot 启动原理
 * 
 * 通过获取启动类对象来获取到其他的Java项目文件
 */
public class SpringBootStart {

	public static void main(String[] args) throws Exception {

		// 1. 获取启动类对象
		Class<?> startClass = SpringBootStart.class;

		// 2. 获取启动类所在的包
		String packageName = startClass.getPackageName();
		System.out.println("packageName:" + packageName);

		// 将包结构转换为目录结构
		String javaFileDir = packageName.replace(".", "/");
		System.out.println("javaFileDir:" + javaFileDir);

		// 3. 找到所有的Class 文件

		// 先获取class 文件所在的路径
		URL classDir = ClassLoader.getSystemResource(javaFileDir);
		System.out.println("classDir:"+classDir.getPath());
		
		// 通过路径获取到全部(这个包中的)的目录
		File classDirFile = new File(classDir.getPath());
		
		// 使用类过文件名过滤器进行筛选,获取到每个class文件
		String[] classNames = classDirFile.list(new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				return name.endsWith(".class");//&&! name.endsWith("$1.class");
			}
		});
		 
		System.out.println(Arrays.toString(classNames));
		
		// 4. 使用class 文件加载Class 对象
		
		List<Class> classes = new ArrayList<>();		
		for (String  className: classNames) {
			String name = className.substring(0,className.indexOf("."));
			
			Class clazz = ClassLoader.getSystemClassLoader().loadClass(packageName+"."+name);
			System.out.println(clazz);
			
			classes.add(clazz);
		}
		
		System.out.println(classes);
		
		// 5. 通过 注解来对Class 对象进行分类
		List<Class> beans = new ArrayList();
		List<Class> serlvets = new  ArrayList();
		
		 
		
	}

}
