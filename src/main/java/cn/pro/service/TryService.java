package cn.pro.service;

import cn.pro.Entity.Try;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TryService {
    List<Try> findAll(int type);
    Try findById(int id);
    int addTry(Try trys);
    int updTry(Try trys);
}
