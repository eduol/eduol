package cn.pro.service.impl;

import cn.pro.Entity.User;
import cn.pro.mapper.UserMapper;
import cn.pro.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserMapper userMapper;

    @Override
    public User login(String userName, String password) {
        return userMapper.login(userName,password);
    }
}
