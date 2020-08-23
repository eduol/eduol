package cn.pro.mapper;

import cn.pro.Entity.Active;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ActiveMapper {
    List<Active> findAll(@Param(value = "type")int type);
    Active findById(@Param(value = "id")int id);
    int addActive(Active active);
    int updActive(Active active);
}
