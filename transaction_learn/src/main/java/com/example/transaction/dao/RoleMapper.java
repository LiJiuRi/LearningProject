package com.example.transaction.dao;

import com.example.transaction.dto.Role;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
//@CacheNamespace
public interface RoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Role record);

    int insertBatch(@Param("list") List<Role> list);

    int insertSelective(Role record);

    Role selectByPrimaryKey(Integer id);

    List<Role> list();

    int updateByPrimaryKeySelective(Role record);

    int updateByPrimaryKey(Role record);
}