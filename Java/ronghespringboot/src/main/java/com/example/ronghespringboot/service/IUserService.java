package com.example.ronghespringboot.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.ronghespringboot.entity.Account;
import com.example.ronghespringboot.entity.User;

import java.util.List;

public interface IUserService extends IService<User> {
    List<User> getUserList();

    Account login(Account account);

    void register(Account account);
}
