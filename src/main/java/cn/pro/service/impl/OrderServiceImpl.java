package cn.pro.service.impl;

import cn.pro.Entity.Order;
import cn.pro.mapper.OrderMapper;
import cn.pro.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    OrderMapper orderMapper;
    @Override
    public List<Order> findAllNorOrder(String ordFrom, String phone, String date) {
        return orderMapper.findAllNorOrder(ordFrom,phone,date);
    }

    @Override
    public List<Order> findAllBackOrder(String phone, int status) {
        return orderMapper.findAllBackOrder(phone,status);
    }

    @Override
    public List<Order> findAllChangePlace() {
        return orderMapper.findAllChangePlace();
    }

    @Override
    public Order findOrderById(int id) {
        return orderMapper.findOrderById(id);
    }

    @Override
    public int backOrder(int id) {
        return orderMapper.backOrder(id);
    }

    @Override
    public int judOrder(int id, int status) {
        return orderMapper.judOrder(id,status);
    }

    @Override
    public int changeOrder(String teacher, int originPlace, int newPlace, int id) {
        return orderMapper.changeOrder(teacher,originPlace,newPlace,id);
    }
}
