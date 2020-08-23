package cn.pro.service.impl;

import cn.pro.Entity.Try;
import cn.pro.mapper.TryMapper;
import cn.pro.service.TryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TryServiceImpl implements TryService {
    @Resource
    TryMapper tryMapper;
    @Override
    public List<Try> findAll(int type) {
        return tryMapper.findAll(type);
    }

    @Override
    public Try findById(int id) {
        return tryMapper.findById(id);
    }

    @Override
    public int addTry(Try trys) {
        return tryMapper.addTry(trys);
    }

    @Override
    public int updTry(Try trys) {
        return tryMapper.updTry(trys);
    }
}
