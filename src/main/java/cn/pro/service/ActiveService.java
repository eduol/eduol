package cn.pro.service;

import cn.pro.Entity.Active;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ActiveService {
    List<Active> findAll(int type);
    Active findById(int id);
    int addActive(Active active);
    int updActive(Active active);
}
