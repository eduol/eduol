package cn.pro.mapper;

import cn.pro.Entity.Try;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TryMapper {
    List<Try> findAll(@Param(value = "type")int type);
    Try findById(@Param(value = "id")int id);
    int addTry(Try trys);
    int updTry(Try trys);
}
