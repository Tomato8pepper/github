package com.example.ronghespringboot.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.ronghespringboot.entity.Account;
import com.example.ronghespringboot.entity.Admin;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface IAdminMapper extends BaseMapper<Admin> {

    @Select("select * from sys_admin")
    List<Admin> getUserList();

    @Select("Select * from sys_user where id=#{id}")
    Account getById(int id);
}
