package cn.pro.controller;

import cn.pro.Entity.Dto;
import cn.pro.Entity.User;
import cn.pro.service.UserService;
import cn.pro.utils.DtoUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(value = "登录api")
@RestController
public class loginController {
    @Autowired
    UserService userService;


    @ApiOperation(value = "登录",httpMethod = "GET")
    @RequestMapping("/logins")
    public Dto log(@RequestParam(value = "userName") String userName,@RequestParam(value = "password")  String password){
        User user = userService.login(userName,password);
        if (user!=null){
            return DtoUtil.returnSuccess("登录成功",user);
        }else {
            return DtoUtil.returnFail("登陆失败","10086");
        }
    }
}
