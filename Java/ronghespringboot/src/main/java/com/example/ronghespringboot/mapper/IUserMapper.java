package com.example.ronghespringboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ronghespringboot.entity.Account;
import org.apache.ibatis.annotations.Select;
import com.example.ronghespringboot.entity.User;

import java.util.List;


public interface IUserMapper extends BaseMapper<User> {

    @Select("select * from sys_user")
    List<User> getUserList();

    @Select("Select * from sys_user where id=#{id}")
    Account getById(Integer id);
}
