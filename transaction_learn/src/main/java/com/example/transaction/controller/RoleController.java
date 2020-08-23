package com.example.transaction.controller;

import com.alibaba.fastjson.JSON;
import com.example.transaction.dao.RoleMapper;
import com.example.transaction.dto.Role;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;

/**
 * @Auther: liXu
 * @Date: 2019/12/8 13:13
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/role")
@Api(description = "用户",tags = "用户接口")
@Transactional
public class RoleController {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @PostMapping("/transaction")
    @ApiOperation(value="测试事务的提交", tags = "用户接口")
    public void test(@ApiParam(value = "用户") @RequestBody Role role) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        SqlSession sqlSession1 = sqlSessionFactory.openSession();
        try {
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Role returnRole0 = roleMapper.selectByPrimaryKey(142);
            Role returnRole1 = roleMapper.selectByPrimaryKey(142);
            log.info("------------------------横线-----------------------");
            sqlSession.commit();
            RoleMapper roleMapper1 = sqlSession1.getMapper(RoleMapper.class);
            Role returnRole3 = roleMapper1.selectByPrimaryKey(142);
            Role returnRole4 = roleMapper1.selectByPrimaryKey(142);
        }catch (Exception e){
            log.info("异常信息：",e);
        }finally {
            sqlSession.close();
            sqlSession1.close();
        }
    }

    /*@PostMapping("/transaction1")
    @ApiOperation(value="测试事务的提交", tags = "用户接口")
    public void test1(@ApiParam(value = "用户") @RequestBody Role role) {
        Role returnRole = roleMapper.selectByPrimaryKey(142);
        Role returnRole1 = roleMapper.selectByPrimaryKey(142);
        roleMapper.insert(role);
        Role returnRole3 = roleMapper.selectByPrimaryKey(142);
        Role returnRole2 = roleMapper.selectByPrimaryKey(734);
        log.info("returnRole的值={}", JSON.toJSON(returnRole));
    }

    @GetMapping("/select")
    @ApiOperation(value="select", tags = "用户接口")
    public Role select(){
        return roleMapper.selectByPrimaryKey(23);
    }

    @PostMapping("/insert")
    @ApiOperation(value="inert", tags = "用户接口")
    public void inert() {
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.SIMPLE,false);
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        Long start = System.currentTimeMillis();
        Role role;
        for (int i = 0; i < 10000; i++) {
            role = new Role();
            role.setId(i);
            role.setName("name" + i);
            roleMapper.insert(role);
        }
        log.info("业务代码循环插入10000条数据耗时={}" + (System.currentTimeMillis() - start));
    }

    @PostMapping("/insert1")
    @ApiOperation(value="inert1", tags = "用户接口")
    public void inert1() {
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        Long start = System.currentTimeMillis();
        Role role;
        for (int i = 0; i < 100000; i++) {
            role = new Role();
            role.setId(i);
            role.setName("name" + i);
            roleMapper.insert(role);
        }
        sqlSession.commit();
        System.out.println("(使用批处理）业务代码循环插入100000条数据耗时=" + (System.currentTimeMillis() - start));
    }

    @PostMapping("/insert2")
    @ApiOperation(value="batchInsert", tags = "用户接口")
    public void batchInsert() {
        SqlSession sqlSession = sqlSessionFactory.openSession(ExecutorType.BATCH);
        RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
        Long start = System.currentTimeMillis();
        Role role;
        for (int i = 0; i < 10000; i++) {
            role = new Role();
            role.setId(i);
            role.setName("name" + i);
            roleMapper.insert(role);
        }
        sqlSession.commit();
        log.info("(使用批处理）业务代码循环插入1000000条数据耗时={}" + (System.currentTimeMillis() - start));
    }*/
}
