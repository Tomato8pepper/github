package com.example.ronghespringboot.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

@Data
public class Account {

    private Integer id;
    private String username;
    private String password;
    private String nickname;
    private String avatarUrl;

//    表字段不存在
    @TableField(exist = false)
    private String role;
    @TableField(exist = false)
    private String newPassword;
    @TableField(exist = false)
    private String token;
}
