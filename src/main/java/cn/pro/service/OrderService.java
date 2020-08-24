package cn.pro.service;

import cn.pro.Entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface OrderService {
    List<Order> findAllNorOrder(String ordFrom, String phone, String date);
    List<Order> findAllBackOrder(String phone,int status);
    List<Order> findAllChangePlace();
    Order findOrderById(int id);
    int backOrder(int id);
    int judOrder(int id,int status);
    int changeOrder(String teacher,int originPlace,int newPlace,int id);

}
