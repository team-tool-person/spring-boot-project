package com.teamsea.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.teamsea.bean.User;

@Mapper
public interface UserMapper {

	
	@Insert("insert into users(name) value (#{name})")
	public int insertUser(String name);
	
	@Select("select name from users limit #{n},#{m}")
	public List<User> userPage(int n,int m);
	
	@Delete("delete from users where name = #{name} ")
	public int deleteUserByName(String name);
	
	/**
	 * 	插入多个数据
	 * 	使用动态复杂SQL所以将SQL语句写在XML文件中
	 * 	
	 * 	对@Param解释,因为在早年间,对参数名称无法直接获取
	 * 	会使用@Param来对这个参数命名
	 * */
	public int insertUsers(@Param("names") String... names);

	public int deleteUsers(@Param("names") String... names);
	
	
	/**查询User信息*/
	@Select("select id,name from users")
	public List<User> findUsers();
	
}
