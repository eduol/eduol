package cn.pro.mapper;

import cn.pro.Entity.Filed;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface FieldMapper {
    int addFiled(Filed filed);
    List<Filed> findAllFiled();
    int updFiled(Filed filed);
    Filed findFiledById(@Param(value = "id")int id);
}
