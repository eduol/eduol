package cn.pro.mapper;

import cn.pro.Entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User loadUserByUsername(@Param(value = "userName") String userName);
    User login(@Param(value = "userName")String userName,@Param(value = "password")String password);
}