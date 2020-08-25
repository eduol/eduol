package cn.pro.service.impl;

import cn.pro.Entity.Filed;
import cn.pro.mapper.FieldMapper;
import cn.pro.service.FiledService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FiledServiceImpl implements FiledService {
    @Resource
    FieldMapper fieldMapper;
    @Override
    public int addFiled(Filed filed) {
        return fieldMapper.addFiled(filed);
    }

    @Override
    public List<Filed> findAllFiled() {
        return fieldMapper.findAllFiled();
    }

    @Override
    public int updFiled(Filed filed) {
        return fieldMapper.updFiled(filed);
    }

    @Override
    public Filed findFiledById(int id) {
        return fieldMapper.findFiledById(id);
    }
}
