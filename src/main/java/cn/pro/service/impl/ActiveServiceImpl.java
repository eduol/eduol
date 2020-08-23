package cn.pro.service.impl;

import cn.pro.Entity.Active;
import cn.pro.mapper.ActiveMapper;
import cn.pro.service.ActiveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ActiveServiceImpl implements ActiveService {
    @Resource
    ActiveMapper activeMapper;

    @Override
    public List<Active> findAll(int type) {
        return activeMapper.findAll(type);
    }

    @Override
    public Active findById(int id) {
        return activeMapper.findById(id);
    }

    @Override
    public int addActive(Active active) {
        return activeMapper.addActive(active);
    }

    @Override
    public int updActive(Active active) {
        return activeMapper.updActive(active);
    }
}
