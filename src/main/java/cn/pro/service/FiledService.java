package cn.pro.service;

import cn.pro.Entity.Filed;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FiledService {
    int addFiled(Filed filed);
    List<Filed> findAllFiled();
    int updFiled(Filed filed);
    Filed findFiledById(int id);
}
