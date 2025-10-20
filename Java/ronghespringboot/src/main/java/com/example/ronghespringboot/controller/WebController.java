package com.example.ronghespringboot.controller;


import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.ronghespringboot.common.Constants;
import com.example.ronghespringboot.common.Result;
import com.example.ronghespringboot.entity.Account;
import com.example.ronghespringboot.entity.User;
import com.example.ronghespringboot.service.AdminService;
import com.example.ronghespringboot.service.IAdminService;
import com.example.ronghespringboot.service.IUserService;
import com.example.ronghespringboot.service.UserService;
import com.example.ronghespringboot.utils.TokenUtils;
import jakarta.annotation.Resource;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/web")
public class WebController {
    private static final String FILE_UPLOAD_PATH = System.getProperty("user.dir")+ File.separator + "/files/";
    @Value("${ip:localhost}")
    private String ip;
    @Value("${server.port}")
    String port;

    @Resource
    private IUserService userService;
    private IAdminService adminService;

    @GetMapping("/hello")
    private List<User> hello() {
        return userService.getUserList();
    }

    @GetMapping("/{id}")
    private User selectOneUser(@PathVariable Integer id) {
//        userService.list();
//        userService.removeById(id);

        return userService.getById(id);
    }

    @DeleteMapping ("/{id}")
    private boolean deleteOneUser(@PathVariable Integer id) {
        return userService.removeById(id);
    }

    @GetMapping("/query/{keyword}")
    private Result queryUser(@PathVariable Integer keyword) {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.like(User::getUsername, keyword);

//        return Result.error("605", "取消点赞");
        return Result.success(userService.list(wrapper));
    }



//    RequestBody可以帮我们解析前端发过来的数据对象，解析成Java的对象
    @PostMapping("/login")
    public Result login(@RequestBody Account account) {
        if(StrUtil.isBlank(account.getUsername()) || StrUtil.isBlank(account.getPassword()) || StrUtil.isBlank(account.getRole())) {
            return Result.error("605", "参数错误！");
        }

        UserService userService = new UserService();
        AdminService adminService = new AdminService();


        if(StrUtil.equals(account.getRole(), "ROLE_USER")) {
            account = userService.login(account);
        }

        if(StrUtil.equals(account.getRole(), "ROLE_ADMIN")) {
            account = adminService.login(account);
        }


        System.out.println("===c" + account);
        return Result.success(account);
    }

    @PostMapping("/register")
    public Result register(@RequestBody Account account) {
        if(StrUtil.isEmpty(account.getUsername()) || StrUtil.isEmpty(account.getPassword()) || StrUtil.isBlank(account.getRole())) {
            return Result.error("605", "参数错误！");
        }
        System.out.println("===c" + account);
        UserService userService = new UserService();
        AdminService adminService = new AdminService();

        if(StrUtil.equals(account.getRole(), "ROLE_USER")) {
            userService.register(account);
        }

        if(StrUtil.equals(account.getRole(), "ROLE_ADMIN")) {
            adminService.register(account);
        }


        return Result.success();
    }

    @PostMapping("/password")
    public Result updatePassword(@RequestBody Account account) {
        if(StrUtil.isBlank(account.getPassword()) || StrUtil.isBlank(account.getNewPassword())) {
            return Result.error("605", "参数错误！");
        }
        System.out.println("===c " + account);
        Account one = TokenUtils.getCurrentUser();

        account.setUsername(one.getUsername());
        UserService userService = new UserService();
        AdminService adminService = new AdminService();
        if(StrUtil.equals(one.getRole(), "ROLE_USER")) {
            userService.updatePassword(account);
        }
        if(StrUtil.equals(one.getRole(), "ROLE_ADMIN")) {
            adminService.updatePassword(account);
        }

        return Result.success();
    }

    @PostMapping("/upload")
    public String upload(@RequestParam MultipartFile file) throws IOException {
        String ogiginalFilename = file.getOriginalFilename();
        String type = FileUtil.extName(ogiginalFilename);

//        定义一个文件唯一的标识码
        String fileUUID = IdUtil.fastSimpleUUID() + StrUtil.DOT + type;

        File uploadFile = new File(FILE_UPLOAD_PATH + fileUUID);
        System.out.println("===uploadFile " + uploadFile);

//        判断配置文件的目录是否存在，若不存在则创建一个新的文件目录
        File parentFile = uploadFile.getParentFile();
        if(!parentFile.exists()) {
            parentFile.mkdirs();
        }

//        文件保存到磁盘
        file.transferTo(uploadFile);
//        拼接文件地址
        String url = "http://" + ip + ":" + port + "/web/download/" + fileUUID;
//        返回文件地址
        return url;
    }

    @GetMapping("/download/{fileUUID}")
    public void download(@PathVariable String fileUUID, HttpServletResponse response) throws IOException {
//        根据文件的唯一标识码获取文件
        File uploadFile = new File(FILE_UPLOAD_PATH + fileUUID);
//        设置输出流的格式
        ServletOutputStream outputStream = response.getOutputStream();
        response.addHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileUUID, "UTF-8"));
        response.setContentType("application/octet-stream");

//        读取文件的字节流
        try{
            outputStream.write(FileUtil.readBytes(uploadFile));
        }catch (Exception e){
            System.err.println("文件下载失败，文件不存在");
        }
        outputStream.flush();
        outputStream.close();
    }


    @GetMapping("/userInfo")
    public Result userInfo() {
        UserService userService = new UserService();
        AdminService adminService = new AdminService();

        Account account = TokenUtils.getCurrentUser();

        if(StrUtil.equals(account.getRole(), "ROLE_USER")) {
            return Result.success(userService.getById(account.getId()));
        }
        if(StrUtil.equals(account.getRole(), "ROLE_ADMIN")) {
            return Result.success(adminService.getById(account.getId()));
        }
        return Result.error(Constants.CODE_605, "获取用户信息失败");
    }





    @GetMapping("/test")
    public Result test() {
        String data = "用户1";
        String 验证密码1 = "123456";
        String token = createToken(data, 验证密码1);
        System.err.println(data + ":收好您的令牌:" + token);

        String 验证密码2 = "123456789";
        verifyToken(token, 验证密码2);

        System.err.println("再次输入验证码");
        verifyToken(token, 验证密码1);

        analysisToken(token);
        return Result.success();
    }








//    生成token
    public String createToken(String data, String sign) {
        return JWT.create().withAudience(data)
                .withExpiresAt(DateUtil.offsetHour(new Date(), 2))
                .sign(Algorithm.HMAC256(sign));
    }

//    验证token
    public void verifyToken(String token, String sign) {
        JWTVerifier jwtverifier = JWT.require(Algorithm.HMAC256(sign)).build();
        try{
            jwtverifier.verify(token);
        }catch (JWTVerificationException e){
            System.out.println("token验证失败");
        }
    }

//    解析token
    public void analysisToken(String token) {
        String text = JWT.decode(token).getAudience().get(0);
        System.out.println("text:" + text);
    }

}
