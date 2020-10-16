package com.example.transaction.controller;

import com.alibaba.fastjson.JSON;
import com.example.transaction.annotation.Idempotent;
import com.example.transaction.annotation.RemoveBlankKey;
import com.example.transaction.annotation.AutoLog;
import com.example.transaction.dao.RoleMapper;
import com.example.transaction.dto.Role;
import io.swagger.annotations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.HashMap;
import java.util.Map;

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
    @RemoveBlankKey
    public void inert1(@RequestParam("count") Integer count, @RequestParam("demo") Integer demo) {
        Long start = System.currentTimeMillis();
        Role role = new Role();
        role.setId(count);
        role.setName("name" + count);
        roleMapper.insert(role);
        log.info("耗时1={}", System.currentTimeMillis() - start);
    }


    @ApiOperation(value = "分页查询知识列表，默认按阅读数倒序排列", nickname = "getArticleList")
    @ApiImplicitParams({@ApiImplicitParam(name = "currentPage", value = "当前页数", paramType = "query", dataType = "long"),
            @ApiImplicitParam(name = "pageSize", value = "每页记录数", paramType = "query", dataType = "long"),
            @ApiImplicitParam(name = "sorter", value = "排序条件 desc-字段名或者asc-字段名", paramType = "query"),
            @ApiImplicitParam(name = "title", value = "标题", paramType = "query"),
            @ApiImplicitParam(name = "articleTypeIds", value = "知识类型id集合，用英文逗号间隔", paramType = "query"),
            @ApiImplicitParam(name = "customTypeIds", value = "自定义知识分类id集合，用英文逗号间隔", paramType = "query"),
            // @ApiImplicitParam(name = "deviceModelId", value = "设备型号id", paramType = "query"),
            @ApiImplicitParam(name = "resId", value = "资源id", paramType = "query"),
            @ApiImplicitParam(name = "resCode", value = "资源编码", paramType = "query"),
            @ApiImplicitParam(name = "channelId", value = "渠道id，当根据资源编码查询时，必填", paramType = "query"),
            @ApiImplicitParam(name = "deviceClassId", value = "设备品类id", paramType = "query"),
            @ApiImplicitParam(name = "isPublished", value = "是否已发布", paramType = "query"),
    })
    @ApiResponses(value = {@ApiResponse(code = 200, message = "操作是否成功,000000:成功，否则失败")})
    @GetMapping(path = "getList", produces = {"application/json"})
    @RemoveBlankKey
    public Role getArticleList(@ApiIgnore @RequestParam HashMap<String, Object> params) {
        System.out.println("前端传参：" + JSON.toJSONString(params));
        return new Role();
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
