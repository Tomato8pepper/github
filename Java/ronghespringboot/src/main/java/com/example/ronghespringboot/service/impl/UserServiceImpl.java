package com.example.ronghespringboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ronghespringboot.Exception.ServiceException;
import com.example.ronghespringboot.common.Constants;
import com.example.ronghespringboot.entity.Account;
import com.example.ronghespringboot.entity.User;
import com.example.ronghespringboot.mapper.IUserMapper;
import com.example.ronghespringboot.service.IUserService;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl extends ServiceImpl<IUserMapper, User> implements IUserService {

    @Resource
    private IUserMapper userMapper;

    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public Account login(Account account) {
//      登录就是通过账号密码查询是否有这条数据
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, account.getUsername());
        wrapper.eq(User::getPassword, account.getPassword());
        System.out.println("===s wrapper" + account);
        User one = userMapper.selectOne(wrapper);
        System.out.println("===s one" + one);
        if(one!=null) {
            String role = "ROLE_USER";
            BeanUtils.copyProperties(one, account);
            account.setRole(role);
            account.setPassword(null);
            return account;
        }else {
            throw new ServiceException(Constants.CODE_605, "用户名或者密码错误");
        }

    }

    @Override
    public void register(Account account) {
//        保证用户不重复
        System.out.println("===s" + account);
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername, account.getUsername());
        wrapper.eq(User::getPassword, account.getPassword());
        User one = userMapper.selectOne(wrapper);
        if(one!=null) {
            throw new ServiceException(Constants.CODE_605, "用户名已经存在");
        }else {
            one = new User();
//            拷贝account到one
            BeanUtils.copyProperties(account, one);
            userMapper.insert(one);
        }
    }
}
