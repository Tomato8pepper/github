package com.example.ronghespringboot.utils;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.ronghespringboot.entity.Account;
import com.example.ronghespringboot.service.AdminService;
import com.example.ronghespringboot.service.UserService;
import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Date;

@Component
public class TokenUtils {

    private static UserService staticUserService;
    private static AdminService staticAdminService;

    private UserService userService = new UserService();
    private AdminService adminService = new AdminService();

//    实例化后执行
    @PostConstruct
    public void initService() {
        staticUserService = userService;
        staticAdminService = adminService;
    }

//    生成token
    public static String createToken(String data, String sign) {
        return JWT.create().withAudience(data) // userId-role保存到token里作为载荷
                .withExpiresAt(DateUtil.offsetHour(new Date(), 2)) // 2hours过期
                .sign(Algorithm.HMAC256(sign)); // 密码作为token的秘钥
    }

//    需要获取当前登录的用户信息时调用
    public static Account getCurrentUser() {
        try{
            HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
            String token = request.getHeader("token");
            if (StrUtil.isNotEmpty(token)) {
                String accountInfo = JWT.decode(token).getAudience().get(0);
                String accountId = accountInfo.split("-")[0];
                String accountRole = accountInfo.split("-")[1];

                Account account = null;

                if(StrUtil.equals(accountRole, "ROLE_USER")){
                    account = staticUserService.getById(Integer.valueOf(accountId));
                }
                if(StrUtil.equals(accountRole, "ROLE_ADMIN")){
                    account = staticAdminService.getById(Integer.valueOf(accountId));
                    System.out.println("===tokenUtils" + account);
                }

//                如果成功获取到用户信息，设置角色
                if(account != null){
                    account.setRole(accountRole);
                }
                return account;
            }
        } catch (Exception e) {
            return null;
        }
        return new Account();
    }
}
