package com.example.ronghespringboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ronghespringboot.entity.Account;
import com.example.ronghespringboot.entity.Admin;

import java.util.List;

public interface IAdminService extends IService<Admin> {
    List<Admin> getUserList();

    Account login(Account account);

    void register(Account account);
}
