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

public class UserDao implements IConnect {

    @Override
    public User login(Account account) {
        Connection connection = getConnection();
        if(connection == null){
            return null;
        }
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        User userData = new User();
        try{
            System.out.println("===d" + account.getUsername() + account.getPassword());
            String sql = "select * from sys_user where username =? and password =?;";
//            System.out.println("===dsql" + sql.toString() + user.getUsername() + user.getPassword());
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,account.getUsername());
            preparedStatement.setString(2,account.getPassword());
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
//                System.out.println(resultSet.getString("username"));
//                System.out.println(resultSet.getString("password"));
                userData.setId(resultSet.getInt("id"));
                userData.setUsername(resultSet.getString("username"));
                userData.setPassword(resultSet.getString("password"));
                userData.setNickname(resultSet.getString("nickname"));
                userData.setAvatarUrl(resultSet.getString("avatar_url"));
                System.out.println("dao== " + userData);
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
        return userData;
    }

    @Override
    public void register(Account account) {
        User userData = this.login(account);
        User user = new User();
        if(userData.getUsername() != user.getUsername()){
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
            String sql = "insert into sys_user(username,password) values(?,?);";
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
        User userData = new User();
        try{
            String sql = "select * from sys_user where id =?;";
//            System.out.println("===dsql" + sql.toString() + user.getUsername() + user.getPassword());
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
//                System.out.println(resultSet.getString("username"));
//                System.out.println(resultSet.getString("password"));
                userData.setId(resultSet.getInt("id"));
                userData.setUsername(resultSet.getString("username"));
                userData.setPassword(resultSet.getString("password"));
                userData.setNickname(resultSet.getString("nickname"));
                userData.setAvatarUrl(resultSet.getString("avatar_url"));
                System.out.println("dao== " + userData);
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
        return userData;
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
            String sql = "update sys_user set password =? where username =?;";
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
    public User saveOrUpdate(Account account) {
        Connection connection = getConnection();
        if(connection == null){
            return null;
        }
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        User userData = new User();
        try{
            String sql = "update sys_user set username=?,nickname=?,avatar_url=? where id=?;";
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1,account.getUsername());
            preparedStatement.setString(2,account.getNickname());
            preparedStatement.setString(3,account.getAvatarUrl());
            preparedStatement.setInt(4,account.getId());
            int rows = preparedStatement.executeUpdate();
            if(rows > 0) {
                BeanUtils.copyProperties(account, userData);
                return userData;
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
    public Page<User> pageUser(Page<User> objectPage) {
        Connection connection = getConnection();
        if(connection == null){
            return null;
        }
        ResultSet resultSet = null;
        PreparedStatement preparedStatement = null;
        List<User> userList = new ArrayList<>();
        try{
            String sql = "select * from sys_user;";
//            System.out.println("===dsql" + sql.toString() + user.getUsername() + user.getPassword());
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while(resultSet.next()){
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setNickname(resultSet.getString("nickname"));
                user.setAvatarUrl(resultSet.getString("avatar_url"));
                userList.add(user);
                System.out.println("dao== " + userList);
            }
            objectPage.setRecords(userList);
            objectPage.setTotal(userList.size());
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

    @Override
    public Page<Admin> pageAdmin(Page<Admin> page) {
        return null;
    }
}
