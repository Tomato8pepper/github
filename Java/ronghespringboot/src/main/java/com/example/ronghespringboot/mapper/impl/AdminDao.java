package com.example.ronghespringboot.mapper.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.ronghespringboot.Exception.DaoException;
import com.example.ronghespringboot.common.Constants;
import com.example.ronghespringboot.entity.Account;
import com.example.ronghespringboot.entity.Admin;
import com.example.ronghespringboot.entity.User;
import com.example.ronghespringboot.mapper.IConnect;
import org.springframework.beans.BeanUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDao implements IConnect {

    @Override
    public Admin login(Account account) {
        Connection connection = getConnection();
        if(connection == null){
            return null;
        }
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try{
            System.out.println("===d" + account.getUsername() + account.getPassword());
            String sql = "select * from sys_admin where username =? and password =?;";
//            System.out.println("===dsql" + sql.toString() + user.getUsername() + user.getPassword());
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,account.getUsername());
            preparedStatement.setString(2,account.getPassword());
            resultSet = preparedStatement.executeQuery();
            Admin adminData = new Admin();
            while(resultSet.next()){
//                System.out.println(resultSet.getString("username"));
//                System.out.println(resultSet.getString("password"));
                adminData.setId(resultSet.getInt("id"));
                adminData.setUsername(resultSet.getString("username"));
                adminData.setPassword(resultSet.getString("password"));
                adminData.setNickname(resultSet.getString("nickname"));
                adminData.setAvatarUrl(resultSet.getString("avatar_url"));
                System.out.println("dao== " + adminData);
            }
            return adminData;

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(resultSet != null){
                    resultSet.close();
                }
                if(preparedStatement != null){
                    preparedStatement.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }

        }
        return null;
    }

    @Override
    public void register(Account account) {
        Admin adminData = this.login(account);
        Admin admin = new Admin();
//        没有数据可以注册
        if(adminData.getUsername() != admin.getUsername()){
            throw new DaoException(Constants.CODE_605, "该账号已经注册！");
        }

        Connection connection = getConnection();
        if(connection == null){
            return;
        }
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try{
            System.out.println("===d" + account.getUsername() + account.getPassword());
            String sql = "insert into sys_admin(username,password) values(?,?);";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,account.getUsername());
            preparedStatement.setString(2,account.getPassword());
            int rows = preparedStatement.executeUpdate();
            System.out.println("rows:" + rows);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(resultSet != null){
                    resultSet.close();
                }
                if(preparedStatement != null){
                    preparedStatement.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }

        }
    }

    @Override
    public Account getById(Integer id) {
        Connection connection = getConnection();
        if(connection == null){
            return null;
        }
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        Admin adminData = new Admin();
        try{
            String sql = "select * from sys_admin where id =?;";
//            System.out.println("===dsql" + sql.toString() + user.getUsername() + user.getPassword());
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
//                System.out.println(resultSet.getString("username"));
//                System.out.println(resultSet.getString("password"));
                adminData.setId(resultSet.getInt("id"));
                adminData.setUsername(resultSet.getString("username"));
                adminData.setPassword(resultSet.getString("password"));
                adminData.setNickname(resultSet.getString("nickname"));
                adminData.setAvatarUrl(resultSet.getString("avatar_url"));
                System.out.println("dao== " + adminData);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(resultSet != null){
                    resultSet.close();
                }
                if(preparedStatement != null){
                    preparedStatement.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return adminData;
    }

    @Override
    public void updatePassword(Account account) {
        Connection connection = getConnection();
        if(connection == null){
            return;
        }
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        try{
            System.out.println("===d" + account.getUsername() + account.getPassword());
            String sql = "update sys_admin set password =? where username =?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,account.getNewPassword());
            preparedStatement.setString(2,account.getUsername());
            int rows = preparedStatement.executeUpdate();
            System.out.println("rows:" + rows);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(resultSet != null){
                    resultSet.close();
                }
                if(preparedStatement != null){
                    preparedStatement.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }

        }
    }

    @Override
    public Admin saveOrUpdate(Account account) {
        Connection connection = getConnection();
        if(connection == null){
            return null;
        }
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        Admin adminData = new Admin();
        try{
            String sql = "update sys_admin set username=?,nickname=?,avatar_url=? where id=?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,account.getUsername());
            preparedStatement.setString(2,account.getNickname());
            preparedStatement.setString(3,account.getAvatarUrl());
            preparedStatement.setInt(4,account.getId());
            int rows = preparedStatement.executeUpdate();
            if(rows > 0) {
                BeanUtils.copyProperties(account, adminData);
                return adminData;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(resultSet != null){
                    resultSet.close();
                }
                if(preparedStatement != null){
                    preparedStatement.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public Page<User> pageUser(Page<User> page) {
        return null;
    }

    @Override
    public Page<Admin> pageAdmin(Page<Admin> objectPage) {
        Connection connection = getConnection();
        if(connection == null){
            return null;
        }
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        List<Admin> adminList = new ArrayList<>();
        try{
            String sql = "select * from sys_admin;";
//            System.out.println("===dsql" + sql.toString() + user.getUsername() + user.getPassword());
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                Admin admin = new Admin();
                admin.setId(resultSet.getInt("id"));
                admin.setUsername(resultSet.getString("username"));
                admin.setNickname(resultSet.getString("nickname"));
                admin.setAvatarUrl(resultSet.getString("avatar_url"));
                adminList.add(admin);
            }
            objectPage.setRecords(adminList);
            objectPage.setTotal(adminList.size());
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try{
                if(resultSet != null){
                    resultSet.close();
                }
                if(preparedStatement != null){
                    preparedStatement.close();
                }
            }catch (SQLException e){
                e.printStackTrace();
            }
        }
        return objectPage;
    }

}
