package cn.pro.service;

import cn.pro.Entity.User;
import cn.pro.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

public interface UserService{

    public User login(String userName, String password);

    public List<User> findAll();
}
