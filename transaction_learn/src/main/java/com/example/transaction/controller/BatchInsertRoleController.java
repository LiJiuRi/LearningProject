package com.example.transaction.controller;

import com.example.transaction.annotation.Idempotent;
import com.example.transaction.dao.RoleMapper;
import com.example.transaction.dto.Role;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: liXu
 * @Date: 2019/12/8 19:37
 * @Description:
 */
@Slf4j
@RestController
@Api(description = "用户", tags = "用户")
@RequestMapping("/batch")
public class BatchInsertRoleController {
    @Autowired
    RoleMapper roleMapper;

    @GetMapping("insert1")
    @ApiOperation(value = "测试aop", tags = "用户")
    public void inert1(@RequestParam("count") Integer count, @RequestParam("demo") Integer demo) {
        Long start = System.currentTimeMillis();
        Role role = new Role();
        role.setId(count);
        role.setName("name" + count);
        roleMapper.insert(role);
        log.info("耗时1={}", System.currentTimeMillis() - start);
    }

    @GetMapping("insert2")
    @ApiOperation(value = "测试aop", tags = "用户")
    @Idempotent
    public void inert2(@RequestParam("count") Integer count) {
        Long start = System.currentTimeMillis();
        Role role = new Role();
        role.setName("name" + count);
        roleMapper.insert(role);
        log.info("耗时2={}", System.currentTimeMillis() - start);
    }

}
