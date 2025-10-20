package com.example.ronghespringboot.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ronghespringboot.Exception.ServiceException;
import com.example.ronghespringboot.common.Constants;
import com.example.ronghespringboot.entity.Account;
import com.example.ronghespringboot.entity.Admin;
import com.example.ronghespringboot.entity.User;
import com.example.ronghespringboot.mapper.impl.AdminDao;
import com.example.ronghespringboot.mapper.impl.UserDao;
import com.example.ronghespringboot.utils.TokenUtils;
import org.springframework.beans.BeanUtils;

public class AdminService {

    public Account login(Account account) {
        System.out.println("===s" + account);
        AdminDao adminDao = new AdminDao();
        Admin adminData = adminDao.login(account);
        Admin admin = new Admin();
        if(adminData.getUsername() == admin.getUsername()) {
            System.out.println("===s throw");
            throw new ServiceException(Constants.CODE_605, "用户名或密码错误");
        }else {
            String role = "ROLE_ADMIN";
            BeanUtils.copyProperties(adminData, account);
            String token = TokenUtils.createToken(adminData.getId() + "-" + role, account.getPassword());
            account.setToken(token);
            account.setRole(role);
            account.setPassword(null);
            return account;
        }
    }

    public void register(Account account) {
        System.out.println("===s" + account);
        AdminDao adminDao = new AdminDao();
        adminDao.register(account);
    }

    public Account getById(int id) {
        System.out.println("===sid" + id);
        AdminDao userDao = new AdminDao();
//        Account accountData = adminMapper.getById(id);

        Account accountData = userDao.getById(id);
        Account account = new Account();
        if(account.getUsername() != accountData.getUsername()) {
            return accountData;
        }else{
            throw new ServiceException(Constants.CODE_605, "此id没有对应的用户");
        }
    }

    public void updatePassword(Account account) {
        AdminDao adminDao = new AdminDao();
        adminDao.updatePassword(account);
    }

    public Admin saveOrUpdate(Admin admin) {
        AdminDao adminDao = new AdminDao();
        Admin adminData = adminDao.saveOrUpdate(admin);
        Admin adminNull = new Admin();
        if(adminData.getUsername() != adminNull.getUsername()) {
            return adminData;
        }else {
            throw new ServiceException(Constants.CODE_605, "操作失败");
        }
    }

    public Page<Admin> page(Page<Admin> objectPage) {
//        System.out.println("===s " + objectPage);
        AdminDao adminDao = new AdminDao();
        Page<Admin> adminData = adminDao.pageAdmin(objectPage);
        System.out.println("===s " + adminData);
        if(adminData.getTotal() != 0) {
            return adminData;
        }
        throw new ServiceException(Constants.CODE_605, "查询无数据");
    }
}
