package com.example.ronghespringboot.mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ronghespringboot.entity.Account;
import com.example.ronghespringboot.entity.Admin;
import com.example.ronghespringboot.entity.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.List;

public interface IConnect {
    String url = "jdbc:mysql://localhost:3306/springboot?serverTimezone=UTC";
    String username = "root"; // 数据库用户名
    String password = "root"; // 数据库密码
    default Connection getConnection() {
        Connection connection = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
        }catch(ClassNotFoundException|SQLException e){
            return null;
        }
        return connection;
    }

    /**
     * 登录
     * @param account
     * @return
     */
    Account login(Account account);

    /**
     * 注册
     * @param account
     * @return
     */
    void register(Account account);

    Account getById(Integer id);

    void updatePassword(Account account);

    Account saveOrUpdate(Account account);

    Page<User> pageUser(Page<User> page);

    Page<Admin> pageAdmin(Page<Admin> page);
}




