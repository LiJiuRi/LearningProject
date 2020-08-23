package com.example.transaction.controller;

import com.example.transaction.dao.RoleMapper;
import com.example.transaction.dto.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liXu
 */
@RestController
@RequestMapping(value = "/map")
public class Transactional {
    @Autowired
    private RoleMapper roleMapper;

    @RequestMapping("/a")
    public String map(){
        return "hh";
    }

    @org.springframework.transaction.annotation.Transactional(rollbackFor = IndexOutOfBoundsException.class)
    @RequestMapping("/update")
    public Role update(){
        Role role = new Role();
        role.setId(1);
        role.setName("new");
        roleMapper.updateByPrimaryKey(role);
        List<String> list = new ArrayList<>();
        list.get(4);
        return roleMapper.selectByPrimaryKey(1);
    }
}
