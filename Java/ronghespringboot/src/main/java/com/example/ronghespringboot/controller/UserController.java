package com.example.ronghespringboot.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ronghespringboot.common.Result;
import com.example.ronghespringboot.entity.User;
import com.example.ronghespringboot.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    UserService userService = new UserService();

//    新增或者更新
    @PostMapping
    public Result save(@RequestBody User user){
        System.out.println("===c " + user);
        return Result.success(userService.saveOrUpdate(user));
    }

////    删除
//    @DeleteMapping("/{id}")
//    public Result delete(@PathVariable Integer id){
//        return Result.success(userService.removeById(id));
//    }
//
//    //    批量删除
//    @PostMapping("/del/batch")
//    public Result batchDelete(@RequestBody List<Integer> ids){
//        return Result.success(userService.removeByIds(ids));
//    }
//
////    查询所有
//    @GetMapping
//    public Result findAll(){
//        return Result.success(userService.list());
//    }
//
////    通过id查询具体某一条数据
//    @GetMapping("/{id}")
//    public Result getById(@PathVariable Integer id){
//        return Result.success(userService.getById(id));
//    }

//    分页
    @GetMapping("/page")
    public Result findPage(@RequestParam Integer pageNum,
                           @RequestParam Integer pageSize,
                           @RequestParam(defaultValue = "") String keyword){
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.orderByDesc(User::getId);

        if(StrUtil.isNotBlank(keyword)){
            queryWrapper.like(User::getUsername,keyword);
        }

        return Result.success(userService.page(new Page<>(pageNum, pageSize)));
    }
}
