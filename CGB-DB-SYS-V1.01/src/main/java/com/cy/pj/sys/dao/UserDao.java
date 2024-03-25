package com.cy.pj.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.cy.pj.common.vo.UserDeptVo;

@Mapper
public interface UserDao {
    
    Integer pageSize = 3;

    Integer getRowCount(String username);

    List<UserDeptVo> findPageObject(String username, Integer startIndex,Integer pageSize);
}
