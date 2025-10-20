package com.example.ronghespringboot.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.ronghespringboot.Exception.ServiceException;
import com.example.ronghespringboot.common.Constants;
import com.example.ronghespringboot.entity.Account;
import com.example.ronghespringboot.entity.Admin;
import com.example.ronghespringboot.mapper.IAdminMapper;
import com.example.ronghespringboot.service.IAdminService;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminServiceImpl extends ServiceImpl<IAdminMapper, Admin> implements IAdminService {

    @Resource
    private IAdminMapper adminMapper;

    @Override
    public List<Admin> getUserList() {
        return adminMapper.getUserList();
    }

    @Override
    public Account login(Account account) {
//      登录就是通过账号密码查询是否有这条数据
        LambdaQueryWrapper<Admin> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Admin::getUsername, account.getUsername());
        wrapper.eq(Admin::getPassword, account.getPassword());
        Admin one = adminMapper.selectOne(wrapper);
        if(one!=null) {
            String role = "ROLE_ADMIN";
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
        LambdaQueryWrapper<Admin> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Admin::getUsername, account.getUsername());
        wrapper.eq(Admin::getPassword, account.getPassword());
        Admin one = adminMapper.selectOne(wrapper);
        if(one!=null) {
            throw new ServiceException(Constants.CODE_605, "用户名已经存在");
        }else {
            one = new Admin();
//            拷贝account到one
            BeanUtils.copyProperties(account, one);
            adminMapper.insert(one);
        }
    }
}
