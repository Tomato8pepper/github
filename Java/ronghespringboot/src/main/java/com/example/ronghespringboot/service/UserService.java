package com.example.ronghespringboot.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ronghespringboot.Exception.ServiceException;
import com.example.ronghespringboot.common.Constants;
import com.example.ronghespringboot.entity.Account;
import com.example.ronghespringboot.entity.User;
import com.example.ronghespringboot.mapper.IUserMapper;
import com.example.ronghespringboot.mapper.impl.UserDao;
import com.example.ronghespringboot.utils.TokenUtils;
import jakarta.annotation.Resource;
import org.springframework.beans.BeanUtils;

import java.util.List;


public class UserService {
    @Resource
    private IUserMapper userMapper;

    public Account login(Account account) {
        System.out.println("===s" + account);
        UserDao userDao = new UserDao();
        User userData = null;
        userData = userDao.login(account);
        User user = new User();
        System.out.println("===suserdata  " + userData);
        if(userData.getUsername() != user.getUsername()) {
            String role = "ROLE_USER";
            BeanUtils.copyProperties(userData, account);
            String token = TokenUtils.createToken(userData.getId() + "-" + role, account.getPassword());
            account.setToken(token);
            account.setRole(role);
            account.setPassword(null);
            return account;
        }else {
            throw new ServiceException(Constants.CODE_605, "用户名或密码错误");
        }
    }

    public void register(Account account) {
        System.out.println("===s" + account);
        UserDao userDao = new UserDao();
        userDao.register(account);
    }

    public Account getById(Integer id) {
        System.out.println("===sid" + id);
        UserDao userDao = new UserDao();

        Account accountData = userDao.getById(id);
        Account account = new Account();
        if(account.getUsername() != accountData.getUsername()) {
            return accountData;
        }else{
            throw new ServiceException(Constants.CODE_605, "此id没有对应的用户");
        }
    }

    public void updatePassword(Account account) {
        UserDao userDao = new UserDao();
        userDao.updatePassword(account);
    }

    public User saveOrUpdate(User user) {
        UserDao userDao = new UserDao();
        User userData = userDao.saveOrUpdate(user);
        User userNull = new User();
        if(userData.getUsername() != userNull.getUsername()) {
            return userData;
        }else {
            throw new ServiceException(Constants.CODE_605, "操作失败");
        }
    }

    public Page<User> page(Page<User> objectPage) {
//        System.out.println("===s " + objectPage);
        UserDao userDao = new UserDao();
        Page<User> userData = userDao.pageUser(objectPage);
        System.out.println("===s " + userData);
        if(userData.getTotal() != 0) {
            return userData;
        }
        throw new ServiceException(Constants.CODE_605, "查询无数据");
    }
}
