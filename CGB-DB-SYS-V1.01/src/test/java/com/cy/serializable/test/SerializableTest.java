package com.cy.serializable.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cy.pj.sys.entity.SysLog;


@SpringBootTest
public class SerializableTest {
	
	String fileName = "D:\\Java\\spring-boot-project\\CGB-DB-SYS-V1.01\\src\\main\\resources\\serializable\\SysLogObject.out";
	
	/**
	 * 	对序列化操作进行测试
	 * @throws Exception 
	 * 
	 * */
	@Test
	public void serializableObject() throws Exception {
		
		// 创建一个SysLog对象 并 给予数据
		SysLog log = new SysLog();
		log.setId(100L);
		log.setIp("192.168.0.1");
		log.setUsername("admin");
		log.setOperation("Update");
		log.setMethod("deleteObject");
		log.setParams("1");
		log.setTime(10L);
		log.setCreatedTime(new Date());
		
		// 对这个对象进行序列化
		//设置序列化文件
		FileOutputStream fileOutputStream = new FileOutputStream(fileName);
		
		// 使用ObjectOutStream进行序列化
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(log); // 将对象序列化到制定的文件
		objectOutputStream.close();
		System.out.println("序列化完毕");
		
	}
	
	/**
	 * 	反序列化
	 * 
	 * 	对序列化的文件读取到内存中
	 * @throws Exception 
	 * 
	 * */
	@Test
	public void deserialization() throws Exception {
		
		// 获取序列化文件
		FileInputStream fileInputStream = new FileInputStream(fileName);
		
		// 使用Object
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		Object object = objectInputStream.readObject();// 将序列化文件转化为对象保存在内存中
		
		objectInputStream.close();
		System.out.println(object);
		
	}

}
